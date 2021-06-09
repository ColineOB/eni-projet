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
	private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs where no_utilisateur=?";
	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS where no_utilisateur = ?";


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
	public Utilisateur selectUtilisateurById(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);

			pstmt.setInt(1, noUtilisateur);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), 
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_DETAIL_UTILISATEUR_ECHEC);
			throw businessException;
		}
		return utilisateur;
	}
	
	//supression du compte
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
	//modification de l'utilisateur
}

