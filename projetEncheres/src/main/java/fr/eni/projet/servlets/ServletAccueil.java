package fr.eni.projet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.EnchereManager;
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
