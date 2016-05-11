/**
 * 
 */
package fr.adaming.produits;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Produit {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Produit() {
		
	}
	
	public Produit(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public Produit(int id, String nom, String description) {
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
