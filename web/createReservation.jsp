<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristian
  Date: 11/11/2017
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cree una reservacion</title>
</head>
<body>
<h1>Nueva Reservacion</h1>
<s:label for="reservedat" value="ReservedAt"/>
<s:textfield id="reservedat" name="reservedat"/>
<s:label for="requestedfor" value="RequestedFor"/>
<s:textfield id="requestedfor" name="requestedfor"/>
<s:label for="price" value="Preice"/>
<s:textfield id="price" name="price"/>
<s:label for="start" value="Start"/>
<s:textfield id="start" name="start"/>
<s:label for="end" value="End"/>
<s:textfield id="end" name="end"/>
</body>
</html>
