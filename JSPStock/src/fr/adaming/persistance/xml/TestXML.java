/**
 * 
 */
package fr.adaming.persistance.xml;

import fr.adaming.constante.Donnees;
import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class TestXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		ParserXML parserXML = new ParserXML();
		parserXML.readXMLFile("src/fr/adaming/persistance/xml/Produits.xml");
		
		System.out.println(Donnees.produitList);
		
		Donnees.addProduit(new Produit(4, "chaise", "Un nouveau meuble."));
		
		parserXML.writeXMLFile("src/fr/adaming/persistance/xml/Produits2.xml");
		
		System.out.println(Donnees.produitList);

	}

}
