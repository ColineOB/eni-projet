package fr.eni.projet.servlets;

import java.io.IOException;

import fr.eni.projet.BusinessException;
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
 * Servlet implementation class ServletRedirectionModifDetailVente
 */
@WebServlet("/ServletRedirectionModifDetailVente")
public class ServletRedirectionModifDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		int noArticle = Integer.parseInt(request.getParameter("no"));
		ArticleManager articleManager = new ArticleManager();
		ArticleVendu article = null;
		try {
			article = articleManager.selectionnerArticleById(noArticle);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("noUtilisateur Session " + utilisateur.getNoUtilisateur());
		System.out.println("noUtilisateur article " + article.getNoUtilisateur());
		
		if(utilisateur.getNoUtilisateur() == article.getNoUtilisateur()) {
			response.sendRedirect(request.getContextPath() + "/ServletModifVente?no="+noArticle);
		}else {
			response.sendRedirect(request.getContextPath() + "/ServletDetailVente?no="+noArticle);
		}
	}

	

}
