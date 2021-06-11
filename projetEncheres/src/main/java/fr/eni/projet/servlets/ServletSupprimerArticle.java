package fr.eni.projet.servlets;

import java.io.IOException;

import fr.eni.projet.bll.ArticleManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSupprimerArticle
 */
@WebServlet("/ServletSupprimerArticle")
public class ServletSupprimerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		// lecture des parametres
		int noArticle = Integer.parseInt(request.getParameter("no"));
		ArticleManager articleManager = new ArticleManager();
       	try {
       		ArticleVendu article = articleManager.supprimerNouvelArticle(noArticle);
       		response.sendRedirect(request.getContextPath() + "/ServletAccueil");
       	}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
