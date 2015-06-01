<%@page import="residencia.modelo.entidad.Reporte_mensual"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
 <style type="text/css">
  body {
  background-color: #BEF781;
}
 </style>
 <div align="center">
     <h1>Pago</h1>
     <div class="container">
         
<table class="table table-striped" >
        
  
         <thead>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="15%">Apellidos</td>
                  <td align="center" width="15%">Nombre</td>
                  <td align="center" width="10%">Dni</td>
                  <td align="center" width="10%">Celular</td>
                  <td align="center" width="20%">Fecha inicial</td>
                  <td align="center" width="20%">Fecha final</td>
                  <td align="center" width="9%">Cancelar</td>
                </tr>
              </thead>
              <tbody>
          <%
              String mensaje="";
              int i=0;
          residenciadao dao= new residenciadaoimpl();
          for (Reporte_mensual u :dao.listarReporte_mensual()) {
              i++; 
              
          %>
          <tr>
        <td align="center"><%=i%></td>
        <td align="center"><%=u.getApellidos()%></td>
        <td align="center"><%=u.getNombre()%></td>
        <td align="center"><%=u.getDni()%></td>
        <td align="center"><%=u.getN_celular()%></td>
        <td align="center"><%=u.getFecha_inicial()%></td>
        <td align="center"><%=u.getFecha_final()%></td>
        <td align="center">
            <a href="">X</a> 
        </td>
        <%}%>
      </tr>
</tbody>
 
  </table>
  </div>
 </div>
  <%@include file="WEB-INF/jspf/bottom.jspf"%>
