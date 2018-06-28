<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="metier.Produit"%>
<%@page import="java.util.List"%>
<%@page import="metier.ProduitModele"%>

    <%
    Produit p = new Produit();
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
	<div class="container col-md-8  col-md-offset-2">
		<div class="panel panel-primary">
			<div class="panel-heading">
			Saisie d'un produit
			</div>
			<div class="panel-body ">
			<form action="save.php" method="post">
			
				<div class="form-group">
				    <label class="control-label">Designation</label>
					<input type="text" name="designation" class="form-control">	
					<span></span>	
				</div>
					<div class="form-group">
				    <label class="control-label">Prix</label>
					<input type="text" name="prix" class="form-control" value="<%= p.getPrix() %>">	
					<span></span>	
				</div><div class="form-group">
				    <label class="control-label">Quantité</label>
					<input type="text" name="quantite" class="form-control" value="<%= p.getQuantite() %>">	
					<span></span>	
				</div>
					
					
					<button type="submit" class="btn btn-primary">Ajouter</button>	
			</form>
		
			</div>
		</div>
		
	
	</div>
</body>
</html>