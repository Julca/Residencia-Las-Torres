<%@page import="residencia.modelo.daoimpl.personadaoimpl"%>
<%@page import="residencia.modelo.dao.personadao"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
    body {
        background-color: #BEF781;
    }
</style><jsp:useBean id="action" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="persona" scope="request" class="residencia.modelo.entidad.Persona" />
<%
out.println(mensaje);
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <form class="form-horizontal" method="post" action="reportes">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="dni" maxlength="8">
                                <input type="hidden"   name="action" value="buscando">
                            </td>
                            <td><input type="submit" class="btn btn-primary" value="Buscar"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<%
if(action.equals("buscando")){
%>
<table align="center" class="table table-striped" >
    <thead>
        <tr>
          
            <td align="center" width="20%">Apellidos</td>
            <td align="center" width="20%">Nombre</td>
            <td align="center" width="10%">Dni</td>
            <td align="center" width="10%">Celular</td>
            <td align="center"  width="80%">Fecha de nacimiento</td>
            <td align="center"  width="80%">Actualizar</td>
        </tr>
    </thead>
    <tbody>

        <tr>
           
            <td align="center" ><%=persona.getApellidos()%></td>
            <td align="center" ><%=persona.getNombre()%></td>
            <td align="center" ><%=persona.getDni()%></td>
            <td align="center" ><%=persona.getNCelular()%></td>
            <td align="center" ><%=persona.getFechaNacimiento()%></td>
            <td align="center">
                <form method="post" action="reportes">
                    <input type="hidden" name="dni" value="<%=persona.getDni()%>"/>
                    <input type="hidden" name="action" value="actualizar"/>
                    <input type="submit" name="buscar" value="Actualizar" />
                </form>
            </td>
         
        </tr>
    </tbody>
</table>
<%}%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
