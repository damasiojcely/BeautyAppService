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
    <title>OWNER</title>
</head>
<body>

<jsp:include page="menuOwner.jsp"/>

<div class="row">

    <jsp:useBean id="service" class="pe.com.ctaf.beautyapp.services.BeautyappService"/>
        <%String ide=(String)request.getSession().getAttribute("uorganizer");%>
    <c:forEach var="stylist" items="<%=service.getStylistByClient(ide)%>">
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
                <P><button type="button" class="btn btn-default"><a href="stylists?action=edit&id=<c:out value="$stylist.id}"/>">Edit</a></button>
                        <%--<p><button type="button" class="btn btn-default" formaction="participants" formmethod="post" value="delete" name="action">
                        <input type="hidden" name="id" value="${participant.id}">
                    </button>
                     &lt;%&ndash;   <form method="post" action="participants">
                            <input type="hidden" name="id" value="${participant.id}">
                            <input type="submit"  value="delete" name="action"/>
                        </form>&ndash;%&gt;
                        </P>--%>


                        <%--  <tr><td><c:out value="${participant.id}"/></td>
                              <td><c:out value="${participant.firstName}"/></td>
                              <td><c:out value="${participant.lastName}"/></td>
                              <td><c:out value="${participant.email}"/></td>
                              <td><c:out value="${participant.position}"/></td>

                              <td><a href="participants?action=edit&id=<c:out value="${participant.id}"/>">Edit</a></td>
                              <td><form method="post" action="participants">
                                  <input type="hidden" name="id" value="${participant.id}">
                                  <input type="submit" value="delete" name="action"/>
                              </form></td>
                          </tr>--%>

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