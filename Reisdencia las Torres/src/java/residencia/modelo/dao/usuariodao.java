/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import residencia.modelo.entidad.Usuario;

/**
 *
 * @author ulises
 */
public interface usuariodao {
    public String validarusuario(String user,String password); //en usuariodao
    public boolean  registrarusuario(Usuario usuario);//en usuariodao
}
