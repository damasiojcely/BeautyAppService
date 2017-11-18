<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 18/11/2017
  Time: 02:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Log in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet" tye="text/css" media="all" />
    <link href="css/bootstrap.css" rel="stylesheet"/>

</head>
<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>

<nav class="navbar navbar-inverse ">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a  href="index.jsp"><img src="image/LOGO.png" width="120" height="50"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="">NOSOTROS</a></li>
            <li><a href="">INFORMATE</a></li>
            <li><a href="">CONTACTANOS</a></li>
            <li><a href="#"class="glyphicon glyphicon-user" data-toggle="dropdown"> REGISTRARSE </a>

                <ul class="dropdown-menu" role="menu">
                    <li><a role="menuitem" tabindex="-1" href="createOwner.jsp">Due&ntilde;o</a></li>
                    <li><a role="menuitem" tabindex="-1" href="createClient.jsp">Cliente</a></li>
                </ul>
            </li>
            <li><a href="login.jsp" class="glyphicon glyphicon-log-in" >INGRESAR</a></li>
        </ul>
    </div>


</nav>


<center><div class="container" style="width:450px; height: 434px ">
    <h2>Log in</h2><br>
    <form class="form-horizontal" action="login" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id">Id:</label>
            <div class="col-sm-10">
                <input type="id" class="form-control" id="id" placeholder="Enter id" name="id">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="username">Email:</label>
            <div class="col-sm-10">
                <input type="username" class="form-control" id="username" placeholder="Enter username" name="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <button type="submit" class="btn btn-primary" value="Ingresar">Ingresar</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <label class="control-label">Si aun no tienes cuenta, Registrate <a href="createUser.jsp">AQUI</a></label>
            </div>
        </div>
    </form>
</div></center>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>

