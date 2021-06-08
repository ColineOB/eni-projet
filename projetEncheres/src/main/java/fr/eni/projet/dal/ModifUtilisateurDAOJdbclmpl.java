package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public class ModifUtilisateurDAOJdbclmpl implements ModifUtilisateurDAO {
	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS where no_utilisateur = ?";
	
	public void supprimeUtilisateur(Utilisateur utilisateur) throws BusinessException {
		try {  
			
	        Connection cnx = ConnectionProvider.getConnection();
	        PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);
	        pstmt.setInt(1, utilisateur.getNoUtilisateur());
	        pstmt.executeUpdate(); 
	    } catch(Exception e) {
	        System.out.println(e);
	    }
	}
}
