<%--
  Created by IntelliJ IDEA.
  User: Sadit
  Date: 10/11/2017
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pe.com.ctaf.beautyapp.models.Stylist" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DUEÑO</title>
</head>
<body>

<jsp:include page="menuOwner.jsp"/>

<div class="row">

    <jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
        <%String ide=(String)request.getSession().getAttribute("uorganizer");%>
    <c:forEach var="stylist" items="<%=service.getStylistByOwner(ide)%>">
    <div class="col-md-6">

        <div class="media">
            <div class="media-left media-middle">
                <img src="image/Stylist/${stylist.id}.jpg" class="media-object" style="width:200px">
            </div>
            <div class="media-body">
                <h4 class="media-heading">${stylist.firstName}</h4>
                <p>LAST NAME : ${stylist.lastName} </p>
                <p> EMAIL : ${stylist.email} </p>
                <p> PHONE  :  ${stylist.phone} </p>
                <p> DNI  :  ${stylist.dni} </p>
                <P><button type="button" class="btn btn-default"><a href="stylists?action=edit&id=<c:out value="$stylist.id}"/>">Edit</a></button>


            </div>
        </div>
        <hr>
    </div>
    </c:forEach>

</div>



</div>
</div>





</body>
</html>