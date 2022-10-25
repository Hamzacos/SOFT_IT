<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "//" + request.getServerName() + ":" + request.getLocalPort() + path + "//"; 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>S'inscrire</title>
</head>
<body>
<h2>page de connexion</h2>
<form method="POST" action="${pageContext.request.contextPath }/login">
    <table>
        <tr>
            <td><label for="username">Nom d'utilisateur:</label></td>
            <td><input type="text" name="username" id="username" /></td>
        </tr>
        <tr>
            <td><label for="password"> Mot de passe:</label></td>
            <td><input type="password" name="password" id="password" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Connexion" /></td>
            <td><a href="javascript:window.location.href='register.jsp'">S'inscrire</a></td>
        </tr>
    </table>
</form>
</body>
</html>