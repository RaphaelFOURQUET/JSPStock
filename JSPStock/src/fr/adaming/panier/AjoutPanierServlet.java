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
 * Servlet implementation class AjoutPanier
 */
@WebServlet("/ajoutPanier")
public class AjoutPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPanierServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer l id en parametre
		int id = Integer.parseInt(request.getParameter(Constante.ID));
		
		//Recuperation panier + ajout
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		panier.addProduit(produitDAO.findProduit(id));
		
		
		//Recuperation panierId + ajout
		PanierID panierId = (PanierID) request.getSession().getAttribute("panierId");
		panierId.addProduit(id);
		
		//Rediriger
		response.sendRedirect(Constante.PRODUIT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Auto-generated method stub
		doGet(request, response);
	}

}
