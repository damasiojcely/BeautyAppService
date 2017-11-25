<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 25/11/2017
  Time: 04:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pe.com.ctaf.beautyapp.models.Owner" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Stylists</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style4.css">
</head>
<body>


<jsp:include page="menuOwner.jsp"/>


<h2> ${action == 'edit' ? "EDITAR ESTILISTA" : "NUEVO ESTILISTA"} </h2>
<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<form action="stylists" method="post" class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-sm-6" > ID : </label>
        <div class="col-sm-8">
            <input type="text" name="id" class="form-control" value="${stylist.id}"<c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-6">DNI:</label>
        <div class="col-md-6">
            <input type="text" name="dni" class="form-control"  value="${stylist.dni}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > First Name : </label>
        <div class="col-sm-8">
            <input type="text" name="firstName" class="form-control" value="${stylist.firstName}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4"> Last Name : </label>
        <div class="col-sm-8">
            <input type="text" name="lastName" class="form-control" value="${stylist.lastName}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4"> Email : </label>
        <div class="col-sm-8">
            <input type="text" name="email" class="form-control" value="${stylist.email}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-6">Tel&eacute;fono:</label>
        <div class="col-md-6">
            <input type="text" name="phone" class="form-control" placeholder="Ingrese # Tel&eacute;fono" value="${owner.phone}"/>
        </div>
    </div>


    <%String ide=(String)request.getSession().getAttribute("uowner");%>
    <input type="hidden" name="oid" class="form-control" value="<%=ide%>"/>
    <%--   </div>

   </div>--%>
    <input type="hidden" value="${action == 'edit' ? "update" : "create"}" name="action"/>

    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-8">
            <button type="submit" class="btn btn-success" value="Ingresar">${action == 'edit' ? "Actualizar" : "Grabar"}</button>

        </div>
    </div>



</form>



</div>
</div>






</body>
</html>

