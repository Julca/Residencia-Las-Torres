/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.entidad;

/**
 *
 * @author ulises
 */
public class Habitaciondisponible {
    private String habitacion;
    private String piso;
    private String maxnumeropersonas;
    private String numeropersonas;
    private String idPersona;
    private String idhabitacion;
     private String nombre;
     private String apellidos;
     private String dni;
     private String NCelular;
    public Habitaciondisponible() {
    }

    public String getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(String idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNCelular() {
        return NCelular;
    }

    public void setNCelular(String NCelular) {
        this.NCelular = NCelular;
    }

    public String getMaxnumeropersonas() {
        return maxnumeropersonas;
    }

    public void setMaxnumeropersonas(String maxnumeropersonas) {
        this.maxnumeropersonas = maxnumeropersonas;
    }

    public String getNumeropersonas() {
        return numeropersonas;
    }

    public void setNumeropersonas(String numeropersonas) {
        this.numeropersonas = numeropersonas;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
    
}
