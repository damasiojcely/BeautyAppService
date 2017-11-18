<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 18/11/2017
  Time: 03:43 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>

    <title>Nosotros</title>
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
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" style="background-color: #F1F1F1">

<jsp:include page="head.jsp"/>


<div class="center-block" >
    <div class="center-block" >
        <center><h2 class="text-center">Conoce acerca de nosotros</h2></center>
    </div>
</div>


<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel slide"></div>
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner img-responsive" role="listbox">

            <div class="item active img-responsive">
                <img src="image/icono1.jpg" alt="Chania" width="460" height="345">
                <div class="carousel-caption">
                    <h3>RESERVACIONES</h3>
                    <p>Realiza tus reservas a cualquier hora</p>
                </div>
            </div>

            <div class="item img-responsive">
                <img src="image/icono2.jpg" alt="Chania" width="460" height="345">
                <div class="carousel-caption">
                    <h3>GESTIONA TUS SALONES DE BELLEZA</h3>
                    <p>Administra tus salones y a el personal</p>
                </div>
            </div>

            <div class="item img-responsive">
                <img src="image/icono3.png" alt="Flower" width="460" height="345">
                <div class="carousel-caption">
                    <h3>CONTROL</h3>
                    <p>Controla todas tus operaciones</p>
                </div>
            </div>


        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<br>

<div id="about" class="container-fluid img-responsive">
    <div class="row">
        <div class="col-sm-1">
        </div>
        <div class="col-sm-5">
            <h2>BeautyApp Service</h2><br>
            <h4 class="text-justify">Esta plataforma te ayudar&aacute; a encontrar tu salon ideal para reservar tu cita de una manera r&aacute;pida y sencilla.
                Si cuentas con un centro de belleza tambi&eacute;n podr&aacute;s promocionar tu servicios y controlar tu operaciones.
                Ahora podr&aacute;s encontrar tu salon ideal al alcance de tus manos desde una computadora o dispositivo m&oacute;vil y poder contar adem&aacute;s con
                amplios servicios y promociones que podr&aacute;s disfrutar con tus amigas.

            </h4><br>
        </div><p> </p>
        <center>
        <div class="col-sm-5">
            <span><img src="image/eslogan1.jpg" class="img-responsive img-rounded" WIDTH="300" HEIGHT="552"></span>
        </div></center>

    </div>
    <div class="col-sm-1">
    </div>

    <div class="img-responsive">
        <center><h3 class="img-responsive"><span>Haz tus reservaciones desde cualquier lugar y utiliza tu tiempo para otras actividades.</span></h3></center>

    </div>
</div>
<br>
<footer id="myFooter">
    <div class="footer-copyright text-center">
        <h5> Copyright 2017, CTAF Todos los derechos reservados. Privacidad | Terminos y condiciones </h5>
    </div>
</footer>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
