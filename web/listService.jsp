<%@ page import="pe.com.ctaf.beautyapp.models.Owner" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lnakaya
  Date: 7/1/2017
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title> DUEÑO </title>

</head>
<body>

<jsp:include page="menuOwner.jsp"/>


<div class="row">
    <jsp:useBean id="servic" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
    <%String ie=(String)request.getSession().getAttribute("uowner");%>
    <c:forEach var="service" items="<%=servic.getServiceByOwner(ie)%>">
        <div class="col-md-6">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#${service.id}">${service.name}</a>
                        </h4>
                    </div>

                    <div id="${service.id}" class="panel-collapse collapse">
                        <div class="panel-body">
                            <p> PRICE : ${service.price} </p>
                        </div>
                        <div class="panel-footer">
                            <button type="button" class="btn btn-warning"><a href="services?action=edit&id=<c:out value="${service.id}"/>">Edit</a></button>

                        </div>
                    </div>

                </div>
            </div>
        </div>

    </c:forEach>


</div>





</div>
</div>


</body>
</html>
