/**
 * 
 */
package fr.adaming.produits;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class ProduitDAO {
	
	@PersistenceContext(unitName="MySQL")
	EntityManager em;
	
	public Produit findProduit(int id) {
		return em.find(Produit.class, id);
	}
	
	public Produit addProduit(String name, String description) {
		Produit p = new Produit(name, description);
		em.persist(p);
		//em.flush(); pour envoyer commande a BD et recevoir id ?
		return p;
	}
	
	public void updateProduit(int id, String nom, String description) {
        Produit produit = findProduit(id);
        if( produit != null )
        {
            produit.setNom( nom );
            produit.setDescription( description );
        }
    }
	
	public void deleteProduit(Produit p) {
		if(p != null)
			em.remove(p);
	}
	
	public List<Produit> getProduits() {
        try {
            @SuppressWarnings("unchecked")
            List<Produit> produits = em.createQuery( "SELECT p FROM Produit p" ).getResultList();	//RFRF : requete JPQL et non SQL

            return produits;
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }



}
