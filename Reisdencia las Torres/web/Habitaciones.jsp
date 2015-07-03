<%@page import="java.util.List"%>
<%@page import="residencia.modelo.daoimpl.habitaciondaoimpl"%>
<%@page import="residencia.modelo.dao.habitaciondao"%>
<%@page import="residencia.modelo.entidad.Habitaciondisponible"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
 <style type="text/css">
  body {
  background-color: #BEF781;
}
 </style><jsp:useBean id="persona" scope="request" class="java.util.ArrayList" />
 <jsp:useBean id="habitaciones" scope="request" class="java.util.ArrayList" />
  <jsp:useBean id="habitacion" scope="request" class="java.lang.String" />
 <jsp:useBean id="action" scope="request" class="java.lang.String" />
 <%
 if(action.equals("habitacion")){
 %>
 <div align="center">
   
     <div class="container">
         
<table class="table table-striped" >
    <thead>
          <tr align="center" >Habitaciones
        </tr>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="20%">Piso</td>
                  <td align="center" width="20%">Numero de habitaci&oacute;n</td>
                  <td align="center" width="20%">Cantidad de Inquilinos</td>
                  
                </tr>
              </thead>
              <tbody>
          <%
              String mensaje="";
              int i=0;
         List<Habitaciondisponible> lista=habitaciones;
          for (Habitaciondisponible u :lista) {
              i++; 
              if(u.getPiso().equals("1")){
                  mensaje="Primer piso";
              }
              if(u.getPiso().equals("2")){
                  mensaje="Segundo piso";
              }
              if(u.getPiso().equals("3")){
                  mensaje="Tercer piso";
              }
              if(u.getPiso().equals("4")){
                  mensaje="Cuarto piso";
              }
              if(Integer.parseInt(u.getNumeropersonas())!=0){
          %>
          <tr>
        <td align="center"><%=i%></td>
        <td align="center"><%=mensaje%></td>
        <td align="center"><%=u.getHabitacion()%></td>
        <td align="center"><%=u.getNumeropersonas()%>
            <form method="post" action="habitacion">
                <input type="submit" value="ver" >
                <input type="hidden" name="idhabitacion" value="<%=u.getIdhabitacion()%>" >
                <input type="hidden" name="habitacion" value="<%=u.getHabitacion()%>" >
                <input type="hidden" name="action" value="inquilino" >
            </form></td>
        <%}}%>
      </tr>
</tbody>
 
  </table>
 
      <%}
      if(action.equals("listar")){
      %>
      <table class="table table-striped" >
        <thead>
               <div align="center">
                  Habitacion <%=habitacion%> 
                </div>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="20%">Apellidos</td>
                   <td align="center" width="20%">Nombre</td>
                    <td align="center" width="20%">DNI</td>
                     <td align="center" width="20%">Celular</td>
                  
                </tr>
              </thead>
              <tbody>
          <%
         
              int i=0;
         List<Habitaciondisponible> lista=persona;
          for (Habitaciondisponible u :lista) {
              i++; 
            %>
          <tr>
        <td align="center"><%=i%></td>
        <td align="center"><%=u.getApellidos()%></td>
        <td align="center"><%=u.getNombre()%></td>
        <td align="center"><%=u.getDni()%></td>
        <td align="center"><%=u.getNCelular()%></td>
        <%}%>
      </tr>
</tbody>
 
  </table>
      <%}
      if(action.equals("habitaciondis")){
      %>
      <table class="table table-striped" >

         <thead>
             <div align="center" >
                 Habitaciones Disponibles  
                  
                </div>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="20%">Piso</td>
                  <td align="center" width="20%">Numero de habitaci&oacute;n</td>
                  
                  
                </tr>
              </thead>
              <tbody>
          <%
              String mensaje="";
              String dato="";
              int i=0;
         List<Habitaciondisponible> lista=habitaciones;
          for (Habitaciondisponible u :lista) {
              i++; 
              if(u.getPiso().equals("1")){
                  mensaje="Primer piso";
              }
              if(u.getPiso().equals("2")){
                  mensaje="Segundo piso";
              }
              if(u.getPiso().equals("3")){
                  mensaje="Tercer piso";
              }
              if(u.getPiso().equals("4")){
                  mensaje="Cuarto piso";
              }
              if(Integer.parseInt(u.getNumeropersonas())>0){
               dato="Hay "+u.getNumeropersonas()+" inquilinos, es posible entrar un nuevo inquilino";
              }
             
          %>
          <tr>
        <td align="center"><%=i%></td>
        <td align="center"><%=mensaje%></td>
        <td align="center"><%=u.getHabitacion()%></td>
        
        
        <%}%>
      </tr>
</tbody>
 
  </table>
      <%}%>
       </div>
 </div>
  <%@include file="WEB-INF/jspf/bottom.jspf"%>
