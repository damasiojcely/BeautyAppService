<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Sadit

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SALON DE BELLEZA</title>
</head>
<body>
<h1>Registrar al  centro de belleza</h1>
<s:form action="salon">
    <s:label for="name" value =" Nombre del centro de belleza"/>
    <s:textfield id="name"  name="name" />

    <s:label for="phone" value ="Numero de telefono del centro de belleza "/>
    <s:textfield id="phone"  name="phone" />


    <s:label for="email" value ="Correo electronico del centro de belleza "/>
    <s:textfield id="email"  name="email" />

    <s:submit value="Save"/>

</s:form>

</body>
</html>
