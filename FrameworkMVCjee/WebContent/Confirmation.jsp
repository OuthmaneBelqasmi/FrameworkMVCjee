<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="metier.Produit"%>
<%@page import="java.util.List"%>
<%@page import="metier.ProduitModele"%>

    <%
	Produit p;
	if(request.getAttribute("produit")!=null)
	{
		p=(Produit)request.getAttribute("produit");
	}else {
		p = new Produit();

	}
	
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
			Confirmation
			</div>
			<div class="panel-body">
			
				<div class="form-group">
				    <label>Id :</label>
				    <label><%=p.getId()%></label>
				</div>
				<div class="form-group">
				    <label>Designation :</label>
				    <label><%=p.getDesignation()%></label>
				</div>
					<div class="form-group">
				   <label>Prix :</label>
				    <label><%=p.getPrix()%></label>
				</div>
				<div class="form-group">
				   <label>Quantité :</label>
				    <label><%=p.getQuantite()%></label>
				</div>			
			</div>
		</div>
		
	
	</div>
</body>
</html>