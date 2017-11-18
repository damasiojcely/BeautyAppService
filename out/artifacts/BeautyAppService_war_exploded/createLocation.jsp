<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 11/11/2017
  Time: 01:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresa la ubicación de tu Salon</title>
</head>
<body>
<h1>Completa la informacion</h1>
<s:form action="createLocation">
    <s:combobox label="Departamento" headerKey="-1" headerValue="----Select----" list="#{'1':'LIMA','2':'ICA'}" name="departament"/>
    <s:combobox label="Provincia" headerKey="-1" headerValue="----Select----" list="#{'1':'LIMA','2':'HUARAL'}" name="province"/>
    <s:combobox label="Distrito" headerKey="-1" headerValue="----Select----" list="distric" name="district"/>
    <s:label for="address" value="Direcion"/>
    <s:textfield id="address" name="address"/>

</s:form>
</body>
</html>
