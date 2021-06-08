package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public class InscriptionDAOJdbclmpl implements InscriptionDAO {
	private static final String SELECT_VERIF_PSEUDO = "SELECT pseudo FROM UTILISATEURS where pseudo=?";
	private static final String SELECT_VERIF_EMAIL = "SELECT email FROM UTILISATEURS where email=?";
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	
	
	public void inscrireUtilisateur(Utilisateur utilisateur) throws BusinessException {

		// test de connection à la base de données
		try {
			// inscription dans la base de données
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			cnx.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verifMail(String email) {
		boolean test= false;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_VERIF_EMAIL);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				test= false;
			} else {
				test= true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return test;
	}

public boolean verifPseudo (String pseudo) {
	boolean test= false;
	try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt= cnx.prepareStatement(SELECT_VERIF_PSEUDO);
		pstmt.setString(1, pseudo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			test=false;
		} else {
			test= true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return test;
}


}
