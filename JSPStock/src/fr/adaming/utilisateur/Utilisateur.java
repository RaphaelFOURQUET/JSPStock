/**
 * 
 */
package fr.adaming.utilisateur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author INTI-0332
 *
 */
@Entity
@NamedQuery(name="findUtilisateurByLogin",
			query="select u from Utilisateur u where u.login=:login")
public class Utilisateur {
	
	@Id @GeneratedValue
	private int id;
	
	private String login;


	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + id + ", login=" + login + "]";
	}
	
	

}
