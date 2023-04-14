<%@ page import="model.Product"%>
<%@ page import="dao.ProductDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<title>Gestion de produit</title>
</head>
<body>
	
		<header>
		
			<h1>Gestion de produit</h1>
			<h2>Formulaire produit</h2>
	
		</header>
	<div class="content">

		<form action="ProductServlet" method="post">
			<div class="c">
				<label for="id" name="id">Id</label>
				<c:out value="${id}" />
			</div>
			<div class="c">
				<label for="">Nom de produit *</label> <input type="text"
					name="name" />
				<c:out value='${error}' />

			</div>
			<div class="c">
				<label for="">Prix *</label> <input type="text" name="price">

			</div>

			<div class="c">
				<input type="submit" value="Enregistrer" name="submit">
			</div>
		</form>

</div>




		<footer>
		
			<p>Par Melanie Chauvin</p>

		</footer>

</body>
</html>