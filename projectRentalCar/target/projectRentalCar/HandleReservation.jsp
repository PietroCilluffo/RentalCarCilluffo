<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestisci prenotazione</title>
<style type="text/css">
body {
	text-align: center;
}

table {
	margin-left: 15%;
	min-width: 70%;
	border: 1px solid #CCC;
	border-collapse: collapse;
}

table tr {
	line-height: 30px;
}

table tr th {
	background: #000033;
	color: #FFF;
}

table tr td {
	border: 1px solid #CCC;
	margin: 5px;
}

input[type=text], input[type=email], input[type=tel] {
	min-width: 60%;
}

input[type=submit], a {
	background: green;
	padding: 5px;
	margin: 5px;
	color: #FFF;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>

	<h1>Modifica le date di  prenotazione</h1>
	<c:url value="/reservation/add" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>



			<tr>
				<td>Data Fine (yyyy-mm-dd):</td>
				<td><input type="date" name="dataFine" value="${dataFine}"
					required></td>
			</tr>
			<tr>
				<td>Data Inizio (yyyy-mm-dd):</td>
				<td><input type="date" name="dataInizio" value="${dataInizio}"
					></td>
			</tr>
			<tr>
				<td>Targa:</td>
				<td><input type="date" name="targa" value="${targa}"
					readonly="readonly"></td>
			</tr>
			<c:if test="${id ne null}">
				<tr>
					<td>ID :</td>
					<td><input type="text" name="idReservation"
						value="${idReservation}" readonly="readonly"></td>
				</tr>
			</c:if>


			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>

		</table>
	</form>
	
	<h1>Elimina prenotazione</h1>
	<c:url value="/reservation/delete" var="registerUrl" />
	<form action="${registerUrl}" method="post" onsubmit=" return window.confirm('Sei sicuro di voler eliminare la prenotazione?');">
		<input type="hidden" name="idReservation" value="${idReservation}">
		<input type="submit" value="Elimina">
	</form>
</body>
</html>