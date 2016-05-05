package fr.adaming.produits;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;
import fr.adaming.constante.Donnees;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet("/ajout")
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Trouver le premier index libre
		int freeIndex = Donnees.firstFreeIndex();
		request.setAttribute("freeIndex", freeIndex);
		
		//redirection formulaire vue
		request.getRequestDispatcher("/WEB-INF/ajoutFormVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperer infos
		int id = Integer.parseInt(request.getParameter(Constante.ID));
		String name = request.getParameter(Constante.NAME);
		String desc = request.getParameter(Constante.DESCRIPTION);
		
		//Remettre dans ma liste
		Donnees.addProduit(new Produit(id, name, desc));
		
		//Mettre à jour persistance
		Donnees.ecrireDonnees();
		
		//Rediriger
		response.sendRedirect("produit");
	}

}
