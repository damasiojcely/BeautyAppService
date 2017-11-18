
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 01:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <title>New Owner</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1">
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <style>
        .carousel-inner > .item > img,
        .carousel-inner > .item > a > img {
            width: 100%;
            margin: auto;
        }

    </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" style="background-color: #F1F1F1">
<jsp:include page="head.jsp"/>
<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>

<center><div class="container img-responsive" style="width:500px; height: 434px ">

    <form class="form-horizontal" action="organizers" method="post">
        <h2>${action == 'edit' ? "Editar Perfil" : "Nuevo Administrador"}</h2><br>
        <div class="form-group">
            <label class="control-label col-md-6">ID:</label>
            <div class="col-md-6">
                <input type="text" name="id" class="form-control" placeholder="Id" value="${owner.id}"
                        <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
                />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Nombres:</label>
            <div class="col-md-6">
                <input type="text" name="firstName" class="form-control" placeholder="First Name" value="${owner.firstname}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Apellidos:</label>
            <div class="col-md-6">
                <input type="text" name="lastName" class="form-control" placeholder="Last Name" value="${owner.lastname}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Correo Electr&oacute;nico:</label>
            <div class="col-md-6">
                <input type="text" name="email" class="form-control" placeholder="Example@gmail.com" value="${owner.email}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Contrase&ntilde;a:</label>
            <div class="col-md-6">
                <input type="password" name="password" class="form-control" placeholder="Ingrese una contrase&ntilde;a" value="${owner.password}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">DNI:</label>
            <div class="col-md-6">
                <input type="text" name="dni" class="form-control" placeholder="Ingrese DNI" value="${owner.dni}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Tel&eacute;fono:</label>
            <div class="col-md-6">
                <input type="text" name="phone" class="form-control" placeholder="Ingrese # Tel&eacute;fono" value="${owner.phone}"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-md-6">
                <button type="submit" class="btn btn-primary" value="Ingresar">${action == 'edit' ? "Actualizar" : "Grabar"}</button>

            </div>
        </div>
    </form>
</div></center>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>