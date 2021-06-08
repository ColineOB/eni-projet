package fr.eni.projet.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la date et heure de la vente est inférieur à la date du jour
	 */
	public static final int REGLE_ARTICLE_DATE_ERREUR=20000;
	
	/**
	 * Echec quand la date et heure de fin de la vente est inférieur à la date et heure de début de la vente
	 */
	public static final int REGLE_ARTICLE_DATE_FIN_ERREUR = 20001;

	/**
	 * Echec quand la case du formulaire est nulle
	 */
public static final int REGLE_ARTICLE_CASE_NULLE_ERREUR = 20002;
	
}
