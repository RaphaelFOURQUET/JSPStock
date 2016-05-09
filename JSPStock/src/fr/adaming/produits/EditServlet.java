package fr.adaming.produits;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter(Constante.ID));
		
		//Produit produit = Donnees.findProduit(id);
		Produit produit = produitDAO.findProduit(id);
		
		//setAttribute
		request.setAttribute(Constante.PRODUIT, produit);
		
		//stocker session dernier produit
		request.getSession().setAttribute(Constante.LAST_EDITED_PRODUCT, produit);
		
		request.getRequestDispatcher("/WEB-INF/editFormVue.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter(Constante.ID));
		String name = req.getParameter(Constante.NAME);
		String desc = req.getParameter(Constante.DESCRIPTION);
		
		//Remettre dans ma liste
		//Donnees.editProduit(id, name, desc);
		
		//Mettre à jour persistance
		//Donnees.ecrireDonnees();
		
		//Modif BD
		produitDAO.updateProduit(id, name, desc);
		
		//Rediriger
		resp.sendRedirect(Constante.PRODUIT);
	}
	
	

}
