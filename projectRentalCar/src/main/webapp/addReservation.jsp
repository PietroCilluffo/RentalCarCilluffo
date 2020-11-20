<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*, com.rentalcar.entity.Reservation"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1>Aggiungi prenotazione</h1>
       <c:url value="/reservation/add" var="registerUrl" />
    <form action="${registerUrl}" method="post">
        <table>
            <c:if test="${reservation.id ne null}">
                <tr>
                <td>Customer ID:</td>
                    <td><input type="text" name="id" value="${reservation.id}" readonly="readonly"></td>
                </tr>
            </c:if>
       
            <tr>
                <td>Data Inizio (yyyy-mm-dd):</td>
                <td><input type="date" name="dataInizio" value="${reservation.dataInizio}" required></td>
            </tr>
            <tr>
                <td>Data Fine (yyyy-mm-dd):</td>
                <td><input type="date" name="dataFine" value="${reservation.dataFine}" required></td>
            </tr>
             <tr>
                 <td>Seleziona veicolo:</td>
                 <td>
                 <select name="targa">
					    <option value="${selected}" selected>${selected}</option>
					    <c:forEach items="${vehicleList}" var="vehicle">
					        <c:if test="${vehicle.targa != selected}">
					            <option value="${vehicle.targa}">${vehicle.targa}</option>
					        </c:if>
					    </c:forEach>
					</select>  	
              </td>
            </tr>
       
          
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
           
 </table>
    </form>
    <form action="<c:url value="/reservation/add"/>" method="get">
		<select name="selezione">
			<option value="modello">modello</option>
			<option value="anno">anno</option>
			<option value="casa">casa</option>
			
		</select>
		<input type="text" name="filtro" >
		  <input type="submit" value="Filtra">
		  </form>
    <h1>Veicoli disponibili</h1>
    <table>
    
    	<tr>
				<th>TARGA</th>
				<th>MODELLO</th>
				<th>ANNO</th>
				<th>CASA</th>

			</tr>
    
    <c:forEach items="${vehicleList}" var="vehicle">
				<tr>


					<td>${vehicle.targa}</td>
					<td>${vehicle.modello}</td>
					<td>${vehicle.anno}</td>
					<td>${vehicle.casa}</td>

				</tr>
			</c:forEach>
		</table>
</body>
</html>