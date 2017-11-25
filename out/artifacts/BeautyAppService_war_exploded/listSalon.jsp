<%--
  Created by IntelliJ IDEA.
  User: Sadit
  Date: 10/11/2017
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="pe.com.ctaf.beautyapp.models.Salon" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SALON DE BELLEZA</title>
</head>
<body>
<jsp:include page="menuClient.jsp"/>

<div class="row">
    <jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
    <c:forEach var="court" items="${service.salon}">
        <div class="col-md-4">
            <div class="thumbnail">
                    <%--<a href="" target="_blank">--%>
                <img src="image/salon/${salon.id}.jpg" alt="Lights" style="width:100%" data-toggle="modal" data-target="#${salon.id}">
                <div class="caption">
                    <p>${salon.name}</p>
                    <p>${salon.address}</p>
                </div>


                <div class="modal fade" id="${salon.id}" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">${salon.name}</h4>
                            </div>
                            <div class="modal-body">
                                <img src="image/salon/${salon.id}.jpg" width="450" height="200"><p></p>
                                NAME : ${salon.name}<p></p>
                               PHONE : ${salon.phone}<p></p>
                                EMAIL : ${salon.email}<p></p>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success"><a href="reservations?action=add&idc=<c:out value="${salon.id}"/>">Reserva</a></button>

                            </div>
                        </div>


                    </div>
                </div>

                    <%--</a>--%>
            </div>
        </div>
    </c:forEach>

</div>




</div>
</div>

</body>
</html>

