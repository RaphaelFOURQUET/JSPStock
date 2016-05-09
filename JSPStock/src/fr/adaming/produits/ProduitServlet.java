package fr.adaming.produits;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO : juste un test
		//produitDAO.addProduit("Encore un nouveau produit", "Une description2.");
		
		//recuperer donnees
		//Donnees.recupererDonnees();
		
		//set
		request.setAttribute("produits", produitDAO.getProduits());	//TODO modif BD

		request.getRequestDispatcher("/WEB-INF/produitVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auto-generated method stub
		doGet(request, response);
	}

}
