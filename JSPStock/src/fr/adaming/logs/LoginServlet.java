package fr.adaming.logs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// Auto-generated constructor stub
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sessionLogin = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
		//String login = request.getParameter("login");
		
		String user = request.getParameter(Constante.PARAM_USER_LOGIN);

		if(sessionLogin == null && user != null && !user.isEmpty()) {
				request.getSession().setAttribute(Constante.KEY_CONNECTED_USER, user);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
		response.sendRedirect( "index.jsp" );
	}

}
