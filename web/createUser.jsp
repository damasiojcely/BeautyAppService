<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristian
  Date: 10/11/2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingrese sus datos</title>
</head>
<body>
<h1>
    Inscribase en Nuestro servicio
</h1>


<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Sing up</h3>
    </div>
    <div class="panel-body">

        <div class="container">
            <form action="createuser.action" method="post" class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">Username:</label>
                    <div class="col-sm-10">
                        <input type="text" name="username" id="username" class="form-control" value="username" title="" required="required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password:</label>
                    <div class="col-sm-10">
                        <input type="text" name="password" id="password" class="form-control" value="password" title="" required="required">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary">Sing in</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
