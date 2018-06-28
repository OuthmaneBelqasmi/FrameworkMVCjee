package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.IProduitDAO;
import dao.ProduitDaoImpl;
import metier.Produit;
import metier.ProduitModele;
import framework.Controller;
import framework.ModelMap;
import framework.beanOtmane;
import framework.otmaneController;
import framework.otmaneMethod;

@otmaneController
public class produitController extends Controller {
	
	
	@beanOtmane(msg = "test")
	IProduitDAO dao;
	
	@otmaneMethod(method="/saisie")
	public String saisie(ModelMap model)
	{
		return "/Saisie.jsp";
	}
	


	
	@otmaneMethod(method="/index") //par default c'est /index
	public String index(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");
		return "/Produit.jsp";
	}
	
	
	@otmaneMethod(method="/modifie")
	public String modifie(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");
		Long id = Long.parseLong(request.getParameter("id"));
		Produit p =dao.getProduit(id);
		request.setAttribute("produit", p);
		return "/modifie.jsp";
	}
	
	
	@otmaneMethod(method="/chercher")
	public String chercher(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");
		String mc = request.getParameter("motCle");
		List<Produit> p= dao.ProduitsParMC(mc);	
		ProduitModele mod= new ProduitModele();
		mod.setMotCle(mc);
		mod.setP(p);
		model.addAttribute("listproduits", p);
		model.addAttribute("mc", mc);
		request.setAttribute("model", model);
		return "/Produit.jsp";
	}
	@otmaneMethod(method="/save")
	public String save(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");
		String ds = request.getParameter("designation");
		double px = Double.parseDouble(request.getParameter("prix"));
		int qte = Integer.parseInt(request.getParameter("quantite"));
		Produit p =new Produit(ds, px, qte);
		dao.save(p);
		request.setAttribute("produit", p);
		return "/Confirmation.jsp";
	}
	@otmaneMethod(method="/update")
	public String update(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");
		long id = Long.parseLong(request.getParameter("id"));
		String ds = request.getParameter("designation");
		double px = Double.parseDouble(request.getParameter("prix"));
		int qte = Integer.parseInt(request.getParameter("quantite"));
		Produit p =new Produit(id,ds, px, qte);
	    dao.update(p);
		return "redirect:/chercher.php?motCle=";
	}
	@otmaneMethod(method="/supprime")
	public String del(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");		
		Long id = Long.parseLong(request.getParameter("id"));
		dao.delete(id);
		return "redirect:/chercher.php?motCle=";
	}
	@otmaneMethod(method="/json")
	public Object entity(ModelMap model)
	{
		request=(HttpServletRequest) model.getAttribute("request");
		response=(HttpServletResponse) model.getAttribute("response");		
		Long id = Long.parseLong(request.getParameter("id"));
		Produit p=dao.getProduit(id);
		return p;
	}
	
}
