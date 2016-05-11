package fr.adaming.panier;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;
import fr.adaming.produits.ProduitDAO;

/**
 * Servlet implementation class DeleteFromPanierServlet
 */
@WebServlet("/deleteFromPanier")
public class DeleteFromPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer id et panier
		int index = Integer.parseInt(request.getParameter("id"));
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		
		//supprimer du panier
		panier.deleteProduit(produitDAO.findProduit(index));
		
		//Recuperation panierId + ajout
		PanierID panierId = (PanierID) request.getSession().getAttribute("panierId");
		panierId.deleteProduit(index);
		
		//redirect
		response.sendRedirect(Constante.PRODUIT);
		
	}

}
