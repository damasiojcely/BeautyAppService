<%@ page import="pe.com.ctaf.beautyapp.models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>


    <title> CLIENTE </title>

</head>
<body>

<jsp:include page="menuClient.jsp"/>

<table class="table table-hover">
    <tr>
        <th> ID </th>
        <th> FECHA </th>
        <th> RESERVATION TIME </th>
        <th> TOTAL </th>
        <%--   <th>Delete</th>--%>
    </tr>

    <jsp:useBean id="servi" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
    <%String ie=(String)request.getSession().getAttribute("uowner");%>
    <c:forEach var="reservation" items="<%=servi.getReservationByOwner(ie)%>">
        <tr><td><c:out value="${reservation.id}"/></td>
            <td><c:out value="${reservation.reserdate}"/></td>
            <td><c:out value="${reservation.resertime}"/></td>
            <td> <c:out value="${reservation.price}"/></td>
        </tr>
    </c:forEach>
</table>

    </div>
</div>



</body>
</html>
