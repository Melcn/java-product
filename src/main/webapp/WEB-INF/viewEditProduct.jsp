<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>
<%@ page import="dao.ProductDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Modifier produit</title>
</head>
<body>
	<header>
		<h1>Gestion de produit</h1>
		<h2>Modifier produit</h2>
	</header>
	<div class="content">
	<form action="ProductServlet" method="post">


		Id <input type="text" name="id" value="${ id }" /> 
		Nouveau nom: <input	type="text" name="newName" /> 
		Nouveau prix: <input type="text"name="newPrice" /> 
		<input type="submit" value="edit" name="submit" />

	</form>
	</div>
	<footer>
		<p>Par Melanie Chauvin</p>

	</footer>
</body>
</html>