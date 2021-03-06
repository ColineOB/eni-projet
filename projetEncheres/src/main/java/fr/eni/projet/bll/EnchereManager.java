/**
 * 
 */
package fr.eni.projet.bll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;
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
	
	public List<Enchere> selectionnerEncheres() throws BusinessException
	{
		return this.enchereDAO.selectAllEnchere();
	}
	
	public List<Enchere> selectionnerEncheresParCategorie(int id) throws BusinessException
	{
		return this.enchereDAO.selectByCategorieEnchere(id);
	}
	
	public List<Enchere> selectionnerEncheresParMotCle(String motCle) throws BusinessException
	{
		return this.enchereDAO.selectByMotCleEnchere(motCle);
	}
	
	public List<Enchere> selectionnerEncheresParEtat(String etatVente) throws BusinessException
	{
//		return this.enchereDAO.selectByStateEnchere();
		List<Enchere> listeEncheres = this.enchereDAO.selectByStateEnchere();
		List<Enchere> listeEncheresDate = new ArrayList<>();
		LocalDateTime dateDebutEncheres;
		LocalDateTime dateFinEncheres;
		
		for (Enchere enchere : listeEncheres) {
			dateDebutEncheres = enchere.getArticle().getDateDebutEncheres();
			dateFinEncheres = enchere.getArticle().getDateFinEncheres();
			LocalDateTime dateActuelle = LocalDateTime.now();
			String etatVenteCourante;
			
			if (dateFinEncheres.isBefore(dateActuelle)) {
				etatVenteCourante = "termine"; 
			} else if (dateDebutEncheres.isAfter(dateActuelle)) {
				etatVenteCourante = "non_debute";
			} else {
				etatVenteCourante = "en_cours";
			}
			
			if (etatVente.equalsIgnoreCase(etatVenteCourante)) {
				listeEncheresDate.add(enchere);
			}
		}
		
		return listeEncheresDate;
	}
	
}
