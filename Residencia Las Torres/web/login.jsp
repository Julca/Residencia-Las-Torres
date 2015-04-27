

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
 
    </style>
</head>
<body>
    <div class="container" align="center" >
       
  <p class="bien">Bienvenidos a la Residencia las Torrres     </p>
   </div>
<table width="271" border="0" class="tabla">
    <tr>
      <td >Usuario</td>
      <td width="148"><form name="form1" method="post" action="">
        <input type="text" name="textfield" id="textfield">
      </form>
      </td>
    </tr>
    <tr>
      <td>Password</td>
      <td><form name="form2" method="post" action="">
        <input type="password" name="textfield2" id="textfield2">
      </form>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><form name="form3" method="post" action="Pagina.jsp">
        <input type="submit" name="button" id="button" value="Enviar"  >
      </form>
      </td>
    </tr>
  </table>
</body>
</html>