package fr.eni.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.InscriptionManager;
import fr.eni.projet.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String CHAMP_PSEUDO = "pseudo";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_TEL = "tel";
	public static final String CHAMP_RUE = "rue";
	public static final String CHAMP_CP = "cp";
	public static final String CHAMP_VILLE = "ville";
	public static final String CHAMP_MDP = "mdp";
	public static final String CHAMP_CONFIRMATION = "confirmation";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Integer> listeCodesErreur=new ArrayList<>();
		// lecture des parametres
		String pseudo = request.getParameter(CHAMP_PSEUDO);
		String mdp = request.getParameter(CHAMP_MDP);
		String confirmation = request.getParameter(CHAMP_CONFIRMATION);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String tel = request.getParameter(CHAMP_TEL);
		String rue = request.getParameter(CHAMP_RUE);
		String codePostal = request.getParameter(CHAMP_CP);
		String ville = request.getParameter(CHAMP_VILLE);

		try {
			if(pseudo.trim().isEmpty()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			//verification si le mot de passe est identique à la confirmation
		if ( !mdp.equals( confirmation ) ) {
			listeCodesErreur.add(CodesResultatServlets.MDP_DIFFERENT_CONFIRMATION);
        }
		if ( mdp.length() <= 3 ) {
        	listeCodesErreur.add(CodesResultatServlets.MDP_3_CARACTERES);
        }
		
		
		//Réalisation du traitement
		if(listeCodesErreur.size()>0)
		{
			//Je renvoie les codes d'erreurs
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
			rd.forward(request, response);
		}
		else
		{
					//ajout de l'utilisateur
	       InscriptionManager inscriptionManager = new InscriptionManager();
	       	try {
	       		Utilisateur utilisateur = inscriptionManager.inscrireUtilisateur(pseudo, nom, prenom, email, tel, rue, codePostal, ville, mdp, 0, false);
	       			//connection de l'utilisateur (A FAIRE)
	       		HttpSession session = request.getSession();
				session.setAttribute("utilisateur", utilisateur);
	       		RequestDispatcher rd = request.getRequestDispatcher("/ServletAccueil");
				rd.forward(request, response);
			} catch (BusinessException | SQLException e) {
				//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
			}
		}
	}

}
