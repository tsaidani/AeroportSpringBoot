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


        <jsp:include page="../accueil.jsp">
        <jsp:param  name="titre" value="Vols"/> 
        </jsp:include>
        <hr/>

	<table class="table">
		<tr>
			<th>id</th>
			<th>Numéro de la réservation</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="reservation" items="${reservations}">
			<tr>
				<td>${Reservation.numeroReservation}</td>
				<td><fmt:formatDate value="${Reservation.dateReservation}"
						pattern="yyyy/MM/dd" /></td>
				<td><fmt:formatDate value="${Reservation.heureReservation}"
						pattern="HH:mm" /></td>
				<td>${reservation.client}</td>	
				<td>${reservation.passager}</td>	
				<td>${reservation.vol}</td>	
				<td><a class="btn btn-warning"
					href="./editReservation?numeroReservation=${Reservation.numeroReservation}">Edit</a></td>
				<td><a class="btn btn-danger"
					href="./deleteReservation?numeroReservation=${Reservation.numeroReservation}">Delete</a></td>

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