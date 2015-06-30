/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.dao;

import java.util.List;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;

/**
 *
 * @author ulises
 */
public interface procedenciadao {
    public List<Pais> listarpais();//en procedenciadao
    public List<Region> listarregiones();//en procedenciadao
    public List<Provincia> listarprovincias(String id_region);//en procedenciadao
    public List<Distrito>listardistritos(String id_provincia);//en procedenciadao
}
