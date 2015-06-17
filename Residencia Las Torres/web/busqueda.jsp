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
            <form class="form-horizontal" method="post" action="busqueda.jsp">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="dni" maxlength="8"></td>
                            <td><input type="submit" class="btn btn-primary" value="Buscar"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>

<table align="center" class="table table-striped" >
    <%            String mensaje;
        residenciadao dao = new residenciadaoimpl();
        String dni = request.getParameter("dni");
        dni = dni == null ? "" : dni;
        String buscar = request.getParameter("buscar");
        buscar = buscar == null ? "" : buscar;
        int i = 0;
        String mes = request.getParameter("mes");
        mes = mes == null ? "" : mes;
        String nombre = request.getParameter("nombre");
        nombre = nombre == null ? "" : nombre;
        String apellido = request.getParameter("apellido");
        apellido = apellido == null ? "" : apellido;
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
            Persona persona = new Persona();
            persona.setApellidos(apellido);
            persona.setNombre(nombre);
            persona.setDni(dni);
            persona.setGenero(genero);
            persona.setNCelular(celular);
            persona.setFechaNacimiento(fecha_nac);
            persona.setIdPersona(idpersona);
            persona.setIdubigeo(idubigeo);
            if (dao.actualizarpersona(persona)) {
            } else {
            }
        }

        if (!dni.equals("")) {
            for (Persona u : dao.buscarpersona(dni)) {
                i++;

    %>
    <thead>
        <tr>
            <td align="center" width="5%">#</td>
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
            <td align="center" ><%=i%></td>
            <td align="center" ><%=u.getApellidos()%></td>
            <td align="center" ><%=u.getNombre()%></td>
            <td align="center" ><%=u.getDni()%></td>
            <td align="center" ><%=u.getNCelular()%></td>
            <td align="center" ><%=u.getFechaNacimiento()%></td>
            <td align="center">
                <form method="post" action="busqueda.jsp">
                    <input name="idpersona" type="hidden" value="<%=u.getIdPersona()%>"/>
                    <input type="hidden" name="dni" value="<%=u.getDni()%>"/>
                    <input type="submit" name="buscar" value="Actualizar" />
                </form>
            </td>
            <%}
                            }%>
        </tr>
    </tbody>
</table>
<%
    if (buscar.equals("Actualizar")) {
        String dnibuscar = request.getParameter("dni");
        dnibuscar = dnibuscar == null ? "" : dnibuscar;
        for (Persona pe : dao.buscarpersonasinprocedencia(dnibuscar)) {
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
            <form  method="post" action="busqueda.jsp">
                <table class="table table-condensed">
                    <tbody>
                    <input type="hidden" class="form-control" name="buscar" value="guardar">
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
<%}%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
