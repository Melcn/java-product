<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ page import = "model.Produit" %>
    <%@ page import = "dao.ProduitDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Gestion de produit</title>
</head>
<body>


	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prix</th>
			</tr>

		</thead>
		<tbody>


			<c:forEach items="${produit}" var="p">
				<tr>
					<td><c:out value="${p.getId()}" /></td>
					<td><c:out value="${p.getNom()}" /></td>
					<td><c:out value="${p.getPrix()}" /></td>
					<td><a
						href="http://localhost:8081/produit/ProduitServlet?operation=supprimer&id=<c:out value="${p.getId()}" />">Supprimer</a></td>
					<td><a
						href="http://localhost:8081/produit/ProduitServlet?operation=modifier&id=<c:out value="${p.getId()}"/>">Modifier</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	

</body>
</html>