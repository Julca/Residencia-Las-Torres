
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos.css">

        <style type="text/css">
            body {
                background: url(recursos/img/img10.jpg);
            }
            h1{
                font-size: 500%;
                color: orangered;
            }
            .regis{
                margin-top:50px;
                color:fuchsia;
            }
            .tabla  label{
                font-size: 300%;
                color:blue;
            }
             .mensaje label{
                color: aquamarine;
            }
  
        </style>
    </head>
    
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
 
<body>
        
        <%
            String opcion = request.getParameter("opcion");
            opcion = opcion == null ? "" : opcion;
     %>

        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-3 col-md-2"></div>
                <div class="col-xs-12 col-sm-6 col-md-8  ">
                    <form method="POST" action="valida">
                        <h1>Residencia las Torrres </h1>
                        <table class="tabla" align="center">
                            <tbody>

                                <tr>
                                    <td><label class="col-sm-12">Usuario</label></td>
                                    <td><input type="text" class="form-control" name="users"  >
                                       
                                </tr>
                                <tr>
                                    <td><label class="col-sm-12">Password</label></td>
                                    <td><input type="password" class="form-control" name="password">
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2">
                                        <input type="submit" class="btn btn-success" name="submit"  value="Enviar">     
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="col-xs-12 col-sm-3 col-md-2"></div>
            </div>
        </div>
        <%
        out.println(mensaje); %>

        <div class="container"  >
            <div class="row">
                <div class="col-xs-12 col-sm-3 col-md-4"></div>
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <form method="POST" action="index.jsp">
                        <table class="table-condensed regis" align="center">
                            <tbody>
                                <tr>
                                    <td >
                                        <input type="submit" class="btn btn-success" value="Registrate">
                                        <input type="hidden" name="opcion" value="registrar">
                                    </td>
                                </tr>  
                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="col-xs-12 col-sm-3 col-md-4"></div>
            </div>
        </div>
     
        <%          if (opcion.equals("registrar")) {
        %>
        <form method="POST" action="valida"> 
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-3 col-md-3"></div>
                    <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
                        <table class="table table-condensed">
                            <tbody>
                                <tr>
                                    <td><label class="col-sm-12">Nombres</label></td>
                                    <td><input type="text" class="form-control" name="nombre" required="required"></td>
                                    <td><a class="btn btn-danger" href="index.jsp">x</a></td>
                                </tr>
                                <tr>
                                    <td><label class="col-sm-12">Apellidos</label></td>
                                    <td><input type="text" class="form-control" name="apellido" required="required"  >
                                        <input type="hidden"  name="action" value="registrarusuario"></td>
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
    
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-md-3"></div>
            <div class="col-xs-12 col-sm-6 col-md-6 well well-sm">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Usuario</label></td>
                            <td><input type="text" class="form-control" name="usuarioreg"></td>
                        </tr>
                        <tr> 
                            <td><label class="col-sm-12">Contrase&ntilde;ia</label></td>
                            <td><input type="password" class="form-control" name="passwordreg"></td>
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
<%}%>
</body>
</html>