<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Aggiungi utente</h1>
       <c:url value="/user/register" var="registerUrl" />
    <form action="${registerUrl}" method="post">
        <table>
                  <c:if test="${user.id ne null}">
                <tr>
                <td>Customer ID:</td>
                    <td><input type="text" name="id" value="${user.id}" readonly="readonly"></td>
                </tr>
            </c:if>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="nome" value="${user.nome}" required></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="cognome" value="${user.cognome}" required></td>
            </tr>
           
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${user.email}" required></td>
            </tr>
                <tr>
                <td>Password:</td>
                <td><input type="text" name="password" value="${user.password}" required></td>
            </tr>
                 <c:if test="${user.id eq null}">
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </c:if>
 </table>
    </form>
</body>
</html>