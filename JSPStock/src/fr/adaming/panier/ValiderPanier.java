package fr.adaming.panier;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.commande.CommandeDAO;
import fr.adaming.constante.Constante;
import fr.adaming.produits.ProduitDAO;
import fr.adaming.utilisateur.Utilisateur;
import fr.adaming.utilisateur.UtilisateurDAO;

/**
 * Servlet implementation class ValiderPanier
 */
@WebServlet("/validerPanier")
public class ValiderPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UtilisateurDAO utilisateurDAO;

	//@EJB
	private CommandeDAO commandesDAO;

	@EJB
	private ProduitDAO produitsDAO;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Verif utilisateur connecte
		Integer connectedUserId = (Integer) request.getSession().getAttribute( Constante.KEY_CONNECTED_USER );
		Utilisateur connectedUser = utilisateurDAO.findUtilisateur( connectedUserId );
		if( connectedUser == null )
		{
			response.sendRedirect( Constante.URL_HOME );
			return;
		}
		
		//TODO coder
		//Recuperer le panier
		//Si non null 
			//creer la commande
			//for each
				//set les lignecommande
			//store commande en BD
		
		//redirection
		response.sendRedirect( Constante.URL_HOME );
		
	}

}
