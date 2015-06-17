<%-- 
    Document   : reg_usuario
    Created on : 13/06/2015, 09:45:10 AM
    Author     : ulises
--%>

<%@page import="residencia.modelo.entidad.Region"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.entidad.Distrito"%>
<%@page import="residencia.modelo.entidad.Provincia"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
         <link rel="stylesheet" href="estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        residenciadao residenciadao=new residenciadaoimpl();
        %>
     <form method="POST" action="index.jsp"> 
     <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
            <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
     <table class="table table-condensed">
    <tbody>
        <tr>
          <td><label class="col-sm-12">Nombres</label></td>
          <td><input type="text" class="form-control" name="nombre" required="required"></td>
      </tr>
      <tr>
          <td><label class="col-sm-12">Apellidos</label></td>
          <td><input type="text" class="form-control" name="apellido" required="required"  ></td>
      </tr>
     <tr>
          <td><label class="col-sm-12">DNI</label></td>
          <td><input type="text" class="form-control" name="dni" required="required"  maxlength="8"></td>
     </tr>
     <tr>
        <td><label class="col-sm-12">Genero</label></td>
        <td><input type="radio" class="form-inline" name="genero" id="radio" value="F" >Femenino
            <input type="radio" class="form-inline" name="genero" id="radio" value="M" >Maculino
        </td>
      </tr>
      <tr>
          <td><label class="col-sm-12">Celular</label></td>
          <td><input type="text" class="form-control" name="celular" maxlength="9" ></td>
      </tr>
      <tr> 
          <td><label class="col-sm-12">Fecha de Nacimiento</label></td>
          <td><input type="date" class="form-control" name="fecha_nac" required="required"></td>
      </tr>
      
    </tbody>
     </table>

        </div>
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
      </div>
       </div>
    </body>
     <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
            <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
        <table class="table table-condensed">
    <tbody>
        <tr>
          <td><label class="col-sm-12">Usuario</label></td>
          <td><input type="text" class="form-control" name="usuario"   ></td>
      </tr>
      <tr> 
          <td><label class="col-sm-12">Contrase&ntilde;ia</label></td>
          <td><input type="password" class="form-control" name="password"  </td>
      </tr>
       <tr>
             <td colspan="5" align="center">
            <input type="submit" class="btn btn-success" value="Guardar">     
            </td>
      </tr>
    </tbody>
        </table> 
        </div>
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
      </div>
       </div>
    
</form>
 </body>
</html>
