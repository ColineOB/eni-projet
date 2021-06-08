/**
 * 
 */
package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Enchere;

/**
 * Classe modélisant
 *
 * @date 8 juin 2021 14:00:18
 * @author ENI
 */
public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.EnchereDAO#selectAllEnchere()
	 */
	@Override
	public List<Enchere> selectAllEnchere() throws BusinessException {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	listeEncheres.add(new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getInt("montant_enchere")));
			}
        } catch(Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
            throw businessException;
        }
        return listeEncheres;
	}

}
