/**
 * 
 */
package fr.adaming.panier;

import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class PanierElement {
	
	private Produit produit;
	private int quantite;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public PanierElement() {
	}
	
	public PanierElement(Produit produit, int quantite) {
		this.produit = produit;
		this.quantite = quantite;
	}

}
