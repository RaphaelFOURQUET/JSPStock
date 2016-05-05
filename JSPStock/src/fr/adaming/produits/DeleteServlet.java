package fr.adaming.produits;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Donnees;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer le produit
		int id = Integer.parseInt(request.getParameter("id"));
		Produit p = Donnees.findProduit(id);
		
		//Delete produit
		Donnees.removeProduit(p);
		
		//Mettre à jour persistance
		Donnees.ecrireDonnees();
		
		//Redirection Produits
		response.sendRedirect("produit");
	}

}
