package fr.eni.projet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.ArticleManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	
//	@Override
//	public void init() throws ServletException {
//		String chaineCategorie = this.getServletContext().getInitParameter("CATEGORIESACCUEIL");
//		List<String> categories = Arrays.asList(chaineCategorie.split(","));
//		
//		this.getServletContext().setAttribute("categories", categories);
//		super.init();
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager categorieManager = new CategorieManager();
		EnchereManager enchereManager = new EnchereManager();
		
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		try {
			request.setAttribute("categorie", categorieManager.selectionnerCategories());
			request.setAttribute("enchere", enchereManager.selectionnerEncheres());
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			e.printStackTrace();
		}
		
		rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager categorieManager = new CategorieManager();
		EnchereManager enchereManager = new EnchereManager();
		int noCategorie = Integer.parseInt(request.getParameter("selectCategorie"));
		String motCle = request.getParameter("article-search");
		String motCle2 = "%"+motCle+"%";
		List<Enchere> listeEncheres;
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		try {
			request.setAttribute("categorie", categorieManager.selectionnerCategories());
//			request.setAttribute("enchere", enchereManager.selectionnerEncheres());
			listeEncheres = enchereManager.selectionnerEncheresParMotCle(motCle2);
			listeEncheres.retainAll(enchereManager.selectionnerEncheresParCategorie(noCategorie));
			request.setAttribute("enchere", listeEncheres);
//			request.setAttribute("enchere", enchereManager.selectionnerEncheresParMotCle(motCle2));
//			request.setAttribute("enchere", enchereManager.selectionnerEncheresParCategorie(noCategorie));
			System.out.println(motCle2);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			e.printStackTrace();
		}
		
		rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

}
