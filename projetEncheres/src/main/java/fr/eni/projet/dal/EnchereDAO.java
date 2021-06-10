/**
 * 
 */
package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Enchere;

/**
 * Classe modélisant
 *
 * @date 8 juin 2021 13:59:49
 * @author ENI
 */
public interface EnchereDAO {
	
	public List<Enchere> selectAllEnchere() throws BusinessException;
	
	public List<Enchere> selectByCategorieEnchere(int id) throws BusinessException;
	
	public List<Enchere> selectByMotCleEnchere(String motCle) throws BusinessException;
	
	public List<Enchere> selectByStateEnchere() throws BusinessException;

}
