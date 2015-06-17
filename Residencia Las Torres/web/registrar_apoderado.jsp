<%@page import="residencia.modelo.entidad.Persona1"%>
<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@page import="residencia.modelo.entidad.Pais"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="regiona" scope="session" class="java.lang.String" />
<jsp:useBean id="dnia" scope="session" class="java.lang.String" />
<jsp:useBean id="distritoa" scope="session" class="java.lang.String" />
<jsp:useBean id="idapoderado" scope="session" class="java.lang.String" />
<jsp:useBean id="dni" scope="session" class="java.lang.String" />
<style type="text/css">
    body {
        background-color:lightseagreen;
    }
</style>
<div align="center">
    <h1 width="50%">Registrar Apoderado</h1>
    <div class="container"></div>
</div>
<%        residenciadao residenciadao = new residenciadaoimpl();

    String provincia = request.getParameter("provinciaa");
    provincia = provincia == null ? "" : provincia;
    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? "" : opcion;


%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="POST" action="registroapoderado">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Nombres</label></td>
                            <td><input type="text" class="form-control" name="nombrea" required="required"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Apellidos</label></td>
                            <td><input type="text" class="form-control" name="apellidoa" required="required"  ></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">DNI</label></td>
                            <td><input type="text" class="form-control" name="dnia" required="required"  maxlength="8"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Genero</label></td>
                            <td><input type="radio" class="form-inline" name="generoa" id="radio" value="F" >Femenino
                                <input type="radio" class="form-inline" name="generoa" id="radio" value="M" >Maculino
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Celular</label></td>
                            <td><input type="text" class="form-control" name="celulara" maxlength="9" ></td>
                        </tr>
                        <tr> 
                            <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                            <td><input type="date" class="form-control" name="fecha_naca" required="required"></td>
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
                            <form method="POST" action="registroapoderado">  
                                <select class="form-control col-xs-12" name="regiona" onchange="submit()">
                                    <option>Region</option> 

                                    <%                                for (Region p : residenciadao.listarregiones()) {

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
                            <form method="POST" action="registrar_apoderado.jsp">  
                                <select class="form-control col-xs-12" name="provinciaa" onchange="submit()">
                                    <option>Provincia</option> 
                                    <%
                                        for (Provincia p : residenciadao.listarprovincias(regiona)) {

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
                            <form method="POST" action="registroapoderado"> 
                                <select class="form-control col-xs-12" name="distritoa" onchange="submit()">

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
            <form class="form-horizontal table-condensed" method="POST" action="contrato.jsp?">
                <table class="table table-condensed">
                    <tbody>
                        <tr>

                            <td><label class="col-sm-12">Otros</label></td>
                            <td><input type="text" class="form-control" name="otros" >
                                <input type="hidden" class="form-control" name="dnia" value="<%=dnia%>">
                                <input type="hidden" class="form-control" name="dnibuscar" value="<%=dni%>">
                                <input type="hidden" class="form-control" name="opcion" value="guardar">
                                <input type="hidden" class="form-control" name="distritoa" value="<%=distritoa%>">

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
