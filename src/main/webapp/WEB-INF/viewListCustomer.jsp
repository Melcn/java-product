<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Customer"%>
<%@ page import="dao.CustomerDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Liste de client</title>
</head>
<body>

	<!-- Vue permettant d'afficher la liste de Client  -->

	<header>
		<h1>Gestion de produit</h1>
		<h2>Afficher la liste de client</h2>
	</header>
	<div class="content">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Adresse</th>
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${list}" var="c">
				<tr>
					<td><c:out value="${p.getIdCustomer()}" /></td>
					<td><c:out value="${p.getNameCustomer()}" /></td>
					<td><c:out value="${p.getFirstName()}" /></td>
					<td><c:out value="${p.getMail()}" /></td>
					<td><c:out value="${p.getAdress()}" /></td>
					<td><a
						href="http://localhost:8080/produit/CustomerServlet?operation=supprimer&id=<c:out value="${c.getIdCustomer()}" />">Supprimer</a></td>
					<td><a
						href="http://localhost:8080/produit/CustomerServlet?operation=modifier&id=<c:out value="${c.getIdCustomer()}"/>">Modifier</a></td>
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
</body>
</html>