/**
 * 
 */
package fr.adaming.utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.constante.Constante;

/**
 * @author INTI-0332
 *
 */
public class UserStatic {
	
	public static boolean isLogged(HttpServletResponse response, Utilisateur connectedUser) throws ServletException, IOException {
		//Verif utilisateur connecte
		if( connectedUser == null ) {
			response.sendRedirect( Constante.URL_HOME );
			return false;
		}
		return true;
	}

}
