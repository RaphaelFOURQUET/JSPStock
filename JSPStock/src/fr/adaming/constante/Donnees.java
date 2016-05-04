/**
 * 
 */
package fr.adaming.constante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class Donnees {

	public static List<Produit> produitList = new ArrayList<Produit>(Arrays.asList(new Produit(0, "Stylo", "Indispensable pour écrire."),
			new Produit(1, "Banane", "Un fruit sphérique."),
			new Produit(2, "Table", "Un meuble.")));
		
	public static Produit findProduit(int id) {
		for(Produit p: produitList) {
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	//Add or Edit a Produit from produitList
	public static void addProduit(Produit p) {
		Produit currentP = null;
		for(Produit prod : produitList) {
			if(p.getId() == prod.getId()) {
				//Deja present, on remove
				currentP = prod;
				//produitList.remove(prod);	//RFRF : pose des problemes d acces concurrent à produitList.
			}
		}
		if(currentP != null) {
			produitList.remove(currentP);
		}
		produitList.add(p);
	}
	
	public static void removeProduit(Produit p) {
		produitList.remove(p);
	}
	
	public static int firstFreeIndex() {
		int i;
		for(i=0; i<produitList.size(); i++) {
			if(produitList.get(i) == null)
				return i;
		}
		return i++;
	}
	
}
