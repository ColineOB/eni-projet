package fr.eni.projet.dal;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur ValiderPseudoPassword(String login, String password) throws BusinessException, SQLException;
	public Utilisateur ValiderEmailPassword(String email, String password) throws BusinessException, SQLException;
	public Utilisateur supprimeUtilisateur(int no_utilisateur)throws BusinessException, SQLException;
	public Utilisateur selectUtilisateurById(int noUtilisateur) throws BusinessException ;
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public boolean verifMail(String email);
	public boolean verifPseudo (String pseudo);
}
