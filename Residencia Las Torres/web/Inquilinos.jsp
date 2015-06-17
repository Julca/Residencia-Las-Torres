<%@page import="residencia.modelo.entidad.Mes"%>
<%@page import="java.util.Date"%>
<%@page import="residencia.modelo.entidad.Persona1"%>
<%@page import="residencia.modelo.entidad.Deudaporpersona"%>
<%@page import="residencia.modelo.entidad.Personahospedada"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
    body {
        background-color: #BEF781;
    }
</style>
<%     residenciadao dao = new residenciadaoimpl();
    String buscar = request.getParameter("buscar");
    buscar = buscar == null ? "" : buscar;
    String mes = request.getParameter("mes");
    mes = mes == null ? "" : mes;
    String nombre = request.getParameter("nombre");
    nombre = nombre == null ? "" : nombre;
    String apellido = request.getParameter("apellido");
    apellido = apellido == null ? "" : apellido;
    String dni = request.getParameter("dni");
    dni = dni == null ? "" : dni;
    String celular = request.getParameter("celular");
    celular = celular == null ? "" : celular;
    String genero = request.getParameter("genero");
    genero = genero == null ? "" : genero;
    String fecha_nac = request.getParameter("fecha_nac");
    fecha_nac = fecha_nac == null ? "" : fecha_nac;
    String idpersona = request.getParameter("idpersona");
    idpersona = idpersona == null ? "" : idpersona;
    String idubigeo = request.getParameter("idubigeo");
    idubigeo = idubigeo == null ? "" : idubigeo;
    if (buscar.equals("guardar") && !nombre.equals("") && !apellido.equals("") && !dni.equals("") && !genero.equals("") && !celular.equals("")
            && !fecha_nac.equals("") && !idpersona.equals("")) {
        Persona1 persona = new Persona1();
        persona.setApellidos(apellido);
        persona.setNombre(nombre);
        persona.setDni(dni);
        persona.setGenero(genero);
        persona.setNCelular(celular);
        persona.setFechaNacimiento(fecha_nac);
        persona.setIdPersona(idpersona);
        persona.setIdubigeo(idubigeo);
        if (dao.actualizarpersona(persona)) {
            response.sendRedirect("Inquilinos.jsp?buscar=inquilinos");
        } else {
            response.sendRedirect("Inquilinos.jsp?buscar=guardar");
        }
    }

    if (buscar.equals("inquilinos")) {
%>

<h1 align="center" >Inquilinos</h1>
<div class="container">
    <table align="center" class="table table-striped" >

        <thead>
            <tr>
                <td align="center" width="5%">#</td>
                <td align="center" width="20%">Apellidos</td>
                <td align="center" width="20%">Nombre</td>
                <td align="center" width="10%">DNI</td>
                <td align="center" width="10%">Celular</td>
                <td align="center"  width="80%">Numero de habitaci&oacute;n</td>
                <td align="center"  width="80%">Actualizar</td>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Personahospedada u : dao.listarpersonashospedadas()) {
                    i++;
            %>
            <tr>
                <td align="center" ><%=i%></td>
                <td align="center" ><%=u.getApellidos()%></td>
                <td align="center" ><%=u.getNombre()%></td>
                <td align="center" ><%=u.getDni()%></td>
                <td align="center" ><%=u.getNcelular()%></td>
                <td align="center" ><%=u.getHabitacion()%></td>
                <td align="center">
                    <form method="post" action="Inquilinos.jsp?buscar=actualizar">
                        <input name="idpersona" type="hidden" value="<%=u.getIdpersona()%>"/>
                        <input name="dni" type="hidden" value="<%=u.getDni()%>"/>
                        <input type="submit" name="Submit" value="Actualizar" />
                    </form>
                </td>
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}
    if (buscar.equals("debe")) {
%>
<h1 align="center" >La cantidaad que debe cada inquilino</h1>
<div class="container">
    <table align="center" class="table table-striped" >

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
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Deudaporpersona u : dao.deudadelinquilino()) {
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
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}

    if (buscar.equals("deudor")) {
%>
<h1 align="center" >El inquilino que mas debe</h1>
<div class="container">
    <table align="center" class="table table-striped" >

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
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Deudaporpersona u : dao.elmasdudor()) {
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
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}

    if (buscar.equals("menosdeudor")) {
%>
<h1 align="center" >El inquilino menos deudor</h1>
<div class="container">
    <table align="center" class="table table-striped" >

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
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Deudaporpersona u : dao.elmenosdeudor()) {
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
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}

    if (buscar.equals("estado")) {
%>
<h1 align="center" >Estado de cuenta</h1>
<div class="container">
    <table align="center" class="table table-striped" >

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
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Deudaporpersona u : dao.elmenosdeudor()) {
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
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}
    if (buscar.equals("actualizar")) {
        String dnibuscar = request.getParameter("dni");
        dnibuscar = dnibuscar == null ? "" : dnibuscar;
        for (Persona1 pe : dao.buscarpersonasinprocedencia(dnibuscar)) {
            nombre = pe.getNombre();
            apellido = pe.getApellidos();
            dni = pe.getDni();
            genero = pe.getGenero();
            celular = pe.getNCelular();
            fecha_nac = pe.getFechaNacimiento();
            idpersona = pe.getIdPersona();
            idubigeo = pe.getIdubigeo();
        }
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="post" action="Inquilinos.jsp?buscar=guardar">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Nombres</label></td>
                            <td><input type="text" class="form-control" name="nombre" value="<%=nombre%>"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Apellidos</label></td>
                            <td><input type="text" class="form-control" name="apellido" value="<%=apellido%>" ></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">DNI</label></td>
                            <td><input type="text" class="form-control" name="dni" maxlength="8" value="<%=dnibuscar%>"></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Celular</label></td>
                    <input type="hidden" class="form-control" name="genero"  value="<%=genero%>">
                    <input type="hidden" class="form-control" name="idpersona"  value="<%=idpersona%>">
                    <input type="hidden" class="form-control" name="idubigeo"   value="<%=idubigeo%>">
                    <td><input type="text" class="form-control" name="celular" maxlength="9" value="<%=celular%>"></td>
                    </tr>
                    <tr> 
                        <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                        <td><input type="text" class="form-control" name="fecha_nac" value="<%=fecha_nac%>"></td>
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
<%}

    if (buscar.equals("mes")) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="post" action="Inquilinos.jsp?buscar=mes">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Eliga el mes</label></td>
                            <td>
                                <select class="form-control col-xs-12" type="date" name="mes" onchange="submit()">
                                    <option>Mes</option> 

                                    <option  value="01/01/2015">Enero</option>
                                    <option  value="01/02/2015">Febrero</option>
                                    <option  value="01/03/2015">Marzo</option>
                                    <option  value="01/04/2015">Abril</option>
                                    <option  value="01/05/2015">Mayo</option>
                                    <option  value="01/06/2015">Junio</option>
                                    <option  value="01/07/2015">Julio</option>
                                    <option  value="01/08/2015">Agosto</option>
                                    <option  value="01/09/2015">Setiembre</option>
                                    <option  value="01/10/2015">Octubre</option>
                                    <option  value="01/11/2015">Noviembre</option>
                                    <option  value="01/12/2015">Diciembre</option>

                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<%
    if (!mes.equals("")) {
        String nommbremes = "";
        for (Mes m : dao.nombremes(mes)) {
            nommbremes = m.getNombre();
        }
%>
<h1 align="center" >Deuda del mes de <%=nommbremes%></h1>
<div class="container">
    <table align="center" class="table table-striped" >

        <thead>
            <tr>
                <td align="center" width="2%">#</td>
                <td align="center" width="15%">Apellidos</td>
                <td align="center" width="10%">Nombre</td>
                <td align="center" width="8%">Dni</td>
                <td align="center" width="9%">Celular</td>
                <td align="center"  width="10%">Habitacion</td>
                <td align="center"  width="10%">Debe</td>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 0;
                for (Persona1 u : dao.deudadeunmes(mes)) {
                    i++;
            %>
            <tr>
                <td align="center" ><%=i%></td>
                <td align="center" ><%=u.getApellidos()%></td>
                <td align="center" ><%=u.getNombre()%></td>
                <td align="center" ><%=u.getDni()%></td>
                <td align="center" ><%=u.getNCelular()%></td>
                <td align="center" ><%=u.getHabitacion()%></td>
                <td align="center" ><%=u.getDeuda()%></td>
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}
    }%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
