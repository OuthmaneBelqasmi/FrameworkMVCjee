package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import framework.interfaceOtmane;
import metier.Produit;

@interfaceOtmane(msg = "")
public class ProduitDaoImpl implements IProduitDAO{
	
   
	@Override
	public List<Produit> listProduit() {
		List<Produit> prds=new ArrayList<Produit>();
		Connection conn= SingletonConnection.getConn();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from produits");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Produit p=new Produit();
				p.setId(rs.getLong("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
			prds.add(p);
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return prds;
	}

	@Override
	public List<Produit> ProduitsParMC(String MC) {
		List<Produit> prds=new ArrayList<Produit>();
		Connection conn= SingletonConnection.getConn();
		try {
				PreparedStatement ps=conn.prepareStatement("select * from produits where designation like ?");
				ps.setString(1, "%"+MC+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Produit p=new Produit();
					p.setId(rs.getLong("id"));
					p.setDesignation(rs.getString("designation"));
					p.setPrix(rs.getDouble("prix"));
					p.setQuantite(rs.getInt("quantite"));
					prds.add(p);
				}
				ps.close();

		} catch (Exception e) {
				e.printStackTrace();
		}
				return prds;
	}

	@Override
	public Produit save(Produit p) {
		Connection conn= SingletonConnection.getConn();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into produits (designation,prix,quantite) values(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2=conn.prepareStatement("select max(id) as MAXID from produits");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAXID"));
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	@Override
	public Produit getProduit(long id) {
		Produit p=null;
		Connection conn= SingletonConnection.getConn();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from produits where id=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Produit();
			p.setId(rs.getLong("id"));
			p.setDesignation(rs.getString("designation"));
			p.setPrix(rs.getDouble("prix"));
			p.setQuantite(rs.getInt("quantite"));
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(p==null) throw new RuntimeException("produit introuvable");
		return p;
	}

	@Override
	public Produit update(Produit p) {
		try {
			Connection conn= SingletonConnection.getConn();
			PreparedStatement ps=conn.prepareStatement("update produits set designation=?,prix=?,quantite=? where id=?");
			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return null;
	}

	@Override
	public void delete(long id) {
		Connection conn= SingletonConnection.getConn();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from produits where id=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}						
	}
	private void init() {
System.out.println("Init..");
	}

}
