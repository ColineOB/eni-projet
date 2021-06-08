package fr.eni.projet.bll;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {
	private  UtilisateurDAO utilisateurDAO;
	
	
	public UtilisateurManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur ValiderUtilisateurMotDePasse(String login, String password) throws BusinessException, SQLException{
		return this.utilisateurDAO.ValiderPseudoPassword(login, password);
	}
	
	public Utilisateur ValiderEmailMotDePasse(String email, String password) throws BusinessException, SQLException{
		return this.utilisateurDAO.ValiderEmailPassword(email, password);
	}



}