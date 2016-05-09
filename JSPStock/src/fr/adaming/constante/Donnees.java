/**
 * 
 */
package fr.adaming.constante;

import java.util.ArrayList;
import java.util.List;

import fr.adaming.persistance.xml.ParserXML;
import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class Donnees {

	public static List<Produit> produitList = new ArrayList<Produit>(/*
	 * Arrays
	 * .
	 * asList
	 * (new
	 * Produit
	 * (0,
	 * "Stylo",
	 * "Indispensable pour écrire."
	 * ),
	 * new
	 * Produit
	 * (1,
	 * "Banane",
	 * "Un fruit sphérique."
	 * ),
	 * new
	 * Produit
	 * (2,
	 * "Table",
	 * "Un meuble."
	 * ),
	 * new
	 * Produit
	 * (3,
	 * "新唐人電視台 "
	 * ,
	 * "Test UTF-8."
	 * ))
	 */);

	public static Produit findProduit(int id) {
		for (Produit p : produitList) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}

	// Add or Edit a Produit from produitList
	public static void addProduit(Produit p) {
		Produit currentP = null;
		for (Produit prod : produitList) {
			if (p.getId() == prod.getId()) {
				// Deja present, on remove
				currentP = prod;
				// produitList.remove(prod); //RFRF : pose des problemes d acces
				// concurrent à produitList.
			}
		}
		if (currentP != null) {
			produitList.remove(currentP);
		}
		produitList.add(p);
	}

	public static void removeProduit(Produit p) {
		produitList.remove(p);
	}

	public static int firstFreeIndex() {
		int i;
		for (i = 0; i < produitList.size(); i++) {
			if (Donnees.getId(i) == null)
				return i;
		}
		return i++;
	}

	public static void editProduit(int id, String name, String desc) {
		Produit p = findProduit(id);
		p.setNom(name);
		p.setDescription(desc);

	}

	public static Produit getId(int index) {
		for (Produit p : produitList) {
			if (p.getId() == index)
				return p;
		}
		return null;
	}

	public static void recupererDonnees() {
		if (produitList.isEmpty()) {	//On ne recupere depuis XML que la premiere fois ?
			if (Constante.PERSISTANCE_MODE == ModePersistance.XML) {
				ParserXML parserXML = new ParserXML();
				parserXML.readXMLFile(Constante.XML_PATH + "/Produits.xml");
			}
		}
	}

	public static void ecrireDonnees() {
		if (Constante.PERSISTANCE_MODE == ModePersistance.XML) {
			ParserXML parserXML = new ParserXML();
			parserXML.writeXMLFile(Constante.XML_PATH + "/Produits.xml");
		}
	}

}
