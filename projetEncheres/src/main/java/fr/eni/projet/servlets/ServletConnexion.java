package fr.eni.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");
		request.setAttribute("messageErreur", message);
		rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("login");
		String motDePasse = request.getParameter("pass");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			if (identifiant.contains("@")) {
				Utilisateur utilisateur = utilisateurManager.ValiderEmailMotDePasse(identifiant, motDePasse);
				if (utilisateur != null) {
					HttpSession session = request.getSession();
					session.setAttribute("utilisateur", utilisateur);
					response.sendRedirect(request.getContextPath() + "/ServletAccueil");
				} else {
					String message = "Les données saisies sont incorrectes. Veuillez les vérifier et réessayer.";
					request.setAttribute("messageErreur", message);
					rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
					rd.forward(request, response);
				}
			} else {
				Utilisateur utilisateur = utilisateurManager.ValiderUtilisateurMotDePasse(identifiant, motDePasse);
				if (utilisateur != null) {
					HttpSession session = request.getSession();
					session.setAttribute("utilisateur", utilisateur);
					response.sendRedirect(request.getContextPath() + "/ServletAccueil");
				} else {
					String message = "Les données saisies sont incorrectes. Veuillez les vérifier et réessayer.";
					request.setAttribute("messageErreur", message);
					rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
					rd.forward(request, response);
				}
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		String res = (String) request.getParameter("seSouvenirDeMoi");

		if (res != null) {
			System.out.println("case coché");
			Cookie cookieLogin = new Cookie("identifiant", identifiant);
			cookieLogin.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookieLogin);
			Cookie cookiePassword = new Cookie("password", motDePasse);
			cookiePassword.setMaxAge(60 * 60 * 24 * 100);
			response.addCookie(cookiePassword);
		}
	}
}
