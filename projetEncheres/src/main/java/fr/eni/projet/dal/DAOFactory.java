package fr.eni.projet.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	


	public static InscriptionDAO getInscriptionDAO()
	{
		return (InscriptionDAO) new InscriptionDAOJdbclmpl();
  }
  
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJdbcImpl();

	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
}
	