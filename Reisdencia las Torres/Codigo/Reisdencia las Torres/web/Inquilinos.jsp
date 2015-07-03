<%@page import="residencia.modelo.entidad.Estadodecuenta"%>
<%@page import="residencia.modelo.entidad.Deudaporpersona"%>
<%@page import="residencia.modelo.daoimpl.personadaoimpl"%>
<%@page import="residencia.modelo.dao.personadao"%>
<%@page import="java.util.List"%>
<%@page import="residencia.modelo.entidad.Mes"%>
<%@page import="java.util.Date"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.entidad.Personahospedada"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<jsp:useBean id="action" scope="request" class="java.lang.String"/>
<jsp:useBean id="action1" scope="request" class="java.lang.String"/>
<jsp:useBean id="mes" scope="request" class="java.lang.String"/>

<jsp:useBean id="personashospedadas" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="deudainquilino" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="elmasdeudor" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="menosdeudor" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="inquilino" scope="request" class="residencia.modelo.entidad.Persona" />
<jsp:useBean id="estadodecuenta" scope="request" class="java.util.ArrayList" />

<style type="text/css">
    body {
        background-color: #BEF781;
        
    }
</style>
<%    
residenciadao dao = new residenciadaoimpl();

    if (action.equals("inquilinos")) {
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
        List<Personahospedada> lista=personashospedadas ;
                int i = 0;
                for (Personahospedada u : lista) {
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
                    <form method="post" action="reportes">
                        <input name="idpersona" type="hidden" value="<%=u.getIdpersona()%>"/>
                        <input name="dni" type="hidden" value="<%=u.getDni()%>"/>
                        <input name="action" type="hidden" value="actualizar"/>
                        <input type="submit" name="Submit" value="Actualizar" />
                    </form>
                </td>
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%}
    if (action.equals("debe")) {
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
         List<Deudaporpersona> lista=deudainquilino;
                int i = 0;
                for (Deudaporpersona u : lista) {
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

    if (action.equals("deudor")) {
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
                List<Deudaporpersona> lista=elmasdeudor;
                for (Deudaporpersona u : lista) {
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

    if (action.equals("menosdeudor")) {
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
    
        List<Deudaporpersona> lista=menosdeudor;
                int i = 0;
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
                <%}%>
            </tr>
        </tbody>
    </table>
</div>
<%
    }
   
    if (action.equals("mes")) {
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
            <form  method="post" action="reportes?action=deudamensual">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Eliga el mes</label></td>
                            <td>
                                <select class="form-control col-xs-12" type="date" name="fecha" onchange="submit()">
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
            personadao pers= new personadaoimpl();
               
                for (Persona u : pers.deudadeunmes(mes)) {
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
    }
if(action.equals("estado")){

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
                                <input type="hidden"   name="action" value="mostrarestado">
                               
                              
                            <td><input type="submit" class="btn btn-info" value="Buscar"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>

<h1 align="center" ><%if(action1.equals("mostrando")){%>
    <div align="center" >Estado de Cuenta</div>
    <%="Inquilino: "+inquilino.getApellidos()%>&nbsp;<%=inquilino.getNombre()%></h1>
<div class="container">
    <table align="center" class="table table-striped" >

        <thead>
            <tr>
                <td align="center" width="2%">#</td>
                <td align="center" width="15%">Fecha</td>
                <td align="center" width="10%">Baucher</td>
                <td align="center" width="10%">Glosa</td>
                <td align="center" width="8%">Debito</td>
                <td align="center" width="9%">Credito</td>
                
            </tr>
        </thead>
        <tbody>
            <%
            String codigobaucher="";
            String glosa="";
            String debito="";
            String credito="";
            int suma1=0;
            int suma2=0;
             int i = 0;
            List<Estadodecuenta> lista=estadodecuenta;
               
                for (Estadodecuenta u : lista) {
                    i++;
                    codigobaucher=u.getBaucher();
                    glosa=u.getGlosa();
                    debito=u.getDebito();
                    credito=u.getCredito();
                    if(u.getBaucher()==null){
                    codigobaucher="";
                    }
                    if(u.getGlosa()==null){
                    glosa="";
                    }
                    if(u.getDebito()==null){
                    debito="";
                    }
                    if(u.getCredito()==null){
                    credito="";
                    }
            %>
            <tr>
                <td align="center" ><%=i%></td>
                <td align="center" ><%=u.getFecha()%></td>
                <td align="center" ><%=codigobaucher%></td>
                <td align="center" ><%=glosa%></td>
                <td align="center" ><%=debito%></td>
                <td align="center" ><%=credito%></td>
                
              
            </tr>
             <%
                suma1=suma1+Integer.parseInt(u.getDebito());
                suma2=suma2+Integer.parseInt(u.getCredito());
   
   }%>
            <tr>
                <td ></td>
                <td></td>
                <td></td>
                <td align="right">Sumas:</td>
                <td align="center"><%=suma1%></td>
                <td align="center"><%=suma2%></td>
            </tr>
           
    </table>
             <%
            int deuda=suma1-suma2;
            if(deuda>0){
            %>
        <div align="center"><%="Ud. tiene una deuda de "+deuda+" Nuevo Soles"%></div>
             <%}%>
</div>
                <%
}
}%>
<%@include file="WEB-INF/jspf/bottom.jspf"%>
