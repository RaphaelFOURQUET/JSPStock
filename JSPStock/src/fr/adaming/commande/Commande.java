/**
 * 
 */
package fr.adaming.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.adaming.utilisateur.Utilisateur;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Commande {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@ManyToOne
	private Utilisateur createur;
	
	@OneToMany( cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "commande" )
	List<LigneCommande> lignes = new ArrayList<LigneCommande>();
	
	private EtatCommande etatCommande;
	
	//Date
	private Date dateCommande;

	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	public List<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public int getId() {
		return id;
	}
	
	public Commande () {
		this.dateCommande = new Date();
	}

	public void addLigne(LigneCommande ligne) {
		// Auto-generated method stub
		this.lignes.add(ligne);
	}
	
	

}
