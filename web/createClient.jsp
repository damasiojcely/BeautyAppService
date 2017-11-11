<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cely
  Date: 10/11/2017
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> CLIENTE</title>
</head>
<body>
 <h1>Ingrese sus datos</h1>
 <s:form action="client">
     <s:label for="dni" value =" DNI del cliente "/>
     <s:textfield id="dni"  name="dni" />

     <s:label for="firstName" value ="Nombre del cliente "/>
     <s:textfield id="firstName"  name="firstname" />

     <s:label for="lastName" value ="Apellido del cliente"/>
     <s:textfield id="lastName"  name="lastname" />

     <s:label for="email" value ="Correo elctronico del cliente "/>
     <s:textfield id="email"  name="email" />

     <s:label for="phone" value ="Telefono dl cliente "/>
     <s:textfield id="phone"  name="phone" />

     <s:submit value="Save"/>
 </s:form>
</body>
</html>
