<%@page import="residencia.modelo.entidad.Personahospedada"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
 <style type="text/css">
  body {
  background-color: #BEF781;
}
 </style>
 
     <h1 align="center" >Inquilinos</h1>
     <div class="container">
<table align="center" class="table table-striped" >
      
         <thead>
                <tr>
                  <td align="center" width="20%">#</td>
                  <td align="center" width="20%">Apellidos</td>
                  <td align="center" width="20%">Nombre</td>
                  <td align="center" width="10%">Celular</td>
                  <td align="center"  width="80%">Numero de habitaci&oacute;n</td>
                </tr>
              </thead>
              <tbody>
          <%
              int i=0;
          residenciadao dao=new residenciadaoimpl();
          for (Personahospedada  u :dao.listarpersonashospedadas()) {
              i++;                      
          %>
          <tr>
        <td align="center" ><%=i%></td>
        <td align="center" ><%=u.getApellidos()%></td>
        <td align="center" ><%=u.getNombre()%></td>
        <td align="center" ><%=u.getNcelular()%></td>
        <td align="center" ><%=u.getHabitacion()%></td>
        <%}%>
      </tr>
</tbody>
 
  </table>
     </div>
  
  <%@include file="WEB-INF/jspf/bottom.jspf"%>
