<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="menuOwner.jsp"/>


<div class="col-md-9">
    <div id="content">
        <div class="col-md-10">
            <h2> MI CAMPO</h2>

            <jsp:useBean id="service" class="pe.com.yoursoccerfield.services.YSFService"/>
            <form class="form-horizontal" action="courts" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-5">ID:</label>
                    <div class="col-sm-7">
                        <input type="text" name="id" class="form-control" placeholder="ID" value="${court.id}"
                                <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
                        />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Nombre del campo:</label>
                    <div class="col-sm-7">
                        <input type="text" name="name" value="${court.name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Capacidad:</label>
                    <div class="col-sm-7">
                        <input type="text" name="capacity" value="${court.capacity}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Direccion:</label>
                    <div class="col-sm-7">
                        <input type="text" name="address" value="${court.address}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-5">Correo Electr&oacute;nico:</label>
                    <div class="col-sm-7">
                        <input type="text" name="email" value="${court.email}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Tel&eacute;fono:</label>
                    <div class="col-sm-7">
                        <input type="text" name="phone" value="${court.phone}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Precio:</label>
                    <div class="col-sm-7">
                        <input type="text" name="price" value="${court.price}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">Foto:</label>
                    <div class="col-sm-7">
                        <input type="text" name="photo" value="${court.photo}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-5">Tipo:</label>
                    <div class="col-sm-7">
                        <input type="text" name="type"  placeholder="Sintetico(1)/Natural(2)/Loza(3)" value="${court.type}"/>
                       </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-5">Estado:</label>
                    <div class="col-sm-7">
                        <input type="text" name="state" placeholder="Libre(0)/Ocupada(1)" value="${court.state}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-5">Dueno:</label>
                    <div class="col-sm-7">
                        <input type="text" name="owner_id" value="${court.owner.id}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-5">Distrito:</label>
                    <div class="col-sm-7">
                        <input type="text" name="ubigeo_id" value="${court.ubigeo.id}">
                    </div>
                </div>
                <input type="hidden" value="${action == 'edit' ? "update" : "agregate"}" name="action"/>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <button type="submit" class="btn btn-success" value="Ingresar">${action == 'edit' ? "Actualizar" : "Grabar"}</button>

                    </div>
                </div>
            </form>
        </div>
    </div>

</div>



</div>
</div>