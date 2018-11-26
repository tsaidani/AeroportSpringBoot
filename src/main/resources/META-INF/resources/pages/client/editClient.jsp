<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
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
			<legend>edition de Client</legend>
			<c:choose>
				<c:when test="${client.getClass().simpleName=='ClientPhysique'}">
					<c:url value="saveClientPhy" var="action"></c:url>
				</c:when>
				<c:when test="${client.getClass().simpleName=='ClientMoral'}">
					<c:url value="saveClientMoral" var="action"></c:url>
				</c:when>
				<c:when test="${client.getClass().simpleName=='ClientEl'}">
					<c:url value="saveClientEl" var="action"></c:url>
				</c:when>
			</c:choose>
			<form:form action="${action}" method="get" modelAttribute="client">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="clientId"></form:label>
					<form:input path="clientId" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="titre">titre</form:label>
					<form:input path="titre" cssClass="form-control" />
					<form:errors path="titre" cssClass="form-control"/>
				</div>
				<c:choose>
					<c:when test="${client.getClass().simpleName=='ClientEl'}">
						<div class="form-group">
							<form:label path="prenom">prenom</form:label>
							<form:input path="prenom" cssClass="form-control" />
							<form:errors path="prenom"></form:errors>
						</div>
					</c:when>
					<c:when test="${client.getClass().simpleName=='ClientPhysique'}">
						<div class="form-group">
							<form:label path="prenom">prenom</form:label>
							<form:input path="prenom" cssClass="form-control" />
							<form:errors path="prenom"></form:errors>
						</div>
					</c:when>
					<c:when test="${client.getClass().simpleName=='ClientMoral'}">
						<div class="form-group">
							<form:label path="siret">siret</form:label>
							<form:input path="siret" cssClass="form-control" />
							<form:errors path="siret"></form:errors>
						</div>
					</c:when>
				</c:choose>
				<div class="form-group">
					<form:label path="clientName">nom</form:label>
					<form:input path="clientName" cssClass="form-control" />
					<form:errors path="clientName"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="mail">mail</form:label>
					<form:input path="mail" cssClass="form-control" />
					<form:errors path="mail"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="numeroTel">Telephone</form:label>
					<form:input path="numeroTel" cssClass="form-control" />
					<form:errors path="numeroTel"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="numeroFax">Fax</form:label>
					<form:input path="numeroFax" cssClass="form-control" />
					<form:errors path="numeroFax"></form:errors>
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
				<div class="form-group">
					<form:label path="reservations">reservation</form:label>
					<form:select path="reservations" cssClass="form-control">
						<form:option value="">pas de reservation</form:option>
						<form:options items="${reservations}" itemLabel="numeroReservation" itemValue="dateReservation" />
					</form:select>
					<form:errors path="reservations"></form:errors>
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