<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 01:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresa tus Datos</title>
</head>
<body>
 <h1>Información del Propietario</h1>
<s:form action="createowner">
    <s:label for="firstname" value="Nombre"/>
    <s:textfield id="firstname" name="firstname"/>
    <s:label for="lastname" value="Apellido"/>
    <s:textfield id="lastname" name="lastname"/>
    <s:label for="dni" value="Dni"/>
    <s:textfield id="dni" name="dni"/>
    <s:label for="email" value="Correo Electronico"/>
    <s:textfield id="email" name="email"/>
    <s:label for="phone" value="Telefono"/>
    <s:textfield id="phone" name="phone"/>
    <s:submit value="Save"/>


</body>
</html>
