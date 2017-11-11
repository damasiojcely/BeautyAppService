<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 08:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro del Servicio</title>
</head>
<body>
 <h1>Informacion del servicio</h1>
<s:form action="createservice">
    <s:label for="name" value="Nombre del servcio"/>
    <s:textfield id="name" name="name"/>
    <s:label for="price" value="Precio"/>
    <s:textfield id="price" name="price"/>
    <s:label for="description" value="Descripción del servicio"/>
    <s:textarea id="description" name="description"/>
</s:form>

</body>
</html>
