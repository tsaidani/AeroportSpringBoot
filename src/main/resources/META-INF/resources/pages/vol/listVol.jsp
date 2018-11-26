<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des personnes</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

        <jsp:include page="../accueil.jsp">
        <jsp:param  name="titre" value="Vols"/> 
        </jsp:include>
        <hr/>
	<table class="table">
		<tr>
			<th>idVol</th>
			<th>aeroportDepart</th>
			<th>aeroportArrivee</th>
			<th>dateDepart</th>
			<th>dateArrivee</th>
			<th>heureDepart</th>
			<th>heureArrivee</th>
			<th>Reservations</th>
			<th>Editer</th>
			<th>Supprimer</th>

		</tr>
		<c:forEach var="vol" items="${vols}">
			<tr>
				<td>${vol.idVol }</td>
				<td>${vol.aeroportDepart.idAeroport }</td>
				<td>${vol.aeroportArrivee.idAeroport }</td>
				<td><fmt:formatDate value="${vol.dateDepart}"
						pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${vol.dateArrivee}"
						pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${vol.heureDepart}" pattern="HH:mm" /></td>
				<td><fmt:formatDate value="${vol.heureArrivee}" pattern="HH:mm" /></td>
<%-- 				<td><c:forEach var="resa" items="${reservations}"> --%>
<%-- 					${resa.numeroReservation} --%>
<%-- 				</c:forEach></td> --%>
				<td><a class="btn btn-warning" href="./reservations?id=${vol.idVol}">R�servations</a></td>
				<td><a class="btn btn-info" href="./edit?id=${vol.idVol }">Editer</a></td>
				<td><a class="btn btn-danger" href="./delete?id=${vol.idVol }">Supprimer</a></td>
				<!--  il ne faut afficher certaines parties de code qu'� certaines conditions : cout si formateur, ordi et entreprise si stagiaire... -->
			</tr>
		</c:forEach>

	</table>
	<div>
	<a class="btn btn-success" href="addVol">New Vol</a>
	</div>
	<div align="center">
		<a class="btn btn-warning" href="../accueil">Accueil</a>
	</div>
</body>
</html>