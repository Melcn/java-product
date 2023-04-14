<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Customer"%>
<%@ page import="dao.CustomerDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Modifier client</title>
</head>
<body>
	<header>
		<h1>Gestion de produit</h1>
		<h2>Modifier client</h2>
	</header>
	<div class="content">
	<form action="CustomerServlet" method="post">


		Id <input type="text" name="id" value="${ id }" /> 
		Nouveau nom: <input	type="text" name="newNameCustomer" /> 
		Nouveau prenom: <input type="text" name="newFirstNameCustomer" /> 
		Nouveau mail: <input type="text" name="newMail" /> 
		Nouveau adresse : <input type="text" name="newAdress" /> 
		<input type="submit" value="edit" name="submit" />

	</form>
	</div>
	<footer>
		<p>Par Melanie Chauvin</p>

	</footer>
</body>
</html>