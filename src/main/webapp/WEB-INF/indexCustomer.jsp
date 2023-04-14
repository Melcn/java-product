<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Customer"%>
<%@ page import="dao.CustomerDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<title>Formulaire client</title>
</head>
<body>
	<header>
		<h1>Gestion de produit</h1>
		<h2>Formulaire client</h2>
	</header>

	<div class="content">
		<div class="c">
			<label for="">Id : </label>
			<c:out value='${id}' />
		</div>
		<div class="c">
			<label for="">Nom : </label> <input type="text" name="nameCustomer">
			<c:out value='${errorName}' />
		</div>
		<div class="c">
			<label for="">Prenom : </label> <input type="text" name="firstName">
		</div>
		<div class="c">
			<label for="">Mail : </label> <input type="mail" name="mail">
			<c:out value='${errorEmail}' />
		</div>
		<div class="c">
			<label for="">Adresse : </label> <input type="text" name="adress">
			<c:out value='${errorAdresse}' />
		</div>
		<div class="c">
				<input type="submit" value="save" name="submit">
			</div>


	</div>

	<footer>
		<p>Par Melanie Chauvin</p>

	</footer>
</body>
</html>