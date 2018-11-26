<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Liste des personnes</title>
</head>
<body>


        <jsp:include page="../accueil.jsp">
        <jsp:param  name="titre" value="Vols"/> 
        </jsp:include>
        <hr/>

	<table class="table">
		<tr>
			<th>id</th>
			<th>titre</th>
			<th>prenom/siret</th>
			<th>nom</th>
			<th>mail_client</th>
			<th>Telephone</th>
			<th>Fax</th>
			<th>adresse</th>
			<th>code postal</th>
			<th>ville</th>
			<th>pays</th>

		</tr>
		<c:forEach var="client" items="${clients}">
			<tr>
				<td>${client.clientId}</td>
				<td>${client.titre}</td>
				<c:choose>
				<c:when
						test="${client.getClass().simpleName=='ClientEl'}"><td>${client.prenom}</td></c:when>
				<c:when
						test="${client.getClass().simpleName=='ClientPhysique'}"><td>${client.prenom}</td></c:when>
				
	
				<c:when
					test="${client.getClass().simpleName=='ClientMoral'}"><td>${client.siret}</td></c:when>
				</c:choose>
				<td>${client.clientName}</td>
				<td>${client.mail}</td>
				<td>${client.numeroTel}</td>
				<td>${client.numeroFax}</td>
				<td>${client.adresse.adresse}</td>
				<td>${client.adresse.codePostal}</td>
				<td>${client.adresse.ville}</td>
				<td>${client.adresse.pays}</td>
				<td><a class= "btn btn-danger" href="./deleteClient?clientId=${client.clientId }">Supprimer</a></td>
				<td><a class= "btn btn-warning" href="./editClient?clientId=${client.clientId }">Edition</a></td>

			</tr>
		</c:forEach>
	</table>
	<div>
	<a class= "btn btn-success" href="./addClientPhy">Ajouter Client Physique</a>
	<a class= "btn btn-success" href="./addClientMoral">Ajouter Client Moral</a>
	<a class= "btn btn-success" href="./addClientEl">Ajouter Client El</a>
	</div>
	<div align="center">
		<a class="btn btn-warning" href="../accueil">Accueil</a>
	</div>
</body>
</html>