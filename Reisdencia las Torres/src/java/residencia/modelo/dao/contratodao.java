/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.List;

/**
 *
 * @author ulises
 */
public interface contratodao {
    public boolean contrato(String precio,String idpersona,String finicio,String ffinal,
    String idhabitacion,String idusuario,String idocupacion,String idinstitucion,String idapoderado);
     
    public boolean insertardetallecontrato(String idpago,String idhabitacion,String precioactual,
    String finicio,String number1,String number2);//en contratodao
    
}
