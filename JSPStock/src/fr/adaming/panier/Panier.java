/**
 * 
 */
package fr.adaming.panier;

import java.util.ArrayList;
import java.util.List;

import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class Panier {
	
	private List<Produit> produits = new ArrayList<Produit>();

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
	}

}
