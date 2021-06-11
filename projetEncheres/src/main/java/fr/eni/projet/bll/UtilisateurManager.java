package fr.eni.projet.bll;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;
import fr.eni.projet.servlets.CodesResultatServlets;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ValiderUtilisateurMotDePasse(String login, String password)
			throws BusinessException, SQLException {
		return this.utilisateurDAO.ValiderPseudoPassword(login, password);
	}

	public Utilisateur ValiderEmailMotDePasse(String email, String password) throws BusinessException, SQLException {
		return this.utilisateurDAO.ValiderEmailPassword(email, password);
	}


	public Utilisateur modifierUtilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String tel,
			String rue, String codePostal, String ville, String mdp) throws BusinessException, SQLException {
		BusinessException exception = new BusinessException();
		this.validerPseudoAlphanum(pseudo, exception);
		this.verifMailBoolean(email, exception);
		this.verifPseudoBoolean(pseudo, exception);
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		user.setNoUtilisateur(no_utilisateur);
		user.setPseudo(pseudo);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setTelephone(tel);
		user.setRue(rue);
		user.setCodePostal(codePostal);
		user.setVille(ville);
		user.setMotDePasse(mdp);
		return this.utilisateurDAO.modifierUtilisateur(user);
	}



	public Utilisateur selectionnerUtilisateurById(int noUtilisateur) throws BusinessException {
		return this.utilisateurDAO.selectUtilisateurById(noUtilisateur);
	}

	public Utilisateur supprimerUtilisateur(int no_utilisateur)  throws BusinessException, SQLException {
		return this.utilisateurDAO.supprimeUtilisateur(no_utilisateur);
	}
	
	private void validerPseudoAlphanum(String pseudo, BusinessException exception) {
		
	    for (int i=0; i<pseudo.length(); i++) {
	        char c = pseudo.charAt(i);
	        if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
	        	exception.ajouterErreur(CodesResultatServlets.PSEUDO_ALPHANUMERIQUE);
	    }
	}
	private void verifMailBoolean(String email, BusinessException exception) {
		if(!utilisateurDAO.verifMail(email)) {
			exception.ajouterErreur(CodesResultatDAL.EMAIL_DEJA_PRIS);
		}
	}
	private void verifPseudoBoolean(String pseudo, BusinessException exception) {
		if(!utilisateurDAO.verifPseudo(pseudo)) {
			exception.ajouterErreur(CodesResultatDAL.PSEUDO_DEJA_PRIS);
		}
	}


}