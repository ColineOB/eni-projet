package fr.eni.projet.bll;

import java.time.LocalDateTime;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}


	public ArticleVendu ajouterNouvelArticle(String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres,

			int miseAPrix, int noUtilisateur, int noCategorie)
			throws BusinessException {
		BusinessException exception = new BusinessException();

		ArticleVendu article = null;

		this.impossibleDateInferieurDateJour(dateDebutEncheres, exception);
		this.impossibleDateInferieurDateJour(dateFinEncheres, exception);
		this.impossibleDateFinInferieurDateDebut(dateDebutEncheres, dateFinEncheres, exception);
		this.stringNeDoitPasEtreVide(nomArticle, exception);
		this.stringNeDoitPasEtreVide(description, exception);
		this.stringNeDoitPasEtreVide(nomArticle, exception);

		if (!exception.hasErreurs()) {
			article = new ArticleVendu();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebutEncheres);
			article.setDateFinEncheres(dateFinEncheres);
			article.setMiseAPrix(miseAPrix);
			article.setNoUtilisateur(noUtilisateur);
			article.setNoCategorie(noCategorie);
			this.articleDAO.insert(article);
		} else {
			throw exception;
		}
		return article;
	}

	private void impossibleDateInferieurDateJour(LocalDateTime date, BusinessException businessException) {
		LocalDateTime dateDuJour = LocalDateTime.now();
		if (date == null || date.isAfter(dateDuJour)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_ERREUR);
		}
	}

	private void impossibleDateFinInferieurDateDebut(LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, BusinessException businessException) {
		if(dateDebutEncheres.isAfter(dateFinEncheres))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_ERREUR);
		}
	}
	
	private void stringNeDoitPasEtreVide(String caseForm, BusinessException businessException) {
		if(caseForm == null)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_CASE_NULLE_ERREUR);
		}
	}
	
	public ArticleVendu selectionnerArticleById(int noArticle) throws BusinessException {
			return this.articleDAO.selectArticleById(noArticle);
	}
	
	public String selectionnerNomArticleById(int noArticle) throws BusinessException {
			return this.articleDAO.selectNomArticleById(noArticle);
	}

}
