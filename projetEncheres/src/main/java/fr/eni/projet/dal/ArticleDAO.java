package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;

public interface ArticleDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet
	 * businessException.
	 * 
	 * @param repas
	 * @throws BusinessException
	 */
	public void insert(ArticleVendu article) throws BusinessException;

	public List<ArticleVendu> select() throws BusinessException;

	public List<ArticleVendu> selectCategorie(String categorie) throws BusinessException; //Pour liste déroulante

	public List<ArticleVendu> selectRecherche(String recherche) throws BusinessException; // Pour "nom de l'article contient"s
	
	public ArticleVendu selectArticleById(int noArticle) throws BusinessException;
	//achat:
		//Enchères ouvertes
		//mes enchères en cours
		//mes enchères remportées
	
	//Mes ventes
		//mes ventes en cours
		//ventes non débutées
		//ventes terminées
}
