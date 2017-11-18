<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristian
  Date: 10/11/2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingrese sus datos</title>
</head>
<body>
<h1>
    Inscribase en Nuestro servicio
</h1>
<s:form action="createuser">
    <s:label for="username" value="Username"/>
    <s:textfield id="username" value="username"/>
    <s:label for="password" value="Password"/>
    <s:textfield id="password" value="password"/>
    <s:submit value="Save"/>
</s:form>

</body>
</html>
