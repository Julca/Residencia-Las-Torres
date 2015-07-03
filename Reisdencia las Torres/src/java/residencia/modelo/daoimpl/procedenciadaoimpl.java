/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import static coneccion.coneccion.conectar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import residencia.modelo.dao.procedenciadao;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;

/**
 *
 * @author ulises
 */
public class procedenciadaoimpl implements procedenciadao{

     @Override
    public List<Pais> listarpais() {
       List<Pais>  lista=new ArrayList<Pais>();
        Pais u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="  SELECT id_ubigeo,nombre FROM UBIGEO WHERE id_ubigeo_sup IS NULL";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Pais();
                 u.setIdpais(rs.getString("id_ubigeo"));
                 u.setPais(rs.getString("nombre"));
                 
                 lista.add(u);
             }
             conectar().close();
        } 
         catch (Exception e) {
            e.printStackTrace();
             try {
                  conectar().close(); 
             } catch (Exception ex) {
               
             }
        }
         return lista;
       }
    @Override
    public List<Region> listarregiones( ) {
       List<Region>  lista=new ArrayList<Region>();
        Region u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT DISTINCT u1.id_ubigeo,u1.nombre FROM UBIGEO u,UBIGEO u1 ,UBIGEO u2,"
                + "UBIGEO u3"
                +" WHERE u.id_ubigeo=u1.id_ubigeo_sup AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND "
                +"u2.ID_UBIGEO=u3.ID_UBIGEO_SUP AND u.id_ubigeo='51000000'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Region();
                 u.setIdregion(rs.getString("id_ubigeo"));
                 u.setRegion(rs.getString("nombre"));
                 
                 lista.add(u);
             }
             conectar().close();
        } 
         catch (Exception e) {
            e.printStackTrace();
             try {
                  conectar().close(); 
             } catch (Exception ex) {
               
             }
        }
         return lista;
       }
    @Override
    public List<Provincia> listarprovincias(String id_region) {
       List<Provincia>  lista=new ArrayList<Provincia>();
        Provincia u=null;
        Statement st=null;
        ResultSet rs=null;
        String query=" SELECT DISTINCT u2.id_ubigeo,u2.nombre FROM UBIGEO u,UBIGEO u1 ,"
                + "UBIGEO u2,UBIGEO u3"
                +" WHERE u.id_ubigeo=u1.id_ubigeo_sup AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND "
                +"u2.ID_UBIGEO=u3.ID_UBIGEO_SUP AND u1.id_ubigeo='"+id_region+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Provincia();
                 u.setIdprovincia(rs.getString("id_ubigeo"));
                 u.setProvincia(rs.getString("nombre"));
                 
                 lista.add(u);
             }
             conectar().close();
        } 
         catch (Exception e) {
            e.printStackTrace();
             try {
                  conectar().close(); 
             } catch (Exception ex) {
               
             }
        }
         return lista;
       }
    @Override
    public List<Distrito> listardistritos(String id_provincia) {
       List<Distrito>  lista=new ArrayList<Distrito>();
        Distrito u=null;
        Statement st=null;
        ResultSet rs=null;
        String query=" SELECT DISTINCT u3.id_ubigeo,u3.nombre FROM UBIGEO u,UBIGEO u1 ,"
                + "UBIGEO u2,UBIGEO u3"
                +" WHERE u.id_ubigeo=u1.id_ubigeo_sup AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND "
                +"u2.ID_UBIGEO=u3.ID_UBIGEO_SUP AND u2.id_ubigeo='"+id_provincia+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Distrito();
                 u.setIddistrito(rs.getString("id_ubigeo"));
                 u.setDistrito(rs.getString("nombre"));
                 
                 lista.add(u);
             }
             conectar().close();
        } 
         catch (Exception e) {
            e.printStackTrace();
             try {
                  conectar().close(); 
             } catch (Exception ex) {
               
             }
        }
         return lista;
       }
    
}
