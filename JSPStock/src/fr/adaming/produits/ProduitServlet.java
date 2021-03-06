package fr.adaming.produits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;
import fr.adaming.panier.PanierElement;
import fr.adaming.panier.PanierID;
import fr.adaming.utilisateur.UserStatic;
import fr.adaming.utilisateur.Utilisateur;
import fr.adaming.utilisateur.UtilisateurDAO;


/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitDAO produitDAO;
	
	@EJB
	private UtilisateurDAO utilisateurDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Verif utilisateur connecte
		Integer connectedUserId = (Integer) request.getSession().getAttribute( Constante.KEY_CONNECTED_USER );
		Utilisateur connectedUser = utilisateurDAO.findUtilisateur( connectedUserId );
		if(!UserStatic.isLogged(response, connectedUser))
			return;
		
		// récupérer le panier
		PanierID panierId = (PanierID) request.getSession().getAttribute("panierId");
					
		// alimenter la vue avec le contenu du panier
		List<PanierElement> panierElements = new ArrayList<>();
		
		if( panierId != null )
		{
			for( Entry<Integer, Integer> entry : panierId.getProductIdQuantities().entrySet() )
			{
				int produitId = entry.getKey();
				int quantite = entry.getValue();

				Produit produit = produitDAO.findProduit( produitId );
				if(produit != null)
					panierElements.add( new PanierElement( produit, quantite ) );
			}
		}
		request.setAttribute( "panierElements", panierElements );
		
		//set
		request.setAttribute("produits", produitDAO.getProduits());	//modif BD

		request.getRequestDispatcher("/WEB-INF/produitVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auto-generated method stub
		doGet(request, response);
	}

}
