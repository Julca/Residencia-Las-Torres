

<%@page import="residencia.modelo.entidad.Persona"%>
<%@page import="java.util.List"%>
<%@page import="residencia.modelo.entidad.Usuario"%>
<%@page import="residencia.modelo.daoimpl.residenciadaoimpl"%>
<%@page import="residencia.modelo.dao.residenciadao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="css/Estilos.css">
	<style type="text/css">
         
  body {
background: url(recursos/img/img10.jpg) ;
}
.bien{
  font-size: 300%;
  color: white;
}
.tabla tr td{
    
    color:#08088A;
  font-size: 190%;
 
}
.tabla2 tr td{
    
    color:greenyellow;
  font-size: 100%;
 
}
.bajar {
   margin-top: 13%;  
    
}
.Reg{
    font-size: 200%;
    color: white;
    
}
 
    </style>
</head>
<body>
    
    <%
             
            String usuario=request.getParameter("users");
            String password=request.getParameter("password");
           
            residenciadao usuariodao=new residenciadaoimpl();
            List<Usuario> lista=usuariodao.validarusuario(usuario, password);
            Usuario us=new Usuario();
            for(Usuario u:lista){
                   if(u.getUsers().equals(usuario)&& u.getPassword().equals(password)){
                       response.sendRedirect("Pagina.jsp");
                   }
            }       
        %>
    
    <form method="post" action="index.jsp">
    <div class="container" align="center" >
       
  <p class="bien">Bienvenidos a la Residencia las Torrres     </p>
   </div>
   
<table width="350" border="0" class="tabla">
    <tr>
      <td >Usuario</td>
      <td width="148">
          <input type="text" name="users" value="">
     
      </td>
    </tr>
    <tr>
      <td>Password</td>
      <td>
          <input type="password" name="password" value="">
   
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit"  value="Ingresar"  >
      </td>
    </tr>
  </table>
   </form>
   <%
  
   Persona persona=new Persona();
   String nombre=request.getParameter("nombre");nombre=nombre==null?"": nombre;
   String apellido=request.getParameter("apellido");apellido=apellido==null?"": apellido;
   String dni=request.getParameter("dni");dni=dni==null?"": dni;
   String sexo=request.getParameter("sexo");sexo=sexo==null?"": sexo;
   String usuario1=request.getParameter("usuario");usuario=usuario==null?"": usuario;
   String password1=request.getParameter("password");password=password==null?"": password;
   String fecha_nac=request.getParameter("fecha_nac");fecha_nac=fecha_nac==null?"": fecha_nac;
   persona.setNombre(nombre);
        persona.setApellidos(apellido);
        persona.setDni(dni);
        persona.setGenero(sexo);
        persona.setFechanacimiento(fecha_nac);
        persona.setIdubigeo("");
        if(!nombre.equals("")&&!apellido.equals("")&&!dni.equals("")&&!sexo.equals("")&&
                !usuario1.equals("")&&!fecha_nac.equals("")&&!password1.equals("")){
         
        if(usuariodao.registrarpersona(persona)){  
          
            response.sendRedirect("index.jsp");
            
         
        }else{
            response.sendRedirect("index.jsp");
		}
        }
   %>
   <div class="container bajar">
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
            <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
    <form name="datos" class="form-horizontal table-condensed" method="post" action="reg_persona.jsp">
        

   </form>
   </div>
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
  </div>
</div>

</body>
</html>