<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
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

<script>
function check(index) {
  var temp = document.getElementById(index).value;
  var arr1 = temp.split("-");
 
 
  var d1 = new Date(arr1[0],arr1[1]-1,arr1[2]);

  var r1 = d1.getTime();
  var today = new Date();
  var difference = r1 -today.getTime() ;
  var days = Math.ceil(difference / (1000 * 3600 * 24));
  if(days-1 > 2){
	return true;
  }else{
	  alert("Il numerno di giorni dalla data inizio è minore di 2");
	  return false;
	 
  }
  
}
</script>
</head>
<body>
	<% String superU = null;
 
    
    %>

	<c:if test="${sessionScope.isSuper == 0}">
		<h1>Benvenuto utente ${sessionScope.nome}</h1>
	<form action="<c:url value="/vehicle/add"/>" method="get">

			<input type="submit" value="Parco Auto">
		</form>
		<form action="<c:url value="/reservation/add"/>" method="get">

			<input type="submit" value="Aggiungi prenotazioni">
		</form>

		<h1>Lista delle prenotazioni</h1>

		<table>
			<tr>
				<th>Targa</th>
				<th>Modello</th>
				<th>Data Inizio</th>
				<th>Data fine</th>
				<th>Approvazione</th>

			</tr>

			<c:forEach items="${reservationList}" var="reservation"
				varStatus="status">
				<tr>
					<form action="<c:url value="/reservation/update"/>" method="post" onSubmit = "return check('${status.index}');">
						<td><input type="text" name="targa"
							value="${vehicleList[status.index].targa}" readonly></td>
						<td><input type="text" name="modello"
							value="${vehicleList[status.index].modello}" readonly></td>
						<td><input type="date" name="dataInizio" id = "${status.index}"
							value="${reservation.dataInizio}" readonly></td>
						<td><input type="date" name="dataFine"  
							value="${reservation.dataFine}" readonly></td>
						<td><input type="text" name="approvazione"
							value="${reservation.approvazione}" readonly></td>
						<td><input type="hidden" name="idReservation"
							value="${reservation.id}"> <input type="submit"
							value="Modifica" />
						<td></td>

						<td>
					</form>

				</tr>
			</c:forEach>
		</table>

	</c:if>

	<c:if test="${sessionScope.isSuper == 1}">

		<h1>Benvenuto admin ${sessionScope.nome}</h1>


		<a href="addUser.jsp"> Aggiungi utente</a>
		<form action="<c:url value="/vehicle/add"/>" method="get">

			<input type="submit" value="Parco Auto">
		</form>
		<h1>Lista degli utenti</h1>
		<form action="<c:url value="/home"/>" method="post">
		<select name="selezione">
			<option value="nome">Nome</option>
			<option value="cognome">Cognome</option>
			<option value="email">Email</option>
			
		</select>
		<input type="text" name="filtro" >
		  <input type="submit" value="Filtra">
		  </form>
		<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>email</th>

			</tr>

			<c:forEach items="${userList}" var="user">
				<tr>

					<td>${user.id}</td>
					<td >${user.nome}</td>
					<td>${user.cognome}</td>
					<td>${user.email}</td>
					<td>
						<form action="<c:url value="/user/handle"/>" method="post">
							<input type="hidden" name="custId" value="${user.id}"> <input
								type="submit" value="gestisci" >
						</form>
					<td>
						<form action="<c:url value="/user/delete"/>" method="post" onsubmit=" return window.confirm('Sei sicuro di voler eliminare l'utente?');">
							<input type="hidden" name="custId" value="${user.id}"> 
							<input
								style="background: #F00;" type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
</body>
</body>
</html>