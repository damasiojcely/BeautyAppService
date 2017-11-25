<%@ page import="pe.com.ctaf.beautyapp.models.Owner" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 01:23 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title> ADMINISTRADOR </title>

</head>
<body>


<jsp:include page="menuOwner.jsp"/>

<h2> Editar Perfil </h2>

<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<form action="owners" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-4" > ID : </label>
        <div class="col-sm-8">
            <input type="text" name="id" class="form-control" value="${owner.id} "
                    <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
            />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > DNI : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="dni" value="${owner.dni}"/>
        </div>

    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > First Name : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control"  name="firstName" value="${owner.firstName}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > Last Name : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="lastName" value="${owner.lastName}"/>
        </div>

    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > Email : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="email" value="${owner.email}"/>
        </div>

    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > PASSWORD : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="password" value="${owner.password}"/>
        </div>

    </div>



    <div class="form-group">
        <label class="control-label col-sm-4" > PHONE : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="phone" value="${owner.phone}"/>
        </div>

    </div>

    <input type="hidden" value="${action == 'edit' ? "update" : "agregate"}" name="action"/>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-8">
            <input type="submit" class="btn btn-success" />
        </div>
    </div>
</form>








</div>
</div>


</body>
</html>
