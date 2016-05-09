package fr.adaming.panier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;

/**
 * Servlet implementation class DeleteFromPanierServlet
 */
@WebServlet("/deleteFromPanier")
public class DeleteFromPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer id et panier
		int index = Integer.parseInt(request.getParameter("ligne"));
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		
		//supprimer du panier
		panier.deleteAtIndex(index);
		
		//on repasse le panier
		request.getSession().setAttribute("panier", panier);
		
		//redirect
		response.sendRedirect(Constante.PRODUIT);
		
	}

}
