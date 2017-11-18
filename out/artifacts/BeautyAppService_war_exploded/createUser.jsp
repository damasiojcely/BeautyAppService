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

<s:form action="createuser">
    <s:label for="username" value="Username"/>
    <s:textfield id="username" value="username"/>
    <s:label for="password" value="Password"/>
    <s:textfield id="password" value="password"/>
    <s:submit value="Save"/>
</s:form>

<div class="container">
    <form action="" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <legend>Beauty Service</legend>
        </div>

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Label:</label>
            <div class="col-sm-10">
                <input type="text" name="username" id="username" class="form-control" value="" title="" required="required">
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Label:</label>
            <div class="col-sm-10">
                <input type="text" name="password" id="password" class="form-control" value="" title="" required="required">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
