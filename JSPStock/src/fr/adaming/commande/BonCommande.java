/**
 * 
 */
package fr.adaming.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.adaming.produits.Produit;
import fr.adaming.utilisateur.Utilisateur;

/**
 * @author INTI-0332
 *
 */
public class BonCommande {
	
	private Utilisateur createur;
	
	private EtatCommande etatCommande;
	
	//Date
	private Date dateCommande;
	
	//liste de lignes.
	//private List<Produit> commande = new ArrayList<Produit>();

	
	
	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	public Utilisateur getCreateur() {
		return createur;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	/*public List<Produit> getCommande() {
		return commande;
	}*/
	
	
	
	
	public BonCommande() {
		
	}

	public BonCommande(Utilisateur createur, EtatCommande etatCommande, Date dateCommande, List<Produit> commande) {
		super();
		this.createur = createur;
		this.etatCommande = etatCommande;
		this.dateCommande = dateCommande;
		//this.commande = commande;
	}
	
	

}
