<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Accueil Aeroport</title>
</head>

<style>
body {
	background-color: #cccccc; 
	text-align: center;
}
</style>
<body> 
<div><h1>${param["titre"]}  </h1></div>
		<div class="container">
			<div id="Navig"></div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="../accueil">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/aeroportSpring/client">Clients</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/aeroportSpring/reservation">Reservations</a></li>
						<li class="nav-item"><a class="nav-link" href="/aeroportSpring/vol">Vols</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/aeroportSpring/passager">Passagers</a></li>
					</ul>
				</div>
			</nav> 
		</div> 
</body>
</html>