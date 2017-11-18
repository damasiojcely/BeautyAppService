<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Sadit
  Date: 10/11/2017
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ESTILISTA</title>
</head>
<body>

<h1>Registrar al estilista</h1>
   <s:form action="stylist">
       <s:label for="dni" value =" DNI del estilista "/>
       <s:textfield id="dni"  name="dni" />

       <s:label for="firstName" value ="Nombre del estilista "/>
       <s:textfield id="firstName"  name="firstname" />

       <s:label for="lastName" value ="Apellido del estilista"/>
       <s:textfield id="lastName"  name="lastname" />

       <s:label for="email" value ="Correo electronico del estilista "/>
       <s:textfield id="email"  name="email" />

       <s:label for="phone" value ="Telefono  o celular del estilista "/>
       <s:textfield id="phone"  name="phone" />

       <s:submit value="Save"/>
   </s:form>

</body>
</html>
