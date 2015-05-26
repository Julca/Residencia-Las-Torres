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
public class Persona {
    private String idpersona;
    private String nombre;
    private String apellidos;
    private String dni;
    private String genero;
    private String ncelular;
    private String fechanacimiento;
    private String idubigeo;

    public Persona() {
    }

    public String getIdubigeo() {
        return idubigeo;
    }

    public void setIdubigeo(String idubigeo) {
        this.idubigeo = idubigeo;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNcelular() {
        return ncelular;
    }

    public void setNcelular(String ncelular) {
        this.ncelular = ncelular;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
}
