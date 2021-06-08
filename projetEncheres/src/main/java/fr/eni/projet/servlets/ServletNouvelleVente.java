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
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	

//	@Override
//	public void init() throws ServletException {
//		/*Ou liste écrite dans le fichier web.xml*/
//		String chaineCategorie = this.getServletContext().getInitParameter("CATEGORIESNOUVELLEVENTE");
//		List<String> categories = Arrays.asList(chaineCategorie.split(","));
//		
//		
//		this.getServletContext().setAttribute("categories", categories);
//		super.init();
//	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager categorieManager = new CategorieManager();
		try {
			request.setAttribute("categorie", categorieManager.selectionnerCategories());
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> listeCodesErreur=new ArrayList<>();
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		LocalDateTime dateDebutEncheres = null;
		LocalDateTime dateFinEncheres = null;
		int miseAPrix = Integer.parseInt(request.getParameter("prix"));
		//A MODIFIER 
		int noUtilisateur = 1;
		int noCategorie = Integer.parseInt(request.getParameter("selectCategorie"));
		
	
		//lecture date
		try	{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			dateDebutEncheres = LocalDateTime.parse(request.getParameter("debutEnchere"), dtf);
		}
		catch(DateTimeParseException e)
		{
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_DATE_DEBUT_ERREUR);
		}
		
		
		try	{
			DateTimeFormatter dtff = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			dateFinEncheres = LocalDateTime.parse(request.getParameter("finEnchere"), dtff);
		}
		catch(DateTimeParseException e)
		{
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_DATE_FIN_ERREUR);
		}
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		noUtilisateur = utilisateur.getNoUtilisateur();
		
		System.out.println("nom article: "+nomArticle);
		System.out.println("description: "+description);
		System.out.println("date de début: "+dateDebutEncheres);
		System.out.println("date de fin: "+dateFinEncheres);
		System.out.println("mise a prix: "+miseAPrix);
		System.out.println("no utilisateur: "+noUtilisateur);
		System.out.println("no categorie: "+noCategorie);
		

		//Réalisation du traitement
		if(listeCodesErreur.size()>0)
		{
			//Je renvoie les codes d'erreurs
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
			rd.forward(request, response);
		}
		else
		{
			//J'ajoute le repas
			ArticleManager articleManager = new ArticleManager();
			try {
				articleManager.ajouterNouvelArticle(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, noUtilisateur, noCategorie);
				//Si tout se passe bien, je vais vers la page de consultation:
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			} catch (BusinessException e) {
				//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
				rd.forward(request, response);
			}
			
		}
	}

}
