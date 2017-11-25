<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="menuOwner.jsp"/>

<h2> AGREGAR SERVICIOS</h2>
<jsp:useBean id="servic" class="pe.com.ctaf.beautyapp.models.BeautyappService"/>
<form class="form-horizontal" action="services" method="post">
    <div class="form-group">
        <label class="control-label col-sm-5">ID:</label>
        <div class="col-sm-7">
            <input type="text" name="id" class="form-control" placeholder="ID" value="${service.id}"
                    <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
            />
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-5">Nombre de Servicio:</label>
        <div class="col-sm-7">
            <input type="text" name="name" value="${service.name}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-5">Precio:</label>
        <div class="col-sm-7">
            <input type="text" name="price" value="${service.price}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-5">Id Salon:</label>
        <div class="col-sm-7">
            <input type="text" name="salon_id" value="${service.salon.id}"/>
        </div>
    </div>

    <div class="col-sm-5">
        <input type="hidden" value="${action == 'edit' ? "update" : "agregate"}" name="action"/>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-8">
            <button type="submit" class="btn btn-success" value="Ingresar">${action == 'edit' ? "Actualizar" : "Grabar"}</button>


        </div>
    </div>
</form>


</div>
</div>