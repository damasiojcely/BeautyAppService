<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 18/11/2017
  Time: 02:14 AM
  To change this template use File | Settings | File Templates.
--%>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" style="background-color: #F1F1F1">
<div class="row">
    <div class="col-md-12">

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
                    <li><a href="nosotros.jsp">NOSOTROS</a></li>
                    <li><a href="contacto.jsp">CONTACTANOS</a></li>
                    <li><a href="#"class="glyphicon glyphicon-user" data-toggle="dropdown"> REGISTRARSE </a>

                        <ul class="dropdown-menu" role="menu">
                            <li><a role="menuitem" tabindex="-1" href="newOwner.jsp">Due&ntilde;o</a></li>
                            <li><a role="menuitem" tabindex="-1" href="Form_Client.jsp">Cliente</a></li>
                        </ul>
                    </li>
                    <li><a href="login.jsp" class="glyphicon glyphicon-log-in" >INGRESAR</a></li>
                </ul>
            </div>


        </nav>
    </div>
</div>
</body>
