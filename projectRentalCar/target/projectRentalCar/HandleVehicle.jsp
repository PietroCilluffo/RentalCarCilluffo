<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handle Vehicle</title>
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
<c:url value="/vehicle/add" var="registerUrl" />
    <form action="${registerUrl}" method="post">
        <table>
                  <c:if test="${vehicle.id ne null}">
                <tr>
                <td> ID:</td>
                    <td><input type="text" name="id" value="${vehicle.id}" readonly="readonly"></td>
                </tr>
            </c:if>
            <tr>
                <td>Targa:</td>
                <td><input type="text" name="targa" value="${vehicle.targa}" required></td>
            </tr>
            <tr>
                <td>Modello:</td>
                <td><input type="text" name="modello" value="${vehicle.modello}" required></td>
            </tr>
           
            <tr>
                <td>Casa:</td>
                <td><input type="text" name="casa" value="${vehicle.casa}" required></td>
            </tr>
                <tr>
                <td>Anno di produzione:</td>
                <td><input type="text" name="anno" value="${vehicle.anno}" required></td>
            </tr>
               
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
          
 </table>
    </form>
    
    
   
    
</body>
</html>