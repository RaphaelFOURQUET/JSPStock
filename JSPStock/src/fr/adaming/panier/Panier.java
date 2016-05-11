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
		if(productIdQuantities.containsKey(p)) {
			productIdQuantities.put(p, productIdQuantities.get(p)+1);
		} else {
			productIdQuantities.put(p, 1);
		}
	}

	public void deleteProduit( Produit p ) {
		int qtite = productIdQuantities.get(p);
		if(qtite <= 1) {
			//remove
			productIdQuantities.remove(p);
		} else {
			//-1
			productIdQuantities.put( p, qtite - 1);
		}
		
	}

}
