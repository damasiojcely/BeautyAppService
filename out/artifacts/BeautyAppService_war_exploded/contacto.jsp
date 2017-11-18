<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 18/11/2017
  Time: 04:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact us</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1">
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/Footer-with-button-logo.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

    <style>
        .carousel-inner > .item > img,
        .carousel-inner > .item > a > img {
            width: 100%;
            margin: auto;
        }

    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<p id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" style="background-color: #F1F1F1">
    <br>

<div class="container">
    <div class="row">
        <div class="col-sm-1">
        </div>
        <div class="col-sm-5">
            <h1 class="logo"><a href="index.jsp">CTAF | BeautyApp</a></h1>
            <div class="social-networks">
                <a href="https://twitter.com/" class="twitter"><i class="fa fa-twitter"></i></a>
                <a href="https://www.facebook.com/" class="facebook"><i class="fa fa-facebook"></i></a>
                <a href="https://www.google.com/" class="google"><i class="fa fa-google-plus"></i></a>
            </div>
            <div class="col-sm-5">
                <span><img src="image/logo.jpg.JPG" class="img-responsive"></span>
            </div>
        </div>
        <div class="col-sm-6">
            <h2 class="text-center">CONTACTO</h2>
            <h4>Cont&aacute;ctese con nosotros y le responderemos en 24 horas.</h4>
            <h4><span class="glyphicon glyphicon-map-marker"></span> Lima , Peru</h4>
            <h4><span class="glyphicon glyphicon-phone"></span> +51952548524 / +51982014001 / +51953704878 </h4>
            <h4><span class="glyphicon glyphicon-envelope"></span> beautyappservice@gmail.com</h4><br><hr>
        </div>

        <center><div class="container img-responsive" style="width:450px; height: 434px ">
            <form class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-20">
                        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required><br>
                        <textarea class="form-control" name="comments" placeholder="Comentario" rows="7"></textarea><br>
                        <button class="btn btn-default pull-right" type="submit"> Enviar</button>
                    </div>
                </div>
            </form>
        </div></center>

    </div>
</div>



<hr>
<footer id="myFooter">
    <div class="footer-copyright text-center">
        <h5> Copyright 2017, CTAF Todos los derechos reservados. Privacidad | Terminos y condiciones </h5>
    </div>
</footer>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>

