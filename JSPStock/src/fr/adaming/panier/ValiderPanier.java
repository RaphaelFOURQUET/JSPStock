package fr.adaming.panier;

import java.io.IOException;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.commande.Commande;
import fr.adaming.commande.CommandeDAO;
import fr.adaming.commande.EtatCommande;
import fr.adaming.commande.LigneCommande;
import fr.adaming.constante.Constante;
import fr.adaming.produits.Produit;
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
		
		//Recuperer le panier
		PanierID panierId = (PanierID) request.getSession().getAttribute("panierId");
		
		//Si non null 
		if(panierId != null) {
			//creer la commande
			Commande commande = new Commande();
			commande.setCreateur(utilisateurDAO.findUtilisateur(connectedUserId));
			commande.setEtatCommande(EtatCommande.PREPARATION);
			//commande.setDateCommande(new Date());	//RFRF : deja fait dans le constructeur
			
			//for each
			for(Entry<Integer, Integer> entry : panierId.getProductIdQuantities().entrySet()) {
				//set les lignecommande
				int produitId = entry.getKey();
				int quantite = entry.getValue();

				Produit produit = produitsDAO.findProduit(produitId);

				LigneCommande ligne = new LigneCommande();
				ligne.setProduit(produit);
				ligne.setQuantite(quantite);

				commande.addLigne(ligne);
			}
			//store commande en BD
			commandesDAO.storeCommande(commande);	//nullPointerException ? probleme avec la BD
			
		}
		
		//redirection
		response.sendRedirect( Constante.URL_HOME );
		
	}

}
