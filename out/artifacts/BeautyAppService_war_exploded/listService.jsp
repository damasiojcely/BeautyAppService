<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 08:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servicios del Slon</title>

</head>
<body>
 <h1>Lista de Servicios</h1>
 <p>Nombre del servicio: <s:property value="name"/> </p>
 <p>Precio: <s:property value="price"/> </p>
 <p>Descripción del servicio: <s:property value="description"/> </p>

</body>
</html>
