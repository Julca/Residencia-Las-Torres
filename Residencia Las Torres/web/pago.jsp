<%@page import="residencia.modelo.entidad.TipoMovimiento"%>
<%@page import="residencia.modelo.entidad.Deudaporpersona"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
    body {
        background-color: #BEF781;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6">
            <form class="form-horizontal" method="post" action="pago.jsp">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="dni" maxlength="8"></td>
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

        <%            String mensaje;
            String dni = request.getParameter("dni");
            dni = dni == null ? "" : dni;
            String monto = request.getParameter("monto");
            monto = monto == null ? "" : monto;
            String cancelar = request.getParameter("cancelar");
            cancelar = cancelar == null ? "" : cancelar;
            String glosa = request.getParameter("glosa");
            glosa = glosa == null ? "" : glosa;
            String codigo = request.getParameter("codigo");
            codigo = codigo == null ? "" : codigo;
            String idcontrato = request.getParameter("idcontrato");
            idcontrato = idcontrato == null ? "" : idcontrato;
            String tipomovimiento = request.getParameter("tipomovimiento");
            tipomovimiento = tipomovimiento == null ? "" : tipomovimiento;
            int i = 0;
            residenciadao dao = new residenciadaoimpl();
            if (!idcontrato.equals("") && !monto.equals("")) {
                if (dao.registrarmovimiento(idcontrato, tipomovimiento, codigo, monto, glosa)) {
                    response.sendRedirect("pago.jsp?dni=" + dni);
                }
            }
            if (!dni.equals("")) {
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
                for (Deudaporpersona u : dao.listardeuda(dni)) {
                    i++;
                    idcontrato = u.getIdcontrato();
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
                <td align="center" ><a href="pago.jsp?cancelar=cancelar&&dni=<%=dni%>">monto</a></td>
                <%}
            }%>
            </tr>
        </tbody>
    </table>

</div>
<%

    if (cancelar.equals("cancelar")) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form name="datos"class="form-horizontal table-condensed" method="post" action="pago.jsp">

                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-md-12 ">Tipo Movimiento</label></td>
                            <td><select  class="form-control"  name="tipomovimiento">
                                    <option>Tipo Movimiento</option> 
                                    <%
                                        for (TipoMovimiento h : dao.listartipo_movimiento()) {

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
                    <input type="hidden"    name="dni" value="<%=dni%>">
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
