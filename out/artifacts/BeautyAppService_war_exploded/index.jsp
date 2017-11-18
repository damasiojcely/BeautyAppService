<!DOCTYPE html>
<html>
<head>

  <title>BeautyApp</title>
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
<p id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" style="background-color: #F1F1F1">
  <jsp:include page="head.jsp"/>

<div class="center-block" >
  <div class="center-block" >
    <center><h2 class="text-center">BeautyApp Service</h2></center>
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

<br>
<!-- Container (About Section) -->
<div id="about" class="container-fluid img-responsive">
  <div class="row">
    <div class="col-sm-1">
    </div>
    <div class="col-sm-4">
      <h2 style="color: #FF427E">APROVECHA</h2><br>
      <h3>Haz tus reservaciones desde cualquier lugar y utiliza tu tiempo en otras actividades.</h3><br>
    </div>
    <div class="col-sm-1">
    </div>
    <div class="col-sm-5 img-responsive">
      <span><img src="image/eslogan.png" class="img-responsive img-rounded" WIDTH="400" HEIGHT="400"></span>
    </div>
  </div>
</div>

<!--->

<!--/footer-->
<hr>
<footer id="myFooter">
  <div class="container">
    <div class="row">
      <div class="col-sm-3">
        <h2 class="logo"><a href="#"> CTAF | BeautyApp </a></h2>
      </div>
      <div class="col-sm-2">
        <h5> Funciones </h5>
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="login.jsp">Sign in</a></li>
        </ul>
      </div>
      <div class="col-sm-2">
        <h5>Que hacemos?</h5>
        <ul>
          <li><a href="">Especialidades</a></li>
          <li><a href="createClient.jsp">Registro Cliente</a></li>
          <li><a href="createOwner.jsp">Registro Dueño</a></li>
        </ul>
      </div>
      <div class="col-sm-2">
        <h5> Contactanos</h5>
        <ul>
          <li><a href="#">CTAF</a></li>
          <li><a href="">Escribenos</a></li>
        </ul>
      </div>
      <div class="col-sm-3">
        <div class="social-networks">
          <a href="https://twitter.com/" class="twitter"><i class="fa fa-twitter"></i></a>
          <a href="https://facebook.com/" class="facebook"><i class="fa fa-facebook"></i></a>
          <a href="https://google.com/" class="google"><i class="fa fa-google-plus"></i></a>
          <a href="" class=""><i class=" "></i></a>

        </div>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <p> Copyright 2017, CTAF Todos los derechos reservados. Privacidad | Terminos y condiciones </p>
  </div>
</footer>


<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>


</body>
</html>
