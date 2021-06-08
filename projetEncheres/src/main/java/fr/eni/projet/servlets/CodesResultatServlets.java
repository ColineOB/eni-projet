package fr.eni.projet.servlets;
//
///**
// * Les codes disponibles sont entre 30000 et 39999
// */
public abstract class CodesResultatServlets {
	
	/**
	 * Format date de début enchères incorrect
	 */
	public static final int FORMAT_ARTICLE_DATE_DEBUT_ERREUR=30000;
	
	/**
	 * Format date de fin enchères incorrect
	 */
	public static final int FORMAT_ARTICLE_DATE_FIN_ERREUR=30001;
//=======
//	
//	/**
//	 * Format id liste course incorrect
//	 */
//	public static final int FORMAT_ID_LISTE_ERREUR=30000;
  
//	/**
//	 * Format id liste course incorrect
//	 */
//	public static final Integer NOM_ARTICLE_OBLIGATOIRE = 30001;
//	public static final Integer NOM_LISTE_OBLIGATOIRE = 30002;
//	public static final Integer FORMAT_ID_ARTICLE_ERREUR = 30003;
		//le mot de passe est différent de la confirmation
	public static final int MDP_DIFFERENT_CONFIRMATION = 30100;
		//Le mot de passe à moins de 3 caractéres
	public static final int MDP_3_CARACTERES = 30101;
		//Charactére alphanumérique pour le pseudo
	public static final int PSEUDO_ALPHANUMERIQUE = 30102;
//	
}