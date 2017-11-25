<%--
  Created by IntelliJ IDEA.
  User: Sadit
  Date: 10/11/2017
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pe.com.ctaf.beautyapp.models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> CLIENTE </title>
</head>
<body>
<jsp:include page="menuClient.jsp"/>

    <h2> Editar perfil</h2>
    <jsp:useBean id="service" class="pe.com.ctaf.beautyapp.services.BeautyappService"/>
<form action="clients" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-4" > ID : </label>
        <div class="col-sm-8">
            <input type="text" name="id" class="form-control" value="${client.id} "
                    <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
            />
        </div>
    </div>

 <div class=" for-group">
   <label class="control-label col sm-4"> DNI : </label>
     <div class="col-sm-8">
         <input type="text"  class ="form-control" name =" dni"  value="${client.dni}"/>
       
     </div>
< </div>

    </div>
    <div class="form-group">
        <label class="control-label col-sm-4" > First Name : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control"  name="firstName" value="${cllient.firstName}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > Last Name : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="lastName" value="${client.lastName}"/>
        </div>

    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > Email : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="email" value="${client.email}"/>
        </div>

    </div>


    <div class="form-group">
        <label class="control-label col-sm-4" > PASSWORD : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="password" value="${client.password}"/>
        </div>

    </div>
    <div class="form-group">
        <label class="control-label col-sm-4" > PHONE : </label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="phone" value="${client.phone}"/>
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
