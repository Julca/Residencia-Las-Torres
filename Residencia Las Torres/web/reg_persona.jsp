<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@page import="residencia.modelo.entidad.Pais"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<jsp:useBean id="region" scope="session" class="java.lang.String" />
<jsp:useBean id="dni" scope="session" class="java.lang.String" />
<jsp:useBean id="distrito" scope="session" class="java.lang.String" />
<jsp:useBean id="nombre" scope="request" class="java.lang.String" />
<jsp:useBean id="genero" scope="request" class="java.lang.String" />
<jsp:useBean id="celular" scope="request" class="java.lang.String" />
<jsp:useBean id="apellido" scope="request" class="java.lang.String" />
<jsp:useBean id="fecha_nac" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
    body {
        background-color:lightseagreen;
    }
</style>

<div align="center">
    <h1 width="50%">Registrar Inquilino</h1>
</div>

<%        residenciadao residenciadao = new residenciadaoimpl();
    String nombre = "";
    String apellidos = "";
    String celular = "";
    String fecha_nac = "";
    String idpersona = "";
    String provincia = request.getParameter("provincia");
    provincia = provincia == null ? "" : provincia;
    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? "" : opcion;
    if (!distrito.equals("") && opcion.equals("guardar")) {
        for (Persona pers : residenciadao.buscarpersonasinprocedencia(dni)) {
            idpersona = pers.getIdPersona();
            nombre = pers.getNombre();
            apellidos = pers.getApellidos();
            celular = pers.getNCelular();
            fecha_nac = pers.getFechaNacimiento();
        }

        Persona persona1 = new Persona();
        persona1.setIdPersona(idpersona);
        persona1.setNombre(nombre);
        persona1.setApellidos(apellidos);
        persona1.setDni(dni);
        persona1.setNCelular(celular);
        persona1.setFechaNacimiento(fecha_nac);
        persona1.setIdubigeo(distrito);
        if (residenciadao.actualizarpersona(persona1)) {
            response.sendRedirect("contrato.jsp?dnibuscar=" + dni);
        } else {
            response.sendRedirect("reg_persona.jsp");
        }
    }


%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="POST" action="registrando">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Nombres</label></td>
                            <td><input type="text" class="form-control" name="nombre" required="required" value="<%=nombre%>"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Apellidos</label></td>
                            <td><input type="text" class="form-control" name="apellido" required="required" value<%=apellido%>></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">DNI</label></td>
                            <td><input type="text" class="form-control" name="dni" required="required"  maxlength="8" value="<%=dni%>"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Genero</label></td>
                            <td><input type="radio" class="form-inline" name="genero" id="radio" value="F" >Femenino
                                <input type="radio" class="form-inline" name="genero" id="radio" value="M" >Maculino
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Celular</label></td>
                            <td><input type="text" class="form-control" name="celular" maxlength="9" value="<%=celular%>"></td>
                        </tr>
                        <tr> 
                            <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                            <td><input type="date" class="form-control" name="fecha_nac" required="required" value="<%=fecha_nac%>"></td>
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
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <table class="table table-condensed">
                <tbody>
                    <tr>
                        <td colspan="5" align="center"><label   class="col-sm-12">Procedencia</label></td>
                    </tr>
                    <tr>
                        <td><strong class="col-sm-12">Region</strong></td>
                        <td>
                            <form method="POST" action="registrando">  
                                <select class="form-control col-xs-12" name="region" onchange="submit()">
                                    <option>Region</option> 
                                    <%
                                    for (Region p : residenciadao.listarregiones()) {
                                    %>
                                    <option  value="<%=p.getIdregion()%>"><%=p.getRegion()%></option>
                                    <%}%>
                                </select> 

                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td><strong class="col-sm-12">Provincia</strong></td>
                        <td>
                            <form method="POST" action="reg_persona.jsp">  
                                <select class="form-control col-xs-12" name="provincia" onchange="submit()">
                                    <option>Provincia</option> 
                                    <%
                                        for (Provincia p : residenciadao.listarprovincias(region)) {

                                    %>
                                    <option  value="<%=p.getIdprovincia()%>"><%=p.getProvincia()%></option>

                                    <%}%>
                                </select> 
                            </form>
                        </td>
                    </tr>

                    <tr>
                        <td><strong class="col-sm-12">Distrito</strong></td>
                        <td>
                            <form method="POST" action="registrando"> 
                                <select class="form-control col-xs-12" name="distrito" onchange="submit()">

                                    <option>Distrito</option> 
                                    <%
                                        for (Distrito p : residenciadao.listardistritos(provincia)) {
                                    %>
                                    <option  value="<%=p.getIddistrito()%>"><%=p.getDistrito()%></option>
                                    <%}%>
                                </select> 
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form class="form-horizontal table-condensed" method="POST" action="reg_persona.jsp?opcion=guardar">
                <table class="table table-condensed">
                    <tbody>
                        <tr>

                            <td><label class="col-sm-12">Otros</label></td>
                            <td><input type="text" class="form-control" name="otros" >
                        </tr>
                        <tr> 
                            <td colspan="5" align="center">
                                <input type="submit" class="btn btn-success" name="submit"  value="Guardar">
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
