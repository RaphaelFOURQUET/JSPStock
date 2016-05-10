/**
 * 
 */
package fr.adaming.panier;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class Panier {

	/*private List<Produit> produits = new ArrayList<Produit>();

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Panier() {

	}

	public Panier(List<Produit> produits) {
		this.produits = produits;
	}

	public void addProduit(Produit p) {
		this.produits.add(p);
	}

	public void deleteAtIndex(int index) {
		produits.remove(index);
	}*/

	private final Map<Produit, Integer> productIdQuantities = new HashMap<>();

	public Map<Produit, Integer> getProductIdQuantities() {
		return Collections.unmodifiableMap( productIdQuantities );
	}

	public void addProduit( Produit p ) {
		boolean notPresent= true;
		for(Produit prod : productIdQuantities.keySet()) {
			if(prod.getId() == p.getId()) {
				//+1
				productIdQuantities.put( prod, productIdQuantities.get(prod)+1 );
				notPresent = false;
			}
		}
		if(notPresent) {
			productIdQuantities.put( p, 1 );
		}
	}

	public void deleteProduit( Produit p ) {
		Produit pToDel = null;
		for(Produit prod : productIdQuantities.keySet()) {
			if(prod.getId() == p.getId()) {
				int qtite = productIdQuantities.get(prod);
				if(qtite <= 1)
					pToDel = prod;
				else
					productIdQuantities.put( prod, qtite - 1 );
			}
		}
		if(pToDel != null)
			productIdQuantities.remove( pToDel );
	}

}
