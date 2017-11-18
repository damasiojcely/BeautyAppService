<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristian
  Date: 11/11/2017
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cree un Horario</title>
</head>
<body>
<h1>
    Establesca un horario
</h1>
<s:form action="createschedule">
    <s:label for="star" value="Start"/>
    <s:textfield id="star" name="star"/>
    <s:label for="end" value="End"/>
    <s:textfield id="end" name="end"/>
    <s:label for="discount" value="Discount"/>
    <s:textfield id="discount" name="discount"/>
</s:form>

</body>
</html>
