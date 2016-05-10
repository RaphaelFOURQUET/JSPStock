/**
 * 
 */
package fr.adaming.utilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class UtilisateurDAO {

	@PersistenceContext(unitName = "MySQL")
	private EntityManager em;

	public Utilisateur connectUtilisateur(String login) {
		if (login == null || login.isEmpty())
			return null;

		// trouver user en base
		Query q = em.createNamedQuery("findUtilisateurByLogin");
		q.setParameter("login", login);
		Utilisateur utilisateur = getSingleResult(q);

		// return user ou cree
		if (utilisateur == null) {
			utilisateur = new Utilisateur();
			utilisateur.setLogin(login);
			em.persist(utilisateur);
		}

		return utilisateur;
	}

	@SuppressWarnings("unchecked")
	private <T> T getSingleResult(Query query) {
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Utilisateur findUtilisateur(Integer id) {
		if (id == null) {
			return null;
		}
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		return utilisateur;
	}

}
