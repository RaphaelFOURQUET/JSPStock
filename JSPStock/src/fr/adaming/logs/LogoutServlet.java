package fr.adaming.logs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Remise à zero session
//		request.getSession().setAttribute(Constante.KEY_CONNECTED_USER, null);
//		request.getSession().setAttribute("userName", null);
//		
//		//erase paniers
//		Panier panier = new Panier();
//		request.getSession().setAttribute("panier", panier);
//		
//		PanierID panierId = new PanierID();
//		request.getSession().setAttribute("panierId", panierId);
		
		request.getSession().invalidate();	//RFRF : invalide toutes les variables de session
		
		//redirection
		response.sendRedirect("index.jsp");
	}
	

}
