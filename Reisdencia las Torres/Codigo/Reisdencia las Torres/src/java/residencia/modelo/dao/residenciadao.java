/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.List;
import residencia.modelo.entidad.Mes;

/**
 *
 * @author ulises
 */
public interface residenciadao {
    public List<Mes> meses(String idpersona);
    public List<Mes>  nombremes(String fecha);
}
