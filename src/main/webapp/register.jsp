<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort() + path + "/";
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Page d'inscription</title>
</head>

<body>
<h2>Inscrire</h2>
<hr/>
<form method="POST" action="${pageContext.request.contextPath }/register">
    <table>
        <tr>
            <td><label for="username">Entrez Votre username:</label></td>
            <td><input type="text" name="username" id="username"/></td>
        </tr>
        <tr>
            <td><label for="password">Entrez votre mot de pass:</label></td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td><label for="email">Entrez Votre email:</label></td>
            <td><input type="email" name="email" id="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Inscrire"/></td>
        </tr>
    </table>
</form>
</body>
</html>