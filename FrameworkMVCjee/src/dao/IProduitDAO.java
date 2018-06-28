package dao;

import java.util.List;

import metier.Produit;
//ll
public  interface IProduitDAO {
	public List<Produit> listProduit();
	public List<Produit> ProduitsParMC(String MC);
	public Produit save(Produit p);
	public Produit getProduit(long id);
	public Produit update(Produit p);
	public void delete(long id);

  
}
