package fr.eni.projet.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand vérifier login/MDP null
	 */
	public static final int VERIFIER_LOGIN_MDP_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion de l'article 
	 */
	public static final int INSERT_ARTICLE_ECHEC=10001;

	/**
	 * Echec de la lecture des articles
	 */
	public static final int LECTURE_DETAIL_ARTICLE_ECHEC = 10002;
	/**
	 * Echec de la lecture d'une categorie
	 */
	public static final int LECTURE_DETAIL_CATEGORIE_ECHEC = 10003;
	/**
	 * Echec de la lecture d'un utilisateur
	 */
	public static final int LECTURE_DETAIL_UTILISATEUR_ECHEC = 10004;
	/**
	 * Erreur à la mise à jour d'un article
	 */
	public static final int UPDATE_ARTICLE_ECHEC = 10005;
	/**
	 * Erreur à la suppression d'une aticle
	 */
	public static final int DELETE_ARTICLE_ECHEC = 10006;
//	/**
//	 * Erreur au cochage d'un article
//	 */
//	public static final int COCHE_ARTICLE_ERREUR = 10007;
//	/**
//	 * Erreur au décochage d'un article
//	 */
//	public static final int DECOCHE_ARTICLE_ERREUR = 10008;
//	/**
//	 * Erreur au décochage de tous les articles d'une liste
//	 */
//	public static final int DECOCHE_ARTICLES_ERREUR = 10009;
		//le pseudo est déjà pris par un autre utilisateur
	public static final int PSEUDO_DEJA_PRIS =10100;
	public static final int EMAIL_DEJA_PRIS =10101;

	/* VIRGINIE */
	/**
	 * Erreur à la lecture des catégories
	 */
	public static final int LECTURE_CATEGORIE_ECHEC = 10200;
	
	/**
	 * Erreur à la lecture des enchères
	 */
	public static final int LECTURE_ENCHERE_ECHEC = 10201;

}












