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
import fr.eni.projet.bo.Categorie;

/**
 * Classe modélisant
 *
 * @date 4 juin 2021 15:02:13
 * @author ENI
 */
public class CategorieDAOJdbcImpl implements CategorieDAO {
	private static final String SELECT_ALL = "SELECT * FROM CATEGORIES";

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.CategorieDAO#selectAllCategorie()
	 */
	@Override
	public List<Categorie> selectAllCategorie() throws BusinessException {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
			{
            	listeCategories.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
			}
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.LECTURE_CATEGORIE_ECHEC);
            throw businessException;
        }
        return listeCategories;
	}

}
