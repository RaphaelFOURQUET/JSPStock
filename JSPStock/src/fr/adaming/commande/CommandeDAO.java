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
	
	@PersistenceContext(unitName="MySQL")
	EntityManager em;
	
	
	public Commande storeCommande(Commande commande) {
		em.persist(commande);
		return commande;
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> findCommandesByUtilisateur(Utilisateur connectedUser) {
		
		//Requete JPQL
		Query q = em.createQuery( "select c from Commande c join fetch c.lignes where c.createur=:utilisateur" );
		q.setParameter( "utilisateur", connectedUser );

		return q.getResultList();
	}

}
