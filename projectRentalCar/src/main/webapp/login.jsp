<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
    body{
        text-align: center;
    }
    table {
        margin-left: 15%;
        min-width: 70%;
        border: 1px solid #CCC;
        border-collapse: collapse;
    }
    table tr{line-height: 30px;}
    table tr th { background: #000033; color: #FFF;}
    table tr td { border:1px solid #CCC; margin: 5px;}
    input[type=text], input[type=email], input[type=tel]{
        min-width: 60%;
    }
    input[type=submit], a{
        background: green;
        padding: 5px;
        margin: 5px;
        color: #FFF;
    }
    a{
        text-decoration: none;
    }
</style>
</head>
<body>
 <c:url value="/login" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <table>
           
             <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${user.email}" required></td>
            </tr>
               <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${user.password}" required></td>
            </tr>
            
           
         
          <c:if test="${user.id eq null}">
                <tr>
                    <td colspan="2"><input type="submit" value="Login"></td>
                </tr>
            </c:if>
 </table>
 
    </form>
</body>
</html>