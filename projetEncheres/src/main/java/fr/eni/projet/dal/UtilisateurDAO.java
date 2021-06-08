package fr.eni.projet.dal;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur ValiderPseudoPassword(String login, String password) throws BusinessException, SQLException;
	public Utilisateur ValiderEmailPassword(String email, String password) throws BusinessException, SQLException;
	public void supprimeUtilisateur(Utilisateur utilisateur)throws BusinessException, SQLException;
}
