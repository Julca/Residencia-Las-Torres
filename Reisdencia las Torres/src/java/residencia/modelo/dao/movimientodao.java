/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.List;
import residencia.modelo.entidad.TipoMovimiento;

/**
 *
 * @author ulises
 */
public interface movimientodao {
    public List<TipoMovimiento> listartipo_movimiento();// en movimientodao
    public boolean registrarmovimiento(String idcontrato,String idtipomovimiento,String codigobaucher,
    String monto,String glosa );// en movimientodao
}
