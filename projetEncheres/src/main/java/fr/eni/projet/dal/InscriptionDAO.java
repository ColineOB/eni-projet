package fr.eni.projet.dal;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public interface InscriptionDAO {
	public void inscrireUtilisateur(Utilisateur utilisateur) throws BusinessException, SQLException;
	public boolean verifMail(String email);
	public boolean verifPseudo (String pseudo);

}
