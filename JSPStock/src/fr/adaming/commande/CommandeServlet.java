package fr.adaming.commande;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;
import fr.adaming.utilisateur.UserStatic;
import fr.adaming.utilisateur.Utilisateur;
import fr.adaming.utilisateur.UtilisateurDAO;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UtilisateurDAO utilisateurDAO;
	
	@EJB
	private CommandeDAO commandeDAO;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Recuperer user
		Utilisateur user = utilisateurDAO.findUtilisateur((Integer) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER));
		//Verif utilisateur connecte
		if(!UserStatic.isLogged(response, user))
			return;
		
		//Recuperer les commandes de mon user.	
		List<Commande> commandes = commandeDAO.findCommandesByUtilisateur(user);
		
		//transmettre commandes à la vue
		request.getSession().setAttribute("commandes", commandes);


		//deleguer la vue
		request.getRequestDispatcher("/WEB-INF/commandeVue.jsp").forward(request, response);
	}

}
