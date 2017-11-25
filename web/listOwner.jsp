
<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 10/11/2017
  Time: 01:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pe.com.ctaf.beautyapp.models.BeautyappService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title> DUEÑO </title>

</head>
<body>

<jsp:include page="menuOwner.jsp"/>


<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<%String ide=(String)request.getSession().getAttribute("uowner");%>
<c:forEach var="owner" items="<%=service.getOwnersById(ide)%>">
    <div class="row">
        <div class="col-md-6">
            <img src="image/user/${owner.id}.jpg" class="img-rounded img-responsive" alt="Cinque Terre" width="360" height="280">
        </div>
        <div class="col-md-6">
            <h4><label> ID : </label> ${owner.id} </h4><p></p>
            <h4><label> DNI : </label> ${owner.dni} </h4><p></p>
            <h4><label>  NOMBRE : </label> ${owner.firstName} </h4><p></p>
            <h4><label> APELLIDO : </label> ${owner.lastName} </h4><p></p>
            <h4><label>  EMAIL : </label> ${owner.email} </h4><p></p>
            <h4><label> PHONE : </label> ${owner.phone} </h4><p></p>

        </div>
    </div>

</c:forEach>

</div>
</div>

</body>
</html>
