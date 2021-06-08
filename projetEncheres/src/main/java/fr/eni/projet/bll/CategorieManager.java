/**
 * 
 */
package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;

/**
 * Classe modélisant le manager des catégories
 *
 * @date 4 juin 2021 15:31:40
 * @author ENI
 */
public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public List<Categorie> selectionnerCategories() throws BusinessException
	{
		return this.categorieDAO.selectAllCategorie();
	}
	
	public Categorie selectionnerCategorieById(int noCategorie) throws BusinessException {
		return this.categorieDAO.selectCategorieById(noCategorie);
		
	}
	
}
