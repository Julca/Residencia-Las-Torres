<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.entidad.Habitacion"%>
<%@page import="residencia.modelo.entidad.Pais"%>
<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
  body {
  background-color:lightseagreen;
}
 </style>
 <div align="center">
     <h1 width="50%">Registrar Inquilino</h1>
     <div class="container"></div>

    <%
        residenciadao residenciadao=new residenciadaoimpl();
        Persona persona=new Persona();

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
        String mensaje="";
        if(!nombre.equals("")&&!apellidos.equals("")&&!dni.equals("")&&!genero.equals("")&&
                !celular.equals("")&&!fecha_nac.equals("")&&!distrito.equals("")){
             
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDni(dni);
        persona.setGenero(genero);
        persona.setNcelular(celular);
        persona.setFechanacimiento(fecha_nac);
        persona.setIdubigeo(distrito);
          out.println(nombre+" "+apellidos+" "+dni+" "+genero+" "+celular+" "+fecha_nac+" "+pais+" "+distrito);
         
        if(residenciadao.registrarpersona(persona)){            
            response.sendRedirect("reg_persona.jsp");
            mensaje="se inserto";
         
        }else{
            response.sendRedirect("reg_persona.jsp");
            mensaje="no se inserto";
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
          <td><input type="text" class="form-control" name="nombre"  >
      </tr>
      <tr>
          <td><label class="col-sm-12">Apellidos</label></td>
          <td><input type="text" class="form-control" name="apellido">
      </tr>
     <tr>
          <td><label class="col-sm-12">DNI</label></td>
          <td><input type="text" class="form-control" name="dni"  >
     </tr>
     <tr>
        <td><label class="col-sm-12">Genero</label></td>
        <td><input type="radio" class="form-inline" name="genero" id="radio" value="F">Femenino
            <input type="radio" class="form-inline" name="genero" id="radio" value="M">Maculino</td>
      </tr>
      <tr>
          <td><label class="col-sm-12">Celular</label></td>
          <td><input type="text" class="form-control" name="celular" >
      </tr>
      <tr>  
          <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
          <td><input type="date" class="form-control" name="fecha_nac" >
      </tr>
    </tbody>
        </table>
      </form>
                
                
 <form name=frmTest class="form-horizontal table-condensed" method="POST" action="reg_persona.jsp">           
   <table class="table table-condensed">
        <tbody>
      <tr>
        <td><label class="col-sm-12">Procedencia</label></td>
      <td>
                <option>Pais</option> 
                            <%
                                for (Pais p : residenciadao.listarpais()) {
                                 
                            %>
                <option  value="<%=p.getIdpais()%>"><%=p.getPais()%></option>
         
                <%}%>
          </select> 
      </td>
     
      <td>
          <select class="form-control col-xs-12" name="pais" >
                <option>Region</option> 
                            <%
                                for (Region p : residenciadao.listarregiones(pais)) {
                                
                            %>
                <option  value="<%=p.getIdregion()%>"><%=p.getRegion()%></option>
         
                <%}%>
          </select> 
      </td>
      <td>
          <select class="form-control col-xs-12" name="pais" >
                <option>Provincia</option> 
                            <%
                                for (Provincia p : residenciadao.listarprovincias(region)) {
                                
                            %>
                <option  value="<%=p.getIdprovincia()%>"><%=p.getProvincia()%></option>
         
                <%}%>
          </select> 
      </td>
      <td>
          <select class="form-control col-xs-12" name="pais" >
                <option>Distrito</option> 
                            <%
                                for (Distrito p : residenciadao.listardistritos(provincia)) {
                                
                            %>
                <option  value="<%=p.getIddistrito()%>"><%=p.getDistrito()%></option>
         
                <%}%>
          </select> 
      </td>
      </tr>
      <tr>
          <td colspan="2">
            <input type="submit" class="btn btn-success" name="submit"  value="Enviar">     
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
