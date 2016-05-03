package fr.adaming.produits;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Donnees;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet({ "/EditServlet", "/edit" })
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Produit produit = Donnees.findProduit(id);
		
		//setAttribute
		request.setAttribute("produit", produit);
		
		request.getRequestDispatcher("/WEB-INF/editFormVue.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Post pas bonne solution ?
		//TODO : Recuperer id sur disabled input??? obligatoirement par URL ?
		int id = Integer.parseInt(req.getParameter("id"));	//Recup par URL sur post ..???
		//int id = 1;	
		//int id = ((Produit)req.getAttribute("produit")).getId();
		String name = req.getParameter("name");
		String desc = req.getParameter("description");
		
		//Remettre dans ma liste
		Donnees.addProduit(new Produit(id, name, desc));
		
		//Rediriger
		resp.sendRedirect("produit");
	}
	
	

}
