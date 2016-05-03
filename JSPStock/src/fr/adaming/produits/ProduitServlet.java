package fr.adaming.produits;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
	private List<Produit> produitList = Arrays.asList(new Produit(0, "Stylo", "Indispensable pour écrire."),
																	new Produit(1, "Banane", "Un fruit sphérique."),
																	new Produit(2, "Table", "Un meuble."));			

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("produits", produitList);

		request.getRequestDispatcher("/WEB-INF/produitVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
