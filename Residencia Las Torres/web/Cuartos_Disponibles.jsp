<%@page import="residencia.modelo.entidad.Habitaciondisponible"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
 <style type="text/css">
  body {
  background-color: #BEF781;
}
 </style>
 <div align="center">
     <h1 width="50%">Habitaciones disponibles</h1>
     <div class="container">
         
<table class="table table-striped" >
        
  
         <thead>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="20%">Piso</td>
                  <td align="center" width="20%">Numero de habitaci&oacute;n</td>
                  
                </tr>
              </thead>
              <tbody>
          <%
              String mensaje="";
              int i=0;
          residenciadao dao=new residenciadaoimpl();
          for (Habitaciondisponible u :dao.listarhabitacionesdisponibles()) {
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
          %>
          <tr>
        <td align="center"><%=i%></td>
        <td align="center"><%=mensaje%></td>
        <td align="center"><%=u.getHabitacion()%></td>
        <%}%>
      </tr>
</tbody>
 
  </table>
  </div>
 </div>
  <%@include file="WEB-INF/jspf/bottom.jspf"%>
