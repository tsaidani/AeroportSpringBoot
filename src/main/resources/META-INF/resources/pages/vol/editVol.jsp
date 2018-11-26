<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire vol</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend> edition de vol</legend>
			<form:form action="saveVol" method="get" modelAttribute="vol">
				<form:hidden path="version" readonly="readonly" />
				<div class="form-group">
					<form:label path="idVol">idVol : </form:label>
					<form:input path="idVol" cssClass="form-control" readonly="true" />
				</div>


				<div class="form-group">
					<form:label path="aeroportDepart.idAeroport">aeroportDepart : </form:label>
					<form:select path="aeroportDepart.idAeroport"
						cssClass="form-control">
						<form:option value="">Pas d'aeroport</form:option>
						<form:options items="${aeroports}" itemLabel="nom"
							itemValue="idAeroport" />
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="aeroportArrivee.idAeroport">aeroportArrivee  : </form:label>
					<form:select path="aeroportArrivee.idAeroport" items="${aeroports}"
						itemLabel="nom" itemValue="idAeroport" cssClass="form-control"></form:select>
				</div>
				<div class="form-group">
					<form:label path="dateDepart">dateDepart : </form:label>
					<form:input type="date" path="dateDepart" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="dateArrivee">dateArrivee : </form:label>
					<form:input type="date" path="dateArrivee" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="heureDepart">heureDepart : </form:label>
					<form:input type="time" path="heureDepart" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="heureArrivee">heureArrivee : </form:label>
					<form:input type="time" path="heureArrivee" cssClass="form-control" />
				</div>
				<!-- 								<div class="form-group"> -->
				<%-- 									<form:label path="reservations">reservations : </form:label> --%>
				<%-- 									<form:input path="reservations" cssClass="form-control" /> --%>
				<!-- 								</div> -->
				<!-- 				<div class="form-group"> -->
				<%-- 					<form:label path="reservations">reservations : </form:label> --%>
				<%-- 					<form:select path="reservations" cssClass="form-control"> --%>
				<%-- 						<form:option value="">Pas de réservation</form:option> --%>
				<%-- 						<form:options items="${reservations}" itemLabel="passager" --%>
				<%-- 							itemValue="numeroReservation" /> --%>
				<%-- 					</form:select> --%>
				<%-- 					<form:errors path="reservations"></form:errors> --%>
				<!-- 				</div> -->



				

				<div>
					<button class="btn btn-success" type="submit">Sauvegarder</button>
					<a class="btn btn-danger" href="./">Annuler</a>
					<!-- Remonte d'une page si annulation  -->
				</div>

			</form:form>
		</fieldset>
	</div>


</body>
</html>