<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List"%>
	<%@ page import = "model.Product" %>
    <%@ page import = "dao.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Gestion de produit</title>
</head>
<body>

<header>
			<h1>Gestion de produit</h1>
			<h2>Afficher liste de produit</h2>
		</header>
		
<div class="content">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prix</th>
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${list}" var="p">
				<tr>
					<td><c:out value="${p.getId()}" /></td>
					<td><c:out value="${p.getName()}" /></td>
					<td><c:out value="${p.getPrice()}" /></td>
					<td><a
						href="http://localhost:8080/produit/ProductServlet?operation=supprimer&id=<c:out value="${p.getId()}" />">Supprimer</a></td>
					<td><a
						href="http://localhost:8080/produit/ProductServlet?operation=modifier&id=<c:out value="${p.getId()}"/>">Modifier</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	</div>
<footer>
		<p>Par Melanie Chauvin</p>

	</footer>
</body>
</html>