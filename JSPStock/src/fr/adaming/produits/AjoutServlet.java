package fr.adaming.produits;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Donnees;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet("/ajout")
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		
		//Remettre dans ma liste
		Donnees.addProduit(new Produit(id, name, desc));
		
		//Rediriger
		response.sendRedirect("produit");
	}

}
