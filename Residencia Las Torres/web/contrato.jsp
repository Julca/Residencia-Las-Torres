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

<div align="center">
    <%
        residenciadao residenciadao=new residenciadaoimpl();
        Persona persona=new Persona();
        Mes m=new Mes();
        int cantidad;
        String mensaje="";
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
    <form class="form-horizontal" action="reg_persona.jsp">
       <div class="control-group">
    <label class="control-label" for="inputEmail">
      Fecha de Inicio
    </label>
    <div class="controls">
          <input type="date" name="inicio"value="" size="30">
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Fecha de Salida
    </label>
    <div class="controls">
           <input type="date" name="salida"value="" size="30" >
    </div>
  </div>
  <div class="control-group" >
      <label class="control-label">Numero de Habitaci&oacute;n</label>
                    <div class="controls">
                        <select  class="form-control"  name="habitacion"><option>Selecciona</option> 
                            <%
                                for (Habitacion h : residenciadao.listarhabitacion()) {
                               
                            %>
                            <option   value="<%=h.getIdHabitacion()%>"><%=h.getNumeroCuarto()%></option>
                            <%}%>
                        </select>
                    </div>
   </div>
     <div class="control-group">
    <label class="control-label" for="inputEmail">
      Numero de personas
    </label>
    <div class="controls">
           <input type="text" name="num_personas"value="" size="30" >
    </div>
     </div>
     <div class="control-group">
    <label class="control-label" for="inputEmail">
      Precio actual
    </label>
    <div class="controls">
           <input type="text" name="precio_actual"value="" size="30" >
    </div>
  </div>
   <div class="control-group" >
       <label class="control-label">Ocupaci&oacute;n</label>
                    <div class="controls">
                        <select  class="form-control"  name="ocupacion"><option>Selecciona</option> 
                            <%
                                for (Ocupacion h : residenciadao.listarocupacion()) {
                               
                            %>
                            <option   value="<%=h.getIdOcupacion()%>"><%=h.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
   </div>
   <div class="control-group" >
      <label class="control-label">Institucion</label>
                    <div class="controls">
                        <select  class="form-control"  name="institucion"><option>Selecciona</option> 
                            <%
                                for (Institucion h : residenciadao.listarinstitucion()) {
                               
                            %>
                            <option   value="<%=h.getIdInstitucion()%>"><%=h.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
   </div>
 
    <div class="control-group">
    <div class="controls" align="center">
      <input type="submit" class="btn" value="Enviar">
    </div>
  </div>
</form>
</div>
<%@include file="WEB-INF/jspf/bottom.jspf"%>