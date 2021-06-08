/**
 * 
 */
package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;

/**
 * Classe modélisant
 *
 * @date 8 juin 2021 14:24:33
 * @author ENI
 */
public class EnchereManager {

private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> selectionnerCategories() throws BusinessException
	{
		return this.enchereDAO.selectAllEnchere();
	}
	
}
