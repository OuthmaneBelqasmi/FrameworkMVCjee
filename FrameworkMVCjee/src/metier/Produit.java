package metier;

import java.io.Serializable;

public class Produit implements Serializable {
	private long id;
	private String designation;
	private double prix;
	private int quantite;
	/**
	 * 
	 */
	public Produit() {
		super();
		this.prix=0;
		this.quantite=0;
	}

	public Produit(String designation, double prix, int quatite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quatite;
	}



	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix="
				+ prix + ", quantite=" + quantite + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quatite) {
		this.quantite = quatite;
	}

	/**
	 * @param id
	 * @param designation
	 * @param prix
	 * @param quantite
	 */
	public Produit(long id, String designation, double prix, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

}
