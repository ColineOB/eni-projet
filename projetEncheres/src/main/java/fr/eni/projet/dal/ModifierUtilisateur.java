package fr.eni.projet.dal;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public  interface ModifierUtilisateur {
	public void supprimeUtilisateur(Utilisateur utilisateur) throws BusinessException, SQLException;
}
