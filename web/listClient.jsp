<%--
  Created by IntelliJ IDEA.
  User: Sadit
  Date: 10/11/2017
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pe.com.ctaf.beautyapp.models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CLIENTE</title>
</head>
<body>



<jsp:include page="menuClient.jsp"/>
<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<%String ide=(String)request.getSession().getAttribute("uorganizer");%>

<c:forEach var="organizer" items="<%=service.getClientById(ide)%>">
    <div class="row">
        <div class="col-md-6">
            <img src="image/user/${client.id}.jpg" class="img-rounded img-responsive" alt="Cinque Terre" width="360" height="280">
        </div>
        <div class="col-md-6">
            <h4><label> ID : </label> ${client.id} </h4><p></p>
            <h4><label> DNI : </label> ${client.dni} </h4><p></p>
            <h4><label>  NOMBRE : </label> ${client.firstName} </h4><p></p>
            <h4><label> APELLIDO : </label> ${client.lastName} </h4><p></p>
            <h4><label>  EMAIL : </label> ${client.email} </h4><p></p>
            <h4><label> PHONE : </label> ${client.phone} </h4><p></p>

        </div>

    </div>

</c:forEach>


</div>
</div>




</body>
</html>
