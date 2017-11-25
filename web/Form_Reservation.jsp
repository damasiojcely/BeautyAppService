<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="menuOwner.jsp"/>


<jsp:useBean id="service" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<form action="reservations" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-4" > ID : </label>
        <div class="col-sm-8">
            <input type="text" name="id" value="${reservation.id}"

                    <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
            />
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > FECHA DE CREATE </label>
        <div class="col-sm-8">
            <input type="text" name="reserdate" value="${reservation.reserdate}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > RESERVATION TIME : </label>
        <div class="col-sm-8">
            <input type="text" name="resertime" value="${reservation.resertime}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > TOTAL : </label>
        <div class="col-sm-8">
            <input type="text" name="price" value="${court.price}" <c:out value="${'readonly=\"readonly\"'}"/>/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > ID CLIENT: </label>
        <div class="col-sm-8">
            <input type="text" name="client_id" value="${client.id}" <c:out value="${'readonly=\"readonly\"'}"/>/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-4" > ID SALON: </label>
        <div class="col-sm-8">
            <input type="text" name="salon_id" value="${salon.id}" <c:out value="${'readonly=\"readonly\"'}"/>/>
        </div>
    </div>

    <input type="hidden" value="${action == 'edit' ? "update" : "agregate"}" name="action"/>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-8">

            <button type="submit" class="btn btn-success" value="Ingresar">${action == 'edit' ? "Actualizar" : "Grabar"}</button>


        </div>
    </div>
</form>





</div>
</div>


