package fr.adaming.logs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.commande.CommandeDAO;
import fr.adaming.constante.Constante;
import fr.adaming.panier.Panier;
import fr.adaming.panier.PanierID;
import fr.adaming.utilisateur.Utilisateur;
import fr.adaming.utilisateur.UtilisateurDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/*@PersistenceUnit(name="MySQL")
	EntityManagerFactory em;*/
	
	@EJB
	private UtilisateurDAO utilisateurDAO;
	
	@EJB
	private CommandeDAO commandeDAO;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// Auto-generated constructor stub
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String sessionLogin = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
		
		String user = request.getParameter(Constante.PARAM_USER_LOGIN);
		Utilisateur utilisateur = utilisateurDAO.connectUtilisateur(user);
		
		if(utilisateur != null) {
			request.getSession().setAttribute("userName", utilisateur.getLogin());
			request.getSession().setAttribute(Constante.KEY_CONNECTED_USER, utilisateur.getId());
		}

//		if(sessionLogin == null && user != null && !user.isEmpty()) {
//				request.getSession().setAttribute(Constante.KEY_CONNECTED_USER, user);
//		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
		
		//creation panier
		Panier panier = new Panier();
		request.getSession().setAttribute("panier", panier);
		
		PanierID panierId = new PanierID();
		request.getSession().setAttribute("panierId", panierId);
		
		//recuperer user
		Utilisateur user = utilisateurDAO.findUtilisateur((Integer) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER));
		//requete est ce qu'il existe une commande pour mon user
		if(commandeDAO.countCommandesByUtilisateur(user)>0)
			request.getSession().setAttribute("possessCommande", true);
		
		response.sendRedirect( "index.jsp" );
	}

}
