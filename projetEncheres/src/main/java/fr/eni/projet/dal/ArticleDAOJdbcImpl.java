package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, "
			+ "prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ARTICLE = "update ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, "
			+ "prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_DETAIL_VENTE = " SELECT a.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, "
			+ "a.prix_initial, a.prix_vente, a.no_utilisateur, a.no_categorie" + " FROM ARTICLES_VENDUS a "
			+ " WHERE a.no_article=?";
//	private static final String SELECT_NOM = "SELECT a.nom_article FROM ARTICLES_VENDUS a WHERE a.no_article=?";

	@Override
	public void insert(ArticleVendu article) throws BusinessException {
		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, article.getNomArticle());
				pstmt.setString(2, article.getDescription());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDateDebutEncheres()));
				pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(5, article.getMiseAPrix());
				pstmt.setInt(6, article.getPrixVente());
				pstmt.setInt(7, article.getNoUtilisateur());
				pstmt.setInt(8, article.getNoCategorie());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);
			throw businessException;
		}

	}
	
	@Override
	public ArticleVendu update(ArticleVendu article) throws BusinessException {
		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ARTICLE_ECHEC);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE);
				pstmt.setString(1, article.getNomArticle());
				pstmt.setString(2, article.getDescription());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDateDebutEncheres()));
				pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(5, article.getMiseAPrix());
				pstmt.setInt(6, article.getPrixVente());
				pstmt.setInt(7, article.getNoUtilisateur());
				pstmt.setInt(8, article.getNoCategorie());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);
			throw businessException;
		}
		return article;
	}

	@Override
	public List<ArticleVendu> select() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectCategorie(String categorie) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectRecherche(String recherche) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectArticleById(int noArticle) throws BusinessException {
		ArticleVendu article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_DETAIL_VENTE);

				pstmt.setInt(1, noArticle);

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {

					article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
							rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
							rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
							rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_DETAIL_ARTICLE_ECHEC);
				throw businessException;
			}
			return article;

		
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see fr.eni.projet.dal.ArticleDAO#selectNomArticleById(int)
	 */
	@Override
	public String selectNomArticleById(int noArticle) throws BusinessException {
		ArticleVendu article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_DETAIL_VENTE);

				pstmt.setInt(1, noArticle);

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {

					article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
							rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
							rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
							rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_DETAIL_ARTICLE_ECHEC);
				throw businessException;
			}
			String nomArticle = article.getNomArticle();
			return nomArticle;
	}

}
