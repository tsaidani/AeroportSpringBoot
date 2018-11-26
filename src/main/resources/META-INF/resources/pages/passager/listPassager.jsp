<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Liste des passagers</title>
</head>
<body>


        <jsp:include page="../accueil.jsp">
        <jsp:param  name="titre" value="Vols"/> 
        </jsp:include>
        <hr/>


	<table class="table">
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>prenom</th>
			<th>rue</th>
			<th>code postal</th>
			<th>ville</th>
			<th>pays</th>
			<th>reservation</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="passager" items="${passagers}">
			<tr>
				<td>${passager.idPassager}</td>
				<td>${passager.nom}</td>
				<td>${passager.prenom}</td>
				<td>${passager.adresse.adresse}</td>
				<td>${passager.adresse.codePostal}</td>
				<td>${passager.adresse.ville}</td>
				<td>${passager.adresse.pays}</td>
				<td><c:forEach var="reservation" items="${reservations}">
					${reservation.numeroReservation}
				</c:forEach></td>
				<td><a class="btn btn-success"
					href="./edit?idPassager=${passager.idPassager}">editer</a></td>
				<td><a class="btn btn-danger"
					href="./delete?idPassager=${passager.idPassager}">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a class="btn btn-info" href="./addPassager">nouveau passager</a>
	</div>
	<div align="center">
		<a class="btn btn-warning" href="../accueil">Accueil</a>
	</div>
</body>
</html>