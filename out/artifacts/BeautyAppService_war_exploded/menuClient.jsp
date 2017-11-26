<%@ page import="pe.com.ctaf.beautyapp.models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 25/11/2017
  Time: 02:27 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title> CLIENTE </title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style4.css">
</head>
<body>


<div class="wrapper">
    <!-- Sidebar Holder -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <a href="index.jsp"><h3> CTAF | BeautyApp </h3></a>
            <a href="index.jsp"><strong> BeautyApp </strong></a>
        </div>

        <ul class="list-unstyled components">

            <li class="active">
                <a href="index2.jsp" >
                    <i class="glyphicon glyphicon-home"></i>
                    HOME
                </a>
            </li>



            <li>
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">
                    <i class="glyphicon glyphicon-user"></i>
                    MI PERFIL
                </a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li><a href="listClient.jsp"> PERFIL</a></li>
                    <jsp:useBean id="ser" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
                    <%String i=(String)request.getSession().getAttribute("uclient");%>
                    <c:forEach var="client" items="<%=ser.getClientsById(i)%>">
                        <li><a href="clients?action=edit&id=<c:out value="${client.id}"/>"> EDITAR</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li>
                <a href="listSalon.jsp">
                    <i class="glyphicon glyphicon-briefcase"></i>
                    BUSCAR SALONES DE BELLEZA
                </a>
                <a href="listReservation.jsp">
                    <i class="glyphicon glyphicon-duplicate"></i>
                    MIS RESERVACIONES
                </a>
            </li>


        </ul>
    </nav>

    <!-- Page Content Holder -->
    <div id="content">

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                        <i class="glyphicon glyphicon-align-left"></i>
                        <span>Menu</span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp">LOG OUT</a></li>
                    </ul>
                </div>
            </div>
        </nav>



        <!-- jQuery CDN -->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <!-- Bootstrap Js CDN -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>
