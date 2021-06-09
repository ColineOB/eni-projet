package fr.eni.projet.bll;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

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


}