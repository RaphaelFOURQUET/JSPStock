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
	
											//EAGER : Force le chargement des LigneCommande à chaque requete sur Commande
	@OneToMany( cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "commande"/*, fetch = FetchType.EAGER */)
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
		ligne.setCommande(this);	//RFRF : set la commande de LigneCommande pour avoir ma clé etrangère dans la base.
		this.lignes.add(ligne);
	}
	
	

}
