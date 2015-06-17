<%@page import="java.util.List"%>
<%@page import="residencia.modelo.entidad.Persona1"%>
<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.entidad.Pais"%>
<%@page import="residencia.modelo.entidad.Mes"%>
<%@page import="residencia.modelo.entidad.Institucion"%>
<%@page import="residencia.modelo.entidad.Ocupacion"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="dni" scope="session" class="java.lang.String" />
<style type="text/css">
    body {
        background-color:lightseagreen;
    }
</style>
<%  residenciadao residenciadao = new residenciadaoimpl();
    Persona1 persona = new Persona1();
    Mes m = new Mes();
    int cantidad;
    String mensaje = "No se encuentra registrado(a): <a href='reg_persona.jsp'>Registrar</a>  ";
    String nombreapoderado = request.getParameter("nombreapoderado");
    nombreapoderado = nombreapoderado == null ? "" : nombreapoderado;
    String nombre = request.getParameter("nombre");
    nombre = nombre == null ? "" : nombre;
    String apellidos = request.getParameter("apellido");
    apellidos = apellidos == null ? "" : apellidos;
    String apellidoapoderado = request.getParameter("apellidoapoderado");
    apellidoapoderado = apellidoapoderado == null ? "" : apellidoapoderado;
    String genero = request.getParameter("genero");
    genero = genero == null ? "" : genero;
    String celular = request.getParameter("celular");
    celular = celular == null ? "" : celular;
    String fecha_nac = request.getParameter("fecha_nac");
    fecha_nac = fecha_nac == null ? "" : fecha_nac;
    String pais = request.getParameter("pais");
    pais = pais == null ? "" : pais;
    String region = request.getParameter("region");
    region = region == null ? "" : region;
    String provincia = request.getParameter("provincia");
    provincia = provincia == null ? "" : provincia;
    String distrito = request.getParameter("distrito");
    distrito = distrito == null ? "" : distrito;
    String distritoa = request.getParameter("distritoa");
    distritoa = distritoa == null ? "" : distritoa;
    String dnia = request.getParameter("dnia");
    dnia = dnia == null ? "" : dnia;
    String inicio = request.getParameter("inicio");
    inicio = inicio == null ? "" : inicio;
    String idpersona = request.getParameter("idpersona");
    idpersona = idpersona == null ? "" : idpersona;
    String salida = request.getParameter("salida");
    salida = salida == null ? "" : salida;
    String num_habita = request.getParameter("habitacion");
    num_habita = num_habita == null ? "" : num_habita;
    String ocupacion = request.getParameter("ocupacion");
    ocupacion = ocupacion == null ? "" : ocupacion;
    String institucion = request.getParameter("institucion");
    institucion = institucion == null ? "" : institucion;
    String precio_actual = request.getParameter("precio_actual");
    precio_actual = precio_actual == null ? "" : precio_actual;
    String buscardni = request.getParameter("dnibuscar");
    buscardni = buscardni == null ? "" : buscardni;
    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? "" : opcion;
    String mensaje1 = request.getParameter("mensaje1");
    mensaje = mensaje == null ? "" : mensaje;
    String buscar = request.getParameter("buscar");
    buscar = buscar == null ? "" : buscar;
    String buscardniapo = request.getParameter("buscardniapo");
    buscardniapo = buscardniapo == null ? "" : buscardniapo;
    String buscarapo = request.getParameter("buscarapo");
    buscarapo = buscarapo == null ? "" : buscarapo;
    String idapoderado = request.getParameter("idapoderado");
    idapoderado = idapoderado == null ? "" : idapoderado;
    if (!distritoa.equals("") && opcion.equals("guardar")) {
        for (Persona1 pers : residenciadao.buscarpersonasinprocedencia(dnia)) {
            idapoderado = pers.getIdPersona();
            nombre = pers.getNombre();
            apellidos = pers.getApellidos();
            celular = pers.getNCelular();
            fecha_nac = pers.getFechaNacimiento();
        }
        Persona1 persona1 = new Persona1();
        persona1.setIdPersona(idapoderado);
        persona1.setNombre(nombre);
        persona1.setApellidos(apellidos);
        persona1.setDni(dnia);
        persona1.setNCelular(celular);
        persona1.setFechaNacimiento(fecha_nac);
        persona1.setIdubigeo(distritoa);
        if (residenciadao.actualizarpersona(persona1)) {
        } else {
        }
    }
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form name="datos"class="form-horizontal table-condensed" method="post" action="contrato.jsp">
                <table class="table table-condensed">
                    <tbody>
                        <tr><input type="hidden" class="form-control" name="buscar" value="buscar" >
                    <td><input type="text" class="form-control" name="dnibuscar" maxlength="8" placeholder="Buscar por dni" >
                    <td><button type="submit">Buscar</button>
                        </tr>
                        </tbody>
                </table>
            </form>
            <div class="col-md-3"></div>
        </div>
    </div>
</div><%
    if (!buscardni.equals("")) {
        for (Persona1 u : residenciadao.buscarpersona(buscardni)) {
            List<Persona1> lista = residenciadao.buscarpersona(buscardni);
            nombre = u.getNombre();
            apellidos = u.getApellidos();
            dni = u.getDni();
            celular = u.getNCelular();
            fecha_nac = u.getFechaNacimiento();
            distrito = u.getDistrito();
            provincia = u.getProvincia();
            region = u.getRegion();
            pais = u.getPais();
            idpersona = u.getIdPersona();
        }
        for (Persona1 u : residenciadao.buscarpersonasinprocedencia(buscardni)) {
            nombre = u.getNombre();
            apellidos = u.getApellidos();
            dni = u.getDni();
            celular = u.getNCelular();
            fecha_nac = u.getFechaNacimiento();
            idpersona = u.getIdPersona();
        }
        if (nombre.equals("") && apellidos.equals("") && dni.equals("") && celular.equals("")
                && fecha_nac.equals("") && distrito.equals("") && provincia.equals("") && region.equals("")
                && pais.equals("") && idpersona.equals("") && buscar.equals("buscar")) {
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
        }
    }

    if (opcion.equals("contrato")) {
        if (residenciadao.contrato(precio_actual, idpersona, inicio, salida, num_habita,
                idusuario, ocupacion, institucion, idapoderado)) {
            response.sendRedirect("contratado");
        } else {
            mensaje = " no se pudo registrar el contrato";
        }
    }


%>


<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form name="datos"class="form-horizontal table-condensed" method="post" action="reg_persona.jsp">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Nombres</label></td>
                            <td><input type="text" class="form-control" placeholder="Nombres" required="" name="nombre" value="<%=nombre%>">
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Apellidos</label></td>
                            <td><input type="text" class="form-control" name="apellido"  required=" " value="<%=apellidos%>">
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">DNI</label></td>
                            <td><input type="text" class="form-control" name="dni"  required="" value="<%=dni%>" >
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Celular</label></td>
                            <td><input type="text" class="form-control" name="celular"  required="" value="<%=celular%>">
                        </tr>
                        <tr>  
                            <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
                            <td><input type="text" class="form-control" name="fecha_nac"  required=""  value="<%=fecha_nac%>">
                        </tr>

                        <tr>
                            <td><label class="col-sm-12">Procedencia:</label></td>
                            <td><label class="col-sm-12">Distrito</label></td>
                            <td><input type="text" class="form-control" name="distrito" value="<%=distrito%>">
                            <td><label class="col-sm-12">Provincia</label></td>
                            <td><input type="text" class="form-control" name="provincia" value="<%=provincia%>">
                        </tr>
                        <tr>
                            <td><label class="col-sm-12"> </label></td>
                            <td><label class="col-sm-12">Region </label></td>
                            <td><input type="text" class="form-control" name="region" value="<%=region%>">
                            <td><label class="col-sm-12">Pais</label></td>
                            <td><input type="text" class="form-control" name="pais" value="<%=pais%>">
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
            <form class="form-horizontal table-condensed" method="post" action="contrato.jsp">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td>
                                <input type="hidden" class="form-control" name="buscarapo" value="buscarapo" >
                                <input type="hidden" class="form-control" name="dnibuscar" value="<%=buscardni%>" >
                                <input type="text" class="form-control" name="buscardniapo" placeholder="Buscar por dni al apoderado" value="" >
                            <td><button type="submit">Buscar</button>
                        </tr>
                        <%
                            if (!buscardniapo.equals("")) {
                                for (Persona1 u : residenciadao.buscarpersona(buscardniapo)) {
                                    idapoderado = u.getIdPersona();
                                    nombreapoderado = u.getNombre();
                                    apellidoapoderado = u.getApellidos();
                                    dnia = u.getDni();
                                }
                                if (!idapoderado.equals("") && buscarapo.equals("buscarapo")) {
                        %>
                        <tr>
                    <input type="hidden" class="form-control" name="idapoderado" value="<%=idapoderado%>" >
                    <td><label class="col-sm-12"><%=nombreapoderado%></label></td>
                    <td><label class="col-sm-12"><%=apellidoapoderado%></label></td>
                    <td><label class="col-sm-12"><%=dnia%></label></td>
                    </tr>
                    <%
                        }
                        if (idapoderado.equals("") && buscarapo.equals("buscarapo")) {
                    %>
                    <tr>
                        <td><label class="col-sm-12">No se encuentra registrado el apoderado:</label></td>
                    </tr>
                    <%
                            }
                        }
                    %>

                    </tbody>
                </table>
            </form>
            <form class="form-horizontal table-condensed" method="POST" action="registroapoderado">       
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                    <input type="hidden" class="form-control" name="dni" value="<%=dni%>" >
                    <td colspan="2" align="center"><input type="submit" class="btn btn-success" value="REGISTRAR APODERADO"></td>               
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
            <form class="form-horizontal" action="contrato.jsp" method="post" >
                <input type="hidden" name="idpersona" class="form-control" value="<%=idpersona%>">
                <input type="hidden" name="idapoderado" class="form-control" value="<%=idapoderado%>">
                <input type="hidden" name="opcion" class="form-control" value="contrato">
                <input type="hidden" name="opcion" class="form-control" value="<%=opcion%>"> 
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
                                        for (Habitacion h : residenciadao.listarhabitacion()) {

                                    %>
                                    <option value="<%=h.getIdHabitacion()%>"><%=h.getNumeroCuarto()%></option>
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
                                        for (Ocupacion h : residenciadao.listarocupacion()) {

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
                                        for (Institucion h : residenciadao.listarinstitucion()) {

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
<%

%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>