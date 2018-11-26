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
<title>Edition de personne</title>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend>edition de personne</legend>
			<c:choose>
				<c:when test="${personne.getClass().simpleName=='Formateur'}">
					<c:url value="saveFormateur" var="action"></c:url>
				</c:when>
				<c:otherwise>
					<c:url value="saveStagiaire" var="action"></c:url>
				</c:otherwise>
			</c:choose>
			<form:form action="${action}" method="get" modelAttribute="personne">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="titre">titre</form:label>
					<form:select path="titre" cssClass="form-control" items="${titres}"
						itemLabel="titre" />
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
					<form:label path="adresse.numero">numero</form:label>
					<form:input type="number" path="adresse.numero"
						cssClass="form-control" />
					<form:errors path="adresse.numero"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.rue">rue</form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
					<form:errors path="adresse.rue"></form:errors>
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
					<form:label path="dtNaiss">date de naissance</form:label>
					<form:input type="date" path="dtNaiss" cssClass="form-control" />
					<form:errors path="dtNaiss"></form:errors>
				</div>
				<c:choose>
					<c:when test="${personne.getClass().simpleName=='Formateur'}">
						<div class="form-group">
							<form:label path="cout">cout</form:label>
							<form:input path="cout" cssClass="form-control" />
							<form:errors path="cout"></form:errors>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<form:label path="entreprise">entreprise</form:label>
							<form:input path="entreprise" cssClass="form-control" />
							<form:errors path="entreprise"></form:errors>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="form-group">
					<form:label path="salle">salle</form:label>
					<form:select path="salle.numero" cssClass="form-control">
						<form:option value="">pas de salle</form:option>
						<form:options items="${salles}" itemLabel="nom" itemValue="numero"/>
					</form:select>
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