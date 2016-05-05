/**
 * 
 */
package fr.adaming.persistance.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.adaming.constante.Donnees;
import fr.adaming.produits.Produit;

/**
 * @author INTI-0332
 *
 */
public class ParserXML {

	final DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

	public void readXMLFile(String doc) {
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document= builder.parse(new File(doc));
			final Element racine = document.getDocumentElement();
			final NodeList racineNoeuds = racine.getChildNodes();
			
			Element produit = null;
			int id;
			String nom, description;

			for (int i = 0; i<racineNoeuds.getLength(); i++) {
				if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					produit = (Element) racineNoeuds.item(i);

				    id = Integer.parseInt(produit.getElementsByTagName("id").item(0).getTextContent());
				    nom = produit.getElementsByTagName("nom").item(0).getTextContent();
				    description = produit.getElementsByTagName("description").item(0).getTextContent();

				    Donnees.addProduit(new Produit(id, nom, description));
			    } 
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void writeXMLFile(String doc) {
		try {
		    final DocumentBuilder builder = factory.newDocumentBuilder();

	        //création d'un Document
	        final Document document= builder.newDocument();
	                 
	        //création de l'Element racine
	        final Element racine = document.createElement("Produits");
	        document.appendChild(racine);
			
			//Creation du DOM correspondant a notre liste
			for (int i = 0; i<Donnees.produitList.size(); i++) {
				Element produit = document.createElement("Produit");
				racine.appendChild(produit);
				
				Element id = document.createElement("id");
				Element nom = document.createElement("nom");
				Element description = document.createElement("description");
		        
				produit.appendChild(id);
				produit.appendChild(nom);
				produit.appendChild(description);
				
				id.appendChild(document.createTextNode(String.valueOf(Donnees.produitList.get(i).getId())));
				nom.appendChild(document.createTextNode(Donnees.produitList.get(i).getNom()));
				description.appendChild(document.createTextNode(Donnees.produitList.get(i).getDescription()));
				
			}
			
			//Ecriture dans le XML
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			
			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult(new File(doc));
			
			 //prologue
	        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");//marche pas bien
	        
	        //formatage
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			transformer.transform(source, sortie);


		    

		} catch (final ParserConfigurationException e) {
		    e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}



}
