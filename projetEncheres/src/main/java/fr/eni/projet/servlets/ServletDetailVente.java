package fr.eni.projet.servlets;

import java.io.IOException;

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
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {
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
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur user = null;
		try {
			article = articleManager.selectionnerArticleById(noArticle);
			categorie = categorieManager.selectionnerCategorieById(article.getNoCategorie());
			user = utilisateurManager.selectionnerUtilisateurById(article.getNoUtilisateur());

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("article", article);
		request.setAttribute("categorie", categorie);
		request.setAttribute("user", user);
		rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
		rd.forward(request, response);
		rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int noArticle = Integer.parseInt(request.getParameter("no"));
		// String noArticle = request.getParameter("noArticle");
		String test = "test d'impression EL";
		ArticleManager articleManager = new ArticleManager();
		ArticleVendu article = null;
		CategorieManager categorieManager = new CategorieManager();
		Categorie categorie = null;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur user = null;
		try {
			article = articleManager.selectionnerArticleById(noArticle);
			categorie = categorieManager.selectionnerCategorieById(article.getNoCategorie());
			user = utilisateurManager.selectionnerUtilisateurById(article.getNoUtilisateur());

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("nomArticle", article.getNomArticle());
		request.setAttribute("categorie", categorie);
		request.setAttribute("user", user);
		request.setAttribute("noArticle", noArticle);
		request.setAttribute("test", test);
		rd = request.getRequestDispatcher("/WEB-INF/DetailVente.jsp");
		rd.forward(request, response);
	}

}
