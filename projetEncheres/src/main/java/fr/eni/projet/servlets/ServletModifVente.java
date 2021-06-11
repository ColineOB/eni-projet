package fr.eni.projet.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.ArticleManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletModifVente
 */
@WebServlet("/ServletModifVente")
public class ServletModifVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		int noArticle = Integer.parseInt(request.getParameter("no"));
		ArticleManager articleManager = new ArticleManager();
		ArticleVendu article = null;
		CategorieManager categorieManager = new CategorieManager();
		Categorie categorie = null;
		Categorie categorieArticle = null;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur user = null;
		try {
			article = articleManager.selectionnerArticleById(noArticle);
			categorieArticle = categorieManager.selectionnerCategorieById(article.getNoCategorie());
			user = utilisateurManager.selectionnerUtilisateurById(article.getNoUtilisateur());
			request.setAttribute("categorie", categorieManager.selectionnerCategories());

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("article", article);
		request.setAttribute("categorieArticle", categorieArticle);
		request.setAttribute("user", user);
		rd = request.getRequestDispatcher("/WEB-INF/ModifVente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> listeCodesErreur = new ArrayList<>();
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		LocalDateTime dateDebutEncheres = null;
		LocalDateTime dateFinEncheres = null;
		int miseAPrix = Integer.parseInt(request.getParameter("prix"));
		// A MODIFIER
		int noUtilisateur = 1;
		int noCategorie = Integer.parseInt(request.getParameter("selectCategorie"));

		// lecture date
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			dateDebutEncheres = LocalDateTime.parse(request.getParameter("debutEnchere"), dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_DATE_DEBUT_ERREUR);
		}

		try {
			DateTimeFormatter dtff = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			dateFinEncheres = LocalDateTime.parse(request.getParameter("finEnchere"), dtff);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_DATE_FIN_ERREUR);
		}
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		noUtilisateur = utilisateur.getNoUtilisateur();

		System.out.println("nom article: " + nomArticle);
		System.out.println("description: " + description);
		System.out.println("date de début: " + dateDebutEncheres);
		System.out.println("date de fin: " + dateFinEncheres);
		System.out.println("mise a prix: " + miseAPrix);
		System.out.println("no utilisateur: " + noUtilisateur);
		System.out.println("no categorie: " + noCategorie);

		// Réalisation du traitement
		if (listeCodesErreur.size() > 0) {
			// Je renvoie les codes d'erreurs
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifVente.jsp");
			rd.forward(request, response);
		} else {
			// J'ajoute le repas
			ArticleManager articleManager = new ArticleManager();
			try {
				ArticleVendu article = articleManager.modifierNouvelArticle(nomArticle, description, dateDebutEncheres, dateFinEncheres,
						miseAPrix, noUtilisateur, noCategorie);
				
				CategorieManager categorieManager = new CategorieManager();
				Categorie categorie = null;
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				Utilisateur user = null;
				try {
					categorie = categorieManager.selectionnerCategorieById(article.getNoCategorie());
					user = utilisateurManager.selectionnerUtilisateurById(article.getNoUtilisateur());

				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("article", article);
				request.setAttribute("categorie", categorie);
				request.setAttribute("user", user);
				// Si tout se passe bien, je vais vers la page de consultation:
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifVente.jsp");
				rd.forward(request, response);
			} catch (BusinessException e) {
				// Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				e.printStackTrace();
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifVente.jsp");
				rd.forward(request, response);
			}

		}
	}
}
