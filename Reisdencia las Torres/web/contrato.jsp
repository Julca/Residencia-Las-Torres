<%@page import="residencia.modelo.entidad.Habitaciondisponible"%>
<%@page import="residencia.modelo.daoimpl.ocupaciondaoimpl"%>
<%@page import="residencia.modelo.dao.ocupaciondao"%>
<%@page import="residencia.modelo.daoimpl.instituciondaoimpl"%>
<%@page import="residencia.modelo.dao.instituciondao"%>
<%@page import="residencia.modelo.daoimpl.habitaciondaoimpl"%>
<%@page import="residencia.modelo.dao.habitaciondao"%>
<%@page import="residencia.modelo.entidad.Institucion"%>
<%@page import="residencia.modelo.entidad.Ocupacion"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="dnibuscar" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje1" scope="request" class="java.lang.String" />
<jsp:useBean id="opcion1" scope="request" class="java.lang.String" />
<jsp:useBean id="opcion2" scope="request" class="java.lang.String" />
<jsp:useBean id="persona" scope="request" class="residencia.modelo.entidad.Persona"/>
<jsp:useBean id="apoderado" scope="request" class="residencia.modelo.entidad.Persona"/>
<style type="text/css">
    body {
        background-color:lightseagreen;
    }
</style>
<%    habitaciondao habitaciondao = new habitaciondaoimpl();
    instituciondao instituciondao = new instituciondaoimpl();
    ocupaciondao ocupaciondao = new ocupaciondaoimpl();
%>
<%
    if (!mensaje1.equals("")) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-4"></div>
        <div class="col-xs-12 col-sm-6 col-md-4 mensaje" align="center"><label><%=mensaje1%></label>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-4"></div>
    </div>
</div>
<%}%>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form class="form-horizontal table-condensed" method="POST" action="contrato">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="dnibuscar" maxlength="8" placeholder="Buscar por dni" >
                            <td><button type="submit">Buscar</button>
                        </tr>
                    </tbody>
                </table>
            </form>
            <div class="col-md-3"></div>
        </div>
    </div>
</div>
<%
    if (opcion1.equals("buscarinquilino")) {
        if (persona.getNombre() == null && persona.getApellidos() == null && persona.getDni() == null) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <table class="table table-condensed">
                <tbody>
                    <tr>
                        <td><label class="col-sm-12">No se encuentra registrado:</label></td>
                        <td> <a class="form-control" href='reg_persona.jsp'>REGISTRAR</a></td>
                    </tr>
                </tbody>
            </table>   
            <div class="col-md-3"></div>
        </div>
    </div>
</div>
<%
} else {

%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <table class="table table-condensed">
                <tbody>
                    <tr>
                        <td><label class="col-sm-12">Nombres</label></td>
                        <td><input type="text" class="form-control" placeholder="Nombres" required="" name="nombre" value="<%=persona.getNombre()%>">
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">Apellidos</label></td>
                        <td><input type="text" class="form-control" name="apellido"  required="" value="<%=persona.getApellidos()%>">
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">DNI</label></td>
                        <td><input type="text" class="form-control" name="dni"  required="" value="<%=persona.getDni()%>" >
                    </tr>
                    <tr>
                        <td><label class="col-sm-12">Celular</label></td>
                        <td><input type="text" class="form-control" name="celular"  required="" value="<%=persona.getNCelular()%>">
                    </tr>
                    <tr>  
                        <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                        <td><input type="text" class="form-control" name="fecha_nac"  required=""  value="<%=persona.getFechaNacimiento()%>">
                    </tr>

                    <tr>
                        <td><label class="col-sm-12">Procedencia:</label></td>
                        <td><label class="col-sm-12">Distrito</label></td>
                        <td><input type="text" class="form-control" name="distrito" value="<%=persona.getDistrito()%>">
                        <td><label class="col-sm-12">Provincia</label></td>
                        <td><input type="text" class="form-control" name="provincia" value="<%=persona.getProvincia()%>">
                    </tr>
                    <tr>
                        <td><label class="col-sm-12"> </label></td>
                        <td><label class="col-sm-12">Region </label></td>
                        <td><input type="text" class="form-control" name="region" value="<%=persona.getRegion()%>">
                        <td><label class="col-sm-12">Otros</label></td>
                        <td><input type="text" class="form-control" name="pais" value="">
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<%
        }
    }
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form class="form-horizontal table-condensed" method="post" action="contrato">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td>

                                <input type="hidden" class="form-control" name="dnibuscar1" value="<%=persona.getDni()%>" >
                                <input type="text" class="form-control" name="buscardniapo" placeholder="Buscar por dni al apoderado" value="" >
                            <td><button type="submit">Buscar</button>
                        </tr>

                        <%
                            if (opcion2.equals("buscarapoderado")) {
                                if (mensaje.equals("apoderadonoencontrado")) {
                        %>
                        <tr>
                            <td><label class="col-sm-12">No se encuentra registrado el apoderado:</label></td>
                        </tr>
                        <%} else {%>
                        <tr>
                    
                    <td>
                        <input type="hidden" class="form-control" name="idapoderado" value="<%=apoderado.getIdPersona()%>" >
                        <label class="col-sm-12"><%=apoderado.getNombre()%></label></td>
                    <td><label class="col-sm-12"><%=apoderado.getApellidos()%></label></td>
                    <td><label class="col-sm-12"><%=apoderado.getDni()%></label></td>
                    </tr>
                    <%}
                        }%>
                    </tbody>
                </table>
            </form>
            <form class="form-horizontal table-condensed" method="POST" action="registroapoderado">       
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                    

                    <td colspan="2" align="center">
                        <input type="hidden" class="form-control" name="dnipersona" value="<%=persona.getDni()%>">
                    <input type="hidden" class="form-control" name="action" value="registraapoderado">
                        <input type="submit" class="btn btn-success" value="REGISTRAR APODERADO"></td>               
                    </tr>
                    </tbody>
                </table>
            </form>
            <div class="col-md-3"></div>
        </div>
    </div>
</div> 


<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 well">
            <form class="form-horizontal" method="POST" action="contrato">
                <input type="hidden" name="idpersona" class="form-control" value="<%=persona.getIdPersona()%>">
                <input type="hidden" name="idapoderado" class="form-control" value="<%=apoderado.getIdPersona()%>">
                <input type="hidden" name="idusuario" class="form-control" value="<%=idusuario%>">
                <table class="table table-condensed">
                    <tbody>

                        <tr>
                            <td><label class="col-md-12 ">Fecha de Inicio</label></td>
                            <td><input type="date" name="inicio" class="form-control"> </td>
                        </tr>
                        <tr>
                            <td><label class="col-md-12 ">Fecha de Salida</label></td>
                            <td><input type="date" name="salida" class="form-control" ></td>
                        </tr>
                        <tr>
                            <td><label class="col-md-12 ">Número de Habitación</label></td>
                            <td><select  class="form-control"  name="habitacion">
                                    <option>N° Habitación</option> 
                                    <%
                                        for (Habitaciondisponible h : habitaciondao.listarhabitacionesdisponibles()) {
                                    %>
                                    <option value="<%=h.getIdhabitacion()%>"><%=h.getHabitacion()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-md-12 ">Precio actual</label></td>
                            <td><input type="text" name="precio_actual" class="form-control" ></td>
                        </tr>
                        <tr>
                            <td><label class="col-md-12 ">Ocupación</label></td>
                            <td>
                                <select  class="form-control"  name="ocupacion"><option>Ocupación</option> 
                                    <%
                                        for (Ocupacion h : ocupaciondao.listarocupacion()) {

                                    %>
                                    <option   value="<%=h.getIdOcupacion()%>"><%=h.getNombre()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-md-12">Institución</label></td>
                            <td>
                                <select  class="form-control"  name="institucion"><option>Intitución</option> 
                                    <%
                                        for (Institucion h : instituciondao.listarinstitucion()) {

                                    %>
                                    <option   value="<%=h.getIdInstitucion()%>"><%=h.getNombre()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" class="btn btn-success" value="Guardar"></td>
                        </tr>
                    </tbody>
                </table> 
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<%@include file="WEB-INF/jspf/bottom.jspf"%>