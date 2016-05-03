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
	
	public static void addProduit(Produit p) {
		for(Produit prod : produitList) {
			if(p.getId() == prod.getId()) {
				//Deja present, on remove
				produitList.remove(prod);
			}
		}
		produitList.add(p);
//		if(produitList.contains(p))
//			produitList.set(p.getId(), p);
//		else
//			produitList.add(p);
	}
	
}
