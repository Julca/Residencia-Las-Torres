<%@include file="WEB-INF/jspf/top.jspf"%>
<style type="text/css">
  body {
  background-color:lightseagreen;
}
 </style>
<div align="center">
<form class="form-horizontal">
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Nombres
    </label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="Nombre">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Apellidos
    </label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="Apellidos">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      DNI
    </label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="DNI">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Celular
    </label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="Celular">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Nro de Habitacion
    </label>
    <div class="controls">
      <input type="text" id="inputEmail" placeholder="Nro de Habitacion">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Fecha de Inicio
    </label>
    <div class="controls">
          <input type="date" name="fecha">
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="inputEmail">
      Fecha de Salida
    </label>
    <div class="controls">
           <input type="date" name="fecha">
    </div>
  </div>
    <div class="control-group">
    <div class="controls" align="center">
      <button type="submit" class="btn">Enviar</button>
    </div>
  </div>
</form>
</div>
<%@include file="WEB-INF/jspf/bottom.jspf"%>