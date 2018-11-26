<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Edition de passager</title>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend>edition de passager</legend>
			<form:form action="savePassager" method="post"
				modelAttribute="passager">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="idPassager">idPassager</form:label>
					<form:input path="idPassager" readonly="true"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="prenom">prenom</form:label>
					<form:input path="prenom" cssClass="form-control" />
					<form:errors path="prenom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="nom">nom</form:label>
					<form:input path="nom" cssClass="form-control" />
					<form:errors path="nom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.adresse">adresse</form:label>
					<form:input path="adresse.adresse" cssClass="form-control" />
					<form:errors path="adresse.adresse"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.codePostal">code postal</form:label>
					<form:input path="adresse.codePostal" cssClass="form-control" />
					<form:errors path="adresse.codePostal"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.ville">ville</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
					<form:errors path="adresse.ville"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.pays">pays</form:label>
					<form:input path="adresse.pays" cssClass="form-control" />
					<form:errors path="adresse.pays"></form:errors>
				</div>
<!-- 				<div class="form-group"> -->
<%-- 					<form:label path="reservations">reservations</form:label> --%>
<%-- 					<c:forEach var="reservation" items="${reservations}"> --%>
<%-- 						<form:select path="reservation.numeroReservation" --%>
<%-- 							cssClass="form-control"> --%>
<%-- 							<form:option value="">pas de salle</form:option> --%>
<%-- 							<form:options items="${reservations}" itemLabel="nom" --%>
<%-- 								itemValue="numeroReservation" /> --%>
<%-- 						</form:select> --%>
<%-- 					</c:forEach> --%>
<!-- 				</div> -->
				<div class="form-group">
				<form:label path="reservations">reservations</form:label>
<%-- 					<c:forEach var="reservation" items="${reservations}"> --%>
					<form:checkboxes items="${reservations}" path="reservations" itemValue="numeroReservation" itemLabel="numeroReservation"/>
<%-- 						<form:checkbox path="reservations" value="reservation.numeroReservation"/> --%>
<%-- 					</c:forEach> --%>
				</div>
				<div>
					<button class="btn btn-success" type="submit">enregistrer</button>
					<a class="btn btn-warning" href="./">annuler</a>
				</div>
			</form:form>
		</fieldset>
	</div>

</body>
</html>