package fr.eni.projet.servlets;

import java.io.IOException;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class ServletSupprimerProfil
 */
@WebServlet("/ServletSupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL_REDIRECTION = "http://localhost:8080/projetEncheres/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		// lecture des parametres
		int no_utilisateur = utilisateur.getNoUtilisateur();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
       	try {
       		utilisateur = utilisateurManager.supprimerUtilisateur(no_utilisateur);
       		
            session.invalidate();
            response.sendRedirect( URL_REDIRECTION );
       	}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
