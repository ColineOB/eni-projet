/**
 * 
 */
package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Categorie;

/**
 * Classe modélisant
 *
 * @date 4 juin 2021 14:58:45
 * @author ENI
 */
public interface CategorieDAO {

	public List<Categorie> selectAllCategorie() throws BusinessException;
	public Categorie selectCategorieById(int noCategorie) throws BusinessException ;
	
}
