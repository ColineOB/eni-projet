package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String SELECT_VERIF_PSEUDO = "SELECT * FROM utilisateurs where pseudo=? and mot_de_passe=?";
	private static final String SELECT_VERIF_EMAIL = "SELECT * FROM utilisateurs where email=? and mot_de_passe=?";

	@Override
	public Utilisateur ValiderPseudoPassword(String login, String password) throws BusinessException, SQLException {
		if (login == null || password == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.VERIFIER_LOGIN_MDP_NULL);
			throw businessException;
		} else {
		
				Connection cnx = ConnectionProvider.getConnection();
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;

				pstmt = cnx.prepareStatement(SELECT_VERIF_PSEUDO);
				pstmt.setString(1, login);
				pstmt.setString(2, password);

				rs = pstmt.executeQuery();
				
				Utilisateur user = null;
				 
			        if (rs.next()) {
			            user = new Utilisateur();
			            user.setNoUtilisateur(rs.getInt("no_utilisateur"));
			            user.setPseudo(rs.getString("pseudo"));
			            user.setNom(rs.getString("nom"));
			            user.setPrenom(rs.getString("prenom"));
			            user.setEmail(rs.getString("email"));
			            user.setTelephone(rs.getString("telephone"));
			            user.setRue(rs.getString("rue"));
			            user.setCodePostal(rs.getString("code_postal"));
			            user.setVille(rs.getString("ville"));
			            user.setCredit(rs.getInt("credit"));
			        }
			 
			        cnx.close();
			 
			        return user;
		}
	}

	@Override
	public Utilisateur ValiderEmailPassword(String email, String password) throws BusinessException, SQLException {
		if (email == null || password == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.VERIFIER_LOGIN_MDP_NULL);
			throw businessException;
		} else {
		
				Connection cnx = ConnectionProvider.getConnection();
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;

				pstmt = cnx.prepareStatement(SELECT_VERIF_EMAIL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				rs = pstmt.executeQuery();
				
				Utilisateur user = null;
				 
			        if (rs.next()) {
			            user = new Utilisateur();
			            user.setPseudo(rs.getString("pseudo"));
			            user.setNom(rs.getString("nom"));
			            user.setPrenom(rs.getString("prenom"));
			            user.setEmail(rs.getString("email"));
			            user.setTelephone(rs.getString("telephone"));
			            user.setRue(rs.getString("rue"));
			            user.setCodePostal(rs.getString("code_postal"));
			            user.setVille(rs.getString("ville"));
			            user.setCredit(rs.getInt("credit"));
			        }
			 
			        cnx.close();
			 
			        return user;
		}
	}
}

