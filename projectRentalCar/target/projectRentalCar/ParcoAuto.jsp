<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parco Auto</title>
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
<c:if test="${sessionScope.isSuper == 1}">
	<a href="/projectRentalCar/HandleVehicle.jsp"> Aggiungi auto</a>
 <h1>Lista delle auto</h1>

		<table>
			<tr>
				<th>Id</th>
				<th>Targa</th>
				<th>Modello</th>
				<th>Casa</th>
				<th>Anno</th>

			</tr>

			<c:forEach items="${vehicleList}" var="vehicle">
				<tr>

					<td>${vehicle.id}</td>
					<td>${vehicle.targa}</td>
					<td>${vehicle.modello}</td>
					<td>${vehicle.casa}</td>
					<td>${vehicle.anno}</td>
				 <td>
                    <form action="<c:url value="/vehicle/update"/>" method="post">
                        <input type="hidden" name="custId" value="${vehicle.id}">
                        <input type="submit" value="aggiorna">
                    </form>

				<td>
					<form action="<c:url value="/vehicle/delete"/>" method="post" onsubmit=" return window.confirm('Sei sicuro di voler eliminare il veicolo?');">
						<input type="hidden" name="id" value="${vehicle.id}"> <input
							style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
				</tr>
			</c:forEach>
		</table>
		
	</c:if>
	<c:if test="${sessionScope.isSuper == 0}">
	
      <h1>Lista delle auto</h1>

		<table>
			<tr>
				<th>Id</th>
				<th>Targa</th>
				<th>Modello</th>
				<th>Casa</th>
				<th>Anno</th>

			</tr>

			<c:forEach items="${vehicleList}" var="vehicle">
				<tr>

					<td>${vehicle.id}</td>
					<td>${vehicle.targa}</td>
					<td>${vehicle.modello}</td>
					<td>${vehicle.casa}</td>
					<td>${vehicle.anno}</td>
			
				</tr>
			</c:forEach>
		</table>
		
	</c:if>
</body>
</html>