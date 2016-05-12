/**
 * 
 */
package fr.adaming.commande;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.utilisateur.Utilisateur;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class CommandeDAO {

	@PersistenceContext(unitName = "MySQL")
	EntityManager em;

	public void storeCommande(Commande commande) {
		em.persist(commande);
	}

	@SuppressWarnings("unchecked")
	public List<Commande> findCommandesByUtilisateur(Utilisateur connectedUser) {

		Query q = em.createQuery(
				"select distinct c from Commande c left join fetch c.lignes where c.createur=:utilisateur");
		q.setParameter("utilisateur", connectedUser);

		List<Commande> res = q.getResultList();

		// Même requête par querybuilder
		/*
		 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Commande>
		 * q = cb.createQuery( Commande.class ); Root<Commande> o = q.from(
		 * Commande.class ); o.fetch( "lignes", JoinType.LEFT ); q.select( o );
		 * q.distinct( true ); q.where( cb.equal( o.get( "createur" ),
		 * connectedUser ) );
		 * 
		 * List<Commande> res = em.createQuery( q ).getResultList();
		 */

		return res;
	}

	public int countCommandesByUtilisateur(Utilisateur connectedUser) {

		Query q = em.createQuery("select count(c) from Commande c where c.createur=:utilisateur");
		q.setParameter("utilisateur", connectedUser);

		int res = (int) (long) (Long) q.getSingleResult();

		return res;
	}

}
