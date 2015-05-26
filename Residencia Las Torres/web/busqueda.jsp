<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@include file="WEB-INF/jspf/top.jspf"%>
 <style type="text/css">
  body {
  background-color: #BEF781;
}
 </style>

       <form class="form-horizontal" action="busqueda.jsp">
  <div class="control-group"align="center">
    <label class="control-label" for="inputEmail">DNI
    </label>
    <div class="controls "align="center">
      <input type="text" name="dni" value="" id="inputEmail"size="30" placeholder="dni">
    </div>
  </div>
   <div class="control-group">
    <div class="controls" align="center">
      <input type="submit" class="btn" value="Buscar">
    </div>
  </div>
       </form>
  
<table align="center" class="table table-striped" >
        <%
            String mensaje;
              String dni=request.getParameter("dni");dni=dni==null?"": dni;
              int i=0;
          residenciadao dao=new residenciadaoimpl();
          for (Persona  u :dao.buscarpersona(dni)) {
              i++;
              if(!u.getDni().equals(dni)){
                 mensaje = "NO SE ENCUENTRA REGISTRADO(A):<a href='Registrar.jsp'>REGISTRATE</a>  ";
              }
          %>
         <thead>
                <tr>
                  <td align="center" width="5%">#</td>
                  <td align="center" width="20%">Apellidos</td>
                  <td align="center" width="20%">Nombre</td>
                  <td align="center" width="10%">Dni</td>
                  <td align="center" width="10%">Celular</td>
                  <td align="center"  width="80%">Fecha de nacimiento</td>
                </tr>
              </thead>
              <tbody>
        
          <tr>
        <td align="center" ><%=i%></td>
        <td align="center" ><%=u.getApellidos()%></td>
        <td align="center" ><%=u.getNombre()%></td>
        <td align="center" ><%=u.getDni()%></td>
        <td align="center" ><%=u.getNcelular()%></td>
        <td align="center" ><%=u.getFechanacimiento()%></td>
        <%}%>
      </tr>
</tbody>
  </table>
  
  <%@include file="WEB-INF/jspf/bottom.jspf"%>
