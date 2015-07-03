<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="persona" scope="request" class="residencia.modelo.entidad.Persona" />
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="post" action="actualizarpersona">
                <table class="table table-condensed">
                    <tbody>
                    <td><label class="col-sm-12">Nombres</label></td>
                    <td><input type="text" class="form-control" name="nombre" value="<%=persona.getNombre()%>"></td>
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">Apellidos</label></td>
                        <td><input type="text" class="form-control" name="apellido" value="<%=persona.getApellidos() %>" ></td>
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">DNI</label></td>
                        <td><input type="text" class="form-control" name="dni" maxlength="8" value="<%=persona.getDni() %>"></td>
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">Celular</label></td>
                    
                    <td>
                        <input type="hidden" class="form-control" name="genero"  value="<%=persona.getGenero() %>">
                    <input type="hidden" class="form-control" name="idpersona"  value="<%=persona.getIdPersona() %>">
                    <input type="hidden" class="form-control" name="idubigeo"   value="<%=persona.getIdubigeo() %>">
                        <input type="text" class="form-control" name="celular" maxlength="9" value="<%=persona.getNCelular()%>"></td>
                    </tr>
                    <tr> 
                        <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                        <td><input type="text" class="form-control" name="fecha_nac" value="<%=persona.getFechaNacimiento() %>"></td>
                    </tr>
                    <tr>
                        <td colspan="5" align="center">
                            <input type="submit" class="btn btn-success" value="Guardar">     
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
                    <%@include file="WEB-INF/jspf/bottom.jspf"%>