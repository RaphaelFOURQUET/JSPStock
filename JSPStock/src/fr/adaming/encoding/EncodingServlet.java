package fr.adaming.encoding;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet
 */
@WebServlet("/test")	//TODO : modifier WebServlet en * et tester ???
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain)
					throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Pass control on to the next filter
		chain.doFilter(request, response);

	}



}
