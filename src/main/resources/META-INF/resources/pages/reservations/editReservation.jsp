<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Edition de réservation</legend>
			<form:form action="saveReservation" method="get"
				modelAttribute="reservation">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="numeroReservation">Numéro de la réservation</form:label>
					<form:input path="numeroReservation" readonly="true"
						cssClass="form-control"></form:input>
					<form:errors path="numeroReservation"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="dateReservation">Date de la réservation</form:label>
					<form:input type="date" path="dateReservation"
						cssClass="form-control"></form:input>
					<form:errors path="dateReservation"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="heureReservation">heureReservation : </form:label>
					<form:input type="time" path="heureReservation" cssClass="form-control" />
					<form:errors path="heureReservation"></form:errors>
				</div>
				<%-- 	<div class="form-group">
					<form:label path="heureReservation">Heure de la réservation</form:label>
					<form:input type="time" path="heureReservation"
						cssClass="form-control"></form:input>
					<form:errors path="heureReservation"></form:errors>
				</div> --%>

				<div>
					<button class="btn btn-success" type="submit">Valider</button>
					<a class="btn btn-danger" href="./">Annuler</a>
				</div>
			</form:form>
		</fieldset>
	</div>

</body>
</html>