package metier;

import java.util.ArrayList;
import java.util.List;

import framework.otmaneController;
import framework.otmaneMethod;
import metier.*;


public class ProduitModele {
	public String getMotCle() {
		return motCle;
	}
  	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getP() {
		return p;
	}
	public void setP(List<Produit> p) {
		this.p = p;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
//	public Produit getProduit() {
//		return produit;
//	}
//	public void setProduit(Produit produit) {
//		this.produit = produit;
//	}
	private String motCle="";
	//private Produit produit=new Produit("", "", 0.0);
	private String erreur="";
	private String mode="ajout";
	private List<Produit> p= new ArrayList<>(); 
}
