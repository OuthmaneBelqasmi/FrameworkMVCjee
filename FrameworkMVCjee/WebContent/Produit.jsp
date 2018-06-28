<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="metier.Produit"%>
<%@page import="java.util.List"%>
<%@page import="metier.ProduitModele"%>
<%@page import="metier.ProduitModele"%>
<%@page import="framework.ModelMap"%>

    <%
    
	ProduitModele mod;

    ModelMap model;
	if(request.getAttribute("model")!=null)
	{
		mod=new ProduitModele();
		model=(ModelMap)request.getAttribute("model");
		mod.setMotCle((String)model.getAttribute("mc"));
		mod.setP((List<Produit>)model.getAttribute("listproduits"));

	}
	else {
		mod=new ProduitModele();
	}
	
/* 	if(request.getAttribute("mod")!=null)
	{
		mod=(ProduitModele)request.getAttribute("mod");
	}
	else {
		mod=new ProduitModele();
	} */
	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"> 
</head>
<body>
		<%@ include file="Header.jsp"  %>
	<br>
	<div class="container col-md-10  col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">
			Rechercher des produits
			</div>
			<div class="panel-body ">
			<form action="chercher.php" method="get">
					<label>Mot clé</label>
					<input type="text" name="motCle" value="<%=mod.getMotCle()%>">		
					<button type="submit" class="btn btn-primary">Chercher</button>	
			</form>
			<table class="table"> 
				  <tr>
				    <th>ID</th>
				    <th>Désignation</th>
				    <th>Prix</th>
				    <th>Quantité</th>
				    
				  </tr>
	  
	  <%
	  		
			List<Produit> prods=mod.getP();
			for(Produit p:prods){ %>
			<tr>
			<td><%=p.getId() %></td>
			 <td><%=p.getDesignation() %></td>
			<td><%=p.getPrix() %></td> 
			<td><%=p.getQuantite() %></td> 
	 		<td>
	 		<a onclick="return confirm('Est vous sùre?')" href="supprime.php?id=<%=p.getId() %>"> Supprimer </a>
	 		</td>
	 		<td>
	 		<a href="modifie.php?id=<%=p.getId() %>"> Modifier </a>
	 		 </td>
	 		 <td>
	 		<a href="json.php?id=<%=p.getId() %>"> Json Format </a>
	 		 </td>
	 		
	
			</tr>
			<% } %>
	  
	  
	  
	</table>
			
			</div>
		</div>
		
	
	</div>
</body>
</html>