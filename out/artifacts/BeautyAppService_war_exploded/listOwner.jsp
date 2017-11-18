<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 01:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Propietarios</title>
</head>
<body>

    <h1>Informacion de Propietarios</h1>
    <p>Nombre: <s:property value="firstname"/> </p>
    <p>Apellidos: <s:property value="lastname"/> </p>
    <p>Dni: <s:property value="dni"/> </p>
    <p>Correo Electronico: <s:property value="email"/> </p>
    <p>Telefono: <s:property value="phone"/> </p>

</body>
</html>
