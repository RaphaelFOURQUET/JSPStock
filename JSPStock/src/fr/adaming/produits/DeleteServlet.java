package fr.adaming.produits;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer le produit
		int id = Integer.parseInt(request.getParameter("id"));
		//Produit p = Donnees.findProduit(id);
		
		Produit p = produitDAO.findProduit(id);
		
		//Delete produit
		//Donnees.removeProduit(p);
		
		//Mettre à jour persistance
		//Donnees.ecrireDonnees();
		
		//modif BD
		produitDAO.deleteProduit(p);
		
		//Redirection Produits
		response.sendRedirect("produit");
	}

}
