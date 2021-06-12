package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String SELECT_VERIF_PSEUDO = "SELECT * FROM utilisateurs where pseudo=? and mot_de_passe=?";
	private static final String SELECT_VERIF_EMAIL = "SELECT * FROM utilisateurs where email=? and mot_de_passe=?";
	private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs where no_utilisateur=?";
	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS where no_utilisateur = ? ";
	private static final String UPDATE_UTILISATEUR = "update UTILISATEURS set pseudo =?, nom =?, prenom =?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? where no_utilisateur = ?";

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
	public Utilisateur supprimeUtilisateur(int noUtilisateur) throws BusinessException, SQLException  {
		try {  
			
	        Connection cnx = ConnectionProvider.getConnection();
	        PreparedStatement pstmt3 = cnx.prepareStatement(DELETE_UTILISATEUR);
	        pstmt3.setInt(1, noUtilisateur);
	        pstmt3.executeUpdate();

	    } catch(Exception e) {
	        System.out.println(e);
	    }
		return null;
	}
	//modification de l'utilisateur
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
		// test de connection à la base de données
				try (Connection cnx = ConnectionProvider.getConnection()){
					// inscription dans la base de données
					PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getNom());
					pstmt.setString(3, utilisateur.getPrenom());
					pstmt.setString(4, utilisateur.getEmail());
					pstmt.setString(5, utilisateur.getTelephone());
					pstmt.setString(6, utilisateur.getRue());
					pstmt.setString(7, utilisateur.getCodePostal());
					pstmt.setString(8, utilisateur.getVille());
					pstmt.setString(9, utilisateur.getMotDePasse());
					pstmt.setInt(10, utilisateur.getNoUtilisateur());
					 pstmt.executeUpdate();
					 pstmt.close();
					 cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return utilisateur;
	}

	@Override
	public boolean verifMail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return false;
	}
}

