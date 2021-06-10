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
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Utilisateur;

/**
 * Classe modélisant
 *
 * @date 8 juin 2021 14:00:18
 * @author ENI
 */
public class EnchereDAOJdbcImpl implements EnchereDAO {
//	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
	private static final String SELECT_ALL = "SELECT date_enchere, montant_enchere, nom_article, a.no_article, date_debut_encheres, date_fin_encheres, pseudo,"
			+ " u.no_utilisateur FROM ENCHERES e"
			+ "	LEFT JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article"
			+ "	LEFT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur;";
	private static final String SELECT_BY_CATEGORIE = "SELECT date_enchere, montant_enchere, nom_article, a.no_article, pseudo, u.no_utilisateur FROM ENCHERES e"
			+ "	LEFT JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article"
			+ "	LEFT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur"
			+ " WHERE a.no_categorie = ? OR 1 = ?;";
	private static final String SELECT_BY_MOT_CLE = "SELECT date_enchere, montant_enchere, nom_article, a.no_article, pseudo, u.no_utilisateur FROM ENCHERES e"
			+ "	LEFT JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article"
			+ "	LEFT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur"
			+ " WHERE lower(a.nom_article) LIKE ?;";
	private static final String SELECT_BY_STATE = "SELECT date_enchere, montant_enchere, nom_article, a.no_article, etat_vente, pseudo, u.no_utilisateur FROM ENCHERES e"
			+ "	LEFT JOIN ARTICLES_VENDUS a ON e.no_article = a.no_article"
			+ "	LEFT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur";
	private static List<Enchere> listeEncheres;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.EnchereDAO#selectAllEnchere()
	 */
	@Override
	public List<Enchere> selectAllEnchere() throws BusinessException {
		listeEncheres = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setPseudo(rs.getString("pseudo"));
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				Enchere enchere = new Enchere(user, article, rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
				listeEncheres.add(enchere);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.EnchereDAO#selectByCategorieEnchere()
	 */
	@Override
	public List<Enchere> selectByCategorieEnchere(int id) throws BusinessException {
		listeEncheres = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setPseudo(rs.getString("pseudo"));
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				Enchere enchere = new Enchere(user, article, rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
				listeEncheres.add(enchere);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.EnchereDAO#selectByMotCleEnchere()
	 */
	@Override
	public List<Enchere> selectByMotCleEnchere(String motCle) throws BusinessException {
		listeEncheres = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_BY_MOT_CLE);
			pstmt.setString(1, motCle);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setPseudo(rs.getString("pseudo"));
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				Enchere enchere = new Enchere(user, article, rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
				listeEncheres.add(enchere);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.EnchereDAO#selectByStateEnchere()
	 */
	@Override
	public List<Enchere> selectByStateEnchere() throws BusinessException {
		listeEncheres = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setPseudo(rs.getString("pseudo"));
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
				article.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
				Enchere enchere = new Enchere(user, article, rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
				listeEncheres.add(enchere);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
	}

}
