/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.List;
import residencia.modelo.entidad.Deudaporpersona;
import residencia.modelo.entidad.Estadodecuenta;
import residencia.modelo.entidad.Persona;
import residencia.modelo.entidad.Personahospedada;

/**
 *
 * @author ulises
 */
public interface personadao {
   public Persona buscarpersona(String dni);//en personadao
    public boolean registrarpersona(Persona persona);//en personadao
    public boolean actualizarpersona(Persona persona);//en personadao
    public List<Personahospedada> listarpersonashospedadas();//en personadao
    public List<Deudaporpersona> deudadelinquilino();//en personadao
    public List<Deudaporpersona> elmasdudor();//en personadao
    public List<Deudaporpersona> elmenosdeudor();//en personadao
    public Persona buscarpersonasinprocedencia(String dni);//en personadao
    public List<Persona> deudadeunmes(String fecha);//en personadao
    public List<Deudaporpersona> listardeuda(String dni);//en personadao
    public String  dniexistente(String dni);//en personadao
    public List<Estadodecuenta>  estadodecuenta(String id);
}
