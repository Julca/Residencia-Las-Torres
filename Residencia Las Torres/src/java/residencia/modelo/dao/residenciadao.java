/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.Date;
import java.util.List;
import residencia.modelo.entidad.Deudaporpersona;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Habitacion;
import residencia.modelo.entidad.Habitaciondisponible;
import residencia.modelo.entidad.Institucion;
import residencia.modelo.entidad.Mes;
import residencia.modelo.entidad.Ocupacion;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Persona;
import residencia.modelo.entidad.Personahospedada;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;
import residencia.modelo.entidad.Reporte_mensual;
import residencia.modelo.entidad.TipoMovimiento;
import residencia.modelo.entidad.Usuario;


// se va a crear:
//personadao
//habitaciondao
//usuariodao
//procedenciadao
//movimientodao
//contratodao
//ocupaciondao
//instituciondao
public interface residenciadao {
    public String validarusuario(String user,String password); //en usuariodao
    public List<Pais> listarpais();//en procedenciadao
    public List<Region> listarregiones();//en procedenciadao
    public List<Provincia> listarprovincias(String id_region);//en procedenciadao
    public List<Distrito>listardistritos(String id_provincia);//en procedenciadao
    public List<Habitaciondisponible> listarhabitacionesdisponibles();//en habitaciondao
    public List<Persona> buscarpersona(String dni);//en personadao
    public boolean registrarpersona(Persona persona);//en personadao
    public boolean actualizarpersona(Persona persona);//en personadao
    public List<Personahospedada> listarpersonashospedadas();//en personadao
    public List<Habitacion> listarhabitacion();//en habitaciondao
    public List<Ocupacion> listarocupacion();//en ocupaciondao
    public List<Institucion> listarinstitucion();//en instituciondao
    public boolean contrato(String precio,String idpersona,String finicio,String ffinal,
    String idhabitacion,String idusuario,String idocupacion,String idinstitucion,String idapoderado);
    public List<Mes> meses(String idpersona);//en contratodao
    public boolean insertardetallecontrato(String idpago,String idhabitacion,String precioactual,
    String finicio,String number1,String number2);//en contratodao
    
    public List<Reporte_mensual> listarReporte_mensual();
    public List<Deudaporpersona> listardeuda(String dni);//en personadao
    public List<TipoMovimiento> listartipo_movimiento();// en movimientodao
    public boolean registrarmovimiento(String idcontrato,String idtipomovimiento,String codigobaucher,
    String monto,String glosa );// en movimientodao
    
    public List<Deudaporpersona> deudadelinquilino();//en personadao
    public List<Deudaporpersona> elmasdudor();//en personadao
    public List<Deudaporpersona> elmenosdeudor();//en personadao
    public List<Persona> buscarpersonasinprocedencia(String dni);//en personadao

    public List<Persona> deudadeunmes(String fecha);//en personadao
    public List<Mes>  nombremes(String fecha);
    public boolean  registrarusuario(Usuario usuario);//en usuariodao
    public String  dniexistente(String dni);//en personadao
}

