<%@page import="java.util.List"%>
<%@page import="residencia.modelo.daoimpl.personadaoimpl"%>
<%@page import="residencia.modelo.dao.personadao"%>
<%@page import="residencia.modelo.daoimpl.movimientodaoimpl"%>
<%@page import="residencia.modelo.dao.movimientodao"%>
<%@page import="residencia.modelo.entidad.TipoMovimiento"%>
<%@page import="residencia.modelo.entidad.Deudaporpersona"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="dni" scope="request" class="java.lang.String" />
<jsp:useBean id="action" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="idcontrato" scope="request" class="java.lang.String" />
<jsp:useBean id="inquilino" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="tipomovimiento" scope="request" class="java.util.ArrayList" />


<style type="text/css">
    body {
        background-color: #BEF781;
    }
</style>
<%
out.println(mensaje);
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <form class="form-horizontal" method="post" action="pago">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="dni" maxlength="8">
                                <input type="hidden"   name="action" value="buscar"></td>
                            <td><input type="submit" class="btn btn-info" value="Buscar"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<div class="container">
    <table align="center" class="table table-striped" >

        <%           

          if(!inquilino.equals(""))  {
            
        %>
        <thead>
            <tr>
                <td align="center" width="2%">#</td>
                <td align="center" width="15%">Apellidos</td>
                <td align="center" width="10%">Nombre</td>
                <td align="center" width="8%">Dni</td>
                <td align="center" width="9%">Celular</td>
                <td align="center"  width="18%">Fecha inicio contrato</td>
                <td align="center"  width="20%">Fecha final contrato</td>
                <td align="center"  width="10%">Habitacion</td>
                <td align="center"  width="10%">Debe</td>
                <td align="center"  width="10%">Cancelar</td>
            </tr>
        </thead>
        <tbody>
            <%
                int i=0;
                List<Deudaporpersona> lista=inquilino;
                for (Deudaporpersona u :lista) {
                    i++;
                     
            %>
            <tr>
                <td align="center" ><%=i%></td>
                <td align="center" ><%=u.getApellidos()%></td>
                <td align="center" ><%=u.getNombre()%></td>
                <td align="center" ><%=u.getDni()%></td>
                <td align="center" ><%=u.getNCelular()%></td>
                <td align="center" ><%=u.getFechainicio()%></td>
                <td align="center" ><%=u.getFechasalida()%></td>
                <td align="center" ><%=u.getNumero_habitacion()%></td>
                <td align="center" ><%=u.getDeuda()%></td>
                <td align="center" >
                <td>
                    <form method="post" action="pago">
                        <input type="submit" value="Pago" >
                        <input type="hidden" name="action" value="cancelando" >
                       <input type="hidden" name="dni1" value="<%=u.getDni()%>" >
                        <input type="hidden" name="idcontrato" value="<%=u.getIdcontrato()%>" >
                    </form>
                </td>
                
                <%}}
            %>
            </tr>
        </tbody>
    </table>

</div>
<%

    if (action.equals("cancelando")) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form name="datos"class="form-horizontal table-condensed" method="post" action="pago">

                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-md-12 ">Tipo Movimiento</label></td>
                            <td><select  class="form-control"  name="tipomovimiento">
                                    <option>Tipo Movimiento</option> 
                                    <%
                                      List<TipoMovimiento> tipo=tipomovimiento;
                                        for (TipoMovimiento h : tipo) {

                                    %>
                                    <option value="<%=h.getIdTipoMovimiento()%>"><%=h.getNombre()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Codigo baucher</label></td>
                            <td><input type="text" class="form-control" placeholder="Ingrese codigo"  name="codigo">
                        </tr>
                        <tr>
                    <input type="hidden" class="form-control"   name="idcontrato" value="<%=idcontrato%>">
                    <td><label class="col-sm-12">Monto</label></td>
                    <td><input type="text" class="form-control" placeholder="Ingrese el monto" required="" name="monto">
                        </tr>

                    <tr>
                        <td><label class="col-sm-12">Glosa</label></td>
                        <td><input type="text" class="form-control" placeholder="Concepto"  name="glosa">
                    </tr>
                    <tr>
                        <td align="center"></td>
                        <input type="hidden" name="action" value="cancelado" >
                    <input type="hidden" name="dni2" value="<%=dni%>" >
                    <td><input type="submit"  value="Guardar" >
                        </tr>
                        </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<%
    }
%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
