<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.entidad.Pais"%>
<%@page import="residencia.modelo.entidad.Mes"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.entidad.Institucion"%>
<%@page import="residencia.modelo.entidad.Ocupacion"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
  body {
  background-color:lightseagreen;
}
 </style>
    <%
        residenciadao residenciadao=new residenciadaoimpl();
        Persona persona=new Persona();
        list
        Mes m=new Mes();
        int cantidad;
        String mensaje="";

        String nombre=request.getParameter("nombre");nombre=nombre==null?"":nombre;
        String apellidos=request.getParameter("apellido");apellidos=apellidos==null?"": apellidos;
        String dni=request.getParameter("dni");dni=dni==null?"": dni;
        
        String genero=request.getParameter("genero");genero=genero==null?"": genero;
        String celular=request.getParameter("celular");celular=celular==null?"": celular;
        String fecha_nac=request.getParameter("fecha_nac");fecha_nac=fecha_nac==null?"": fecha_nac;
        String pais=request.getParameter("pais");pais=pais==null?"": pais;
        String region=request.getParameter("region");region=region==null?"": region;
        String provincia=request.getParameter("provincia");provincia=provincia==null?"": provincia;
        String distrito="51010119";
        String inicio=request.getParameter("inicio");inicio=inicio==null?"": inicio;
        String idpersona=request.getParameter("inicio");idpersona=idpersona==null?"": idpersona;
        String idusuario=request.getParameter("inicio");idusuario=idusuario==null?"": idusuario;
        String idapoderado=request.getParameter("inicio");idapoderado=idapoderado==null?"": idapoderado;
        String salida=request.getParameter("salida");salida=salida==null?"": salida;
        String num_habita=request.getParameter("habitacion");num_habita=num_habita==null?"": num_habita;
        String ocupacion=request.getParameter("ocupacion");ocupacion=ocupacion==null?"": ocupacion;
        String institucion=request.getParameter("institucion");institucion=institucion==null?"": institucion;
        String num_personas=request.getParameter("num_personas");num_personas=num_personas==null?"": num_personas;
        String precio_actual=request.getParameter("num_personas");precio_actual=precio_actual==null?"": precio_actual;
        String buscardni=request.getParameter("dnibuscar");buscardni=buscardni==null?"": buscardni;
          if(!buscardni.equals("")){
          persona=residenciadao.buscarpersona(buscardni);
          }
        
        if(!inicio.equals("")&&!salida.equals("")&&!num_habita.equals("")&&!ocupacion.equals("")&&
                !institucion.equals("")){
        if(residenciadao.contrato(num_personas, precio_actual, idpersona, inicio, salida, num_habita,
          idusuario, ocupacion, institucion, idapoderado)){
         residenciadao.meses(idpersona);
            cantidad=Integer.parseInt(m.getCantidad());
           m.getFinicio();
          // for(int i=0;i<cantidad;i++){
         //  residenciadao.insertardetallecontrato(idpago, num_habita, precioactual, finicio, number1, number2)
          // }
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
    <tr>
        <td><input type="text" class="form-control" name="dnibuscar" placeholder="Buscar por dni" >
          <td><button type="submit">Buscar</button>
    </tr>
        </tbody>
        </table>
    </form>
    <div class="col-md-3"></div>
            </div>
        </div>
    </div>
    <%
        
               
        
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
          <td><input type="text" class="form-control" name="nombre" value="<%=u.getNombre()%>">
      </tr>
      <tr>
          <td><label class="col-sm-12">Apellidos</label></td>
          <td><input type="text" class="form-control" name="apellido" value="<%=u.getApellidos()%>">
      </tr>
     <tr>
          <td><label class="col-sm-12">DNI</label></td>
          <td><input type="text" class="form-control" name="dni"<%=u.getDni()%> >
     </tr>
      <tr>
          <td><label class="col-sm-12">Celular</label></td>
          <td><input type="text" class="form-control" name="celular" value="<%=u.getNcelular()%>">
      </tr>
      <tr>  
          <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
          <td><input type="date" class="form-control" name="fecha_nac" value="<%=u.getFechanacimiento()%>">
      </tr>

      <tr>
        <td><label class="col-sm-12">Procedencia</label></td>
      <td>
          <select class="form-control" name="pais" >
                <option>Pais</option> 
                            <%
                                for (Pais p : residenciadao.listarpais()) {
                                 
                            %>
                <option  value="<%=p.getIdpais()%>"><%=p.getPais()%></option>
         
                <%}%>
          </select> 
      </td>
      <td>
          <select class="form-control" name="pais" >
                <option>Region</option> 
                            <%
                                for (Region p : residenciadao.listarregiones(pais)) {
                                
                            %>
                <option  value="<%=p.getIdregion()%>"><%=p.getRegion()%></option>
         
                <%}%>
          </select> 
      </td>
      <td>
          <select class="form-control" name="pais" >
                <option>Provincia</option> 
                            <%
                                for (Provincia p : residenciadao.listarprovincias(region)) {
                                
                            %>
                <option  value="<%=p.getIdprovincia()%>"><%=p.getProvincia()%></option>
         
                <%}%>
          </select> 
      </td>
      <td>
          <select class="form-control" name="pais" >
                <option>Distrito</option> 
                            <%
                                for (Distrito p : residenciadao.listardistritos(provincia)) {
                                
                            %>
                <option  value="<%=p.getIddistrito()%>"><%=p.getDistrito()%></option>
         
                <%}%>
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
              }
          }else{
  mensaje="No esta registrado: <a href='reg_persona.jsp'>REGISTRAR</a>"; 
          }
%>      
          
          
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 well">
               <form class="form-horizontal" action="reg_persona.jsp">
                <table class="table table-condensed">
                <tr>
                    <td><label class="col-md-12 control-label">Fecha de Inicio</label></td>
                    <td><input type="date" name="inicio" class="form-control" value=""></td>
                </tr>
                <tr>
                    <td><label class="col-md-12 control-label">Fecha de Salida</label></td>
                    <td><input type="date" name="salida" class="form-control" value=""></td>
                </tr>
                <tr>
                    <td><label class="col-md-12 control-label">Número de Habitación</label></td>
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
                    <td><label class="col-md-12 control-label">Número de Personas</label></td>
                    <td><input type="text" name="num_personas" class="form-control" value=""></td>
                </tr>
                <tr>
                    <td><label class="col-md-12 control-label">Precio actual</label></td>
                    <td><input type="text" name="precio_actual" class="form-control" value=""></td>
                </tr>
                <tr>
                    <td><label class="col-md-12 control-label">Ocupación</label></td>
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
                    <td><label class="col-md-12 control-label">Institución</label></td>
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
                    <td colspan="2" align="center"><input type="submit" class="btn btn-success" value="Enviar"></td>
                </tr>
                </table> 
               </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
<%@include file="WEB-INF/jspf/bottom.jspf"%>