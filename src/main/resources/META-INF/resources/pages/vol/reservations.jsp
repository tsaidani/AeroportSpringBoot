<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>listReservation</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
</head>
<body>
	<table class="table">
		<tr>
			<th>Numéro de la réservation</th>
			<th>Date Réservation</th>
			<th>Client</th>
			<th>Passager</th>
			<th>Vol</th>
			<th>Editer</th>
			<th>Supprimer</th>
		</tr>

		<c:forEach var="reservation" items="${reservations}">
			<tr>
				<td>${reservation.numeroReservation}</td>
				<td><fmt:formatDate value="${reservation.dateReservation}"
						pattern="yyyy/MM/dd" /></td>
				<%-- <td><fmt:formatDate value="${reservation.heureReservation}"
						pattern="HH:mm" /></td> --%>

				<td>${reservation.client.clientName}</td>
				<td>${reservation.passager.nom }</td>
				<td>${reservation.vol.idVol}</td>

				<td><a class="btn btn-warning"
					href="./editReservation?numeroReservation=${reservation.numeroReservation}">Edit</a></td>
				<td><a class="btn btn-danger"
					href="./deleteReservation?numeroReservation=${reservation.numeroReservation}">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<div>
		<a class="btn btn-success" href="./addReservation">New Reservation</a>
	</div>
	<div align="center">
		<a class="btn btn-warning" href="../accueil">Accueil</a>
	</div>

</body>
</html>