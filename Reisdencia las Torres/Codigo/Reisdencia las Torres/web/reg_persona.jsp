<%@page import="residencia.modelo.daoimpl.procedenciadaoimpl"%>
<%@page import="residencia.modelo.dao.procedenciadao"%>
<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<jsp:useBean id="region" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="provincia" scope="request" class="java.lang.String" />
<jsp:useBean id="distrito" scope="request" class="java.lang.String" />
<jsp:useBean id="opcion" scope="request" class="java.lang.String" />
<jsp:useBean id="dni" scope="request" class="java.lang.String" />
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
    body {
        background-color:lightseagreen;
    }
</style>
<% 
    procedenciadao procedenciadao=new procedenciadaoimpl();
    if(opcion.equals("procedencia"))
    
    {    
    %>
         <%
        if(!mensaje.equals("")){
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-3 col-md-4"></div>
                <div class="col-xs-12 col-sm-6 col-md-4 mensaje" align="center"><label><%=mensaje%></label>
                </div>
                <div class="col-xs-12 col-sm-3 col-md-4"></div>
            </div>
        </div>
<%}%>
<div align="center">
    <h1 width="50%">Procedencia</h1>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <table class="taSble table-condensed">
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
                                    for (Region p : procedenciadao.listarregiones()) {
                                    %>
                                    <option  value="<%=p.getIdregion()%>"><%=p.getRegion()%></option>
                                    <%}%>
                                </select> 
                                    <input type="hidden" name="dni1" value="<%=dni%>">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td><strong class="col-sm-12">Provincia</strong></td>
                        <td>
                            <form method="POST" action="registrando"> 
                               
                                <select class="form-control col-xs-12" name="provincia" onchange="submit()">
                                    <option>Provincia</option> 
                                    <%
                                        for (Provincia p : procedenciadao.listarprovincias(region)) {

                                    %>
                                    <option  value="<%=p.getIdprovincia()%>"><%=p.getProvincia()%></option>

                                    <%}%>
                                </select> 
                                 <input type="hidden" name="region1" value="<%=region%>">
                                 <input type="hidden" name="dni2" value="<%=dni%>">
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
                                        for (Distrito p : procedenciadao.listardistritos(provincia)) {
                                    %>
                                    <option  value="<%=p.getIddistrito()%>"><%=p.getDistrito()%></option>
                                    <%}%>
                                </select> 
                                <input type="hidden" name="region2" value="<%=region%>">
                                <input type="hidden" name="provincia1" value="<%=provincia%>">
                                <input type="hidden" name="dni3" value="<%=dni%>">
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
            <form class="form-horizontal table-condensed" method="POST" action="registrando">
                <table class="table table-condensed">
                    <tbody>
                        <tr>

                            <td><label class="col-sm-12">Otros</label></td>
                            <td><input type="text" class="form-control" name="otros" >
                                <input type="hidden" name="distrito1" value="<%=distrito%>">
                                <input type="hidden" name="guardar" value="guardar">
                                <input type="hidden" name="dni4" value="<%=dni%>">
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
<%}else {%>
<div align="center">
    <h1 width="50%">Registrar Inquilino</h1>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="POST" action="registrando">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Nombres</label></td>
                            <td><input type="text" class="form-control" name="nombre" required="required" >
                                <input type="hidden"  name="opcion" value="datos"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Apellidos</label></td>
                            <td><input type="text" class="form-control" name="apellido" required="required" ></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">DNI</label></td>
                            <td><input type="text" class="form-control" name="dni" required="required"  maxlength="8" ></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Genero</label></td>
                            <td><input type="radio" class="form-inline" name="genero" id="radio" value="F" >Femenino
                                <input type="radio" class="form-inline" name="genero" id="radio" value="M" >Maculino
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Celular</label></td>
                            <td><input type="text" class="form-control" name="celular" maxlength="9"></td>
                        </tr>
                        <tr> 
                            <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                            <td><input type="date" class="form-control" name="fecha_nac" required="required"></td>
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
<%}%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
