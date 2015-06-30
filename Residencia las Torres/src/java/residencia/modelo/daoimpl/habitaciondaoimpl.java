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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import residencia.modelo.dao.habitaciondao;
import residencia.modelo.entidad.Habitacion;
import residencia.modelo.entidad.Habitaciondisponible;
import residencia.modelo.util.HibernateUtil;

/**
 *
 * @author ulises
 */
public class habitaciondaoimpl implements habitaciondao{
    @Override
    public List<Habitaciondisponible> listarhabitacionesdisponibles() {
       List<Habitaciondisponible>  lista=new ArrayList<Habitaciondisponible>();
        Habitaciondisponible u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT h.id_habitacion, h.numero_cuarto,h.numero_piso,count(dc.id_habitacion) as personas FROM HABITACION h,DETALLE_CONTRATO dc,CONTRATO c " +
"WHERE h.ID_HABITACION=dc.ID_HABITACION and dc.ID_CONTRATO=c.ID_CONTRATO and c.ESTADO='1' group by h.numero_cuarto, h.numero_piso,h.id_habitacion " +
"union SELECT h.id_habitacion, h.numero_cuarto,h.numero_piso,0 as personas from habitacion h where h.numero_cuarto NOT IN (SELECT hb.numero_cuarto " +
"FROM PERSONA pe,CONTRATO co,DETALLE_CONTRATO dco,HABITACION hb WHERE pe.id_persona=co.ID_INQUILINO AND co.ID_CONTRATO=dco.ID_CONTRATO " +
"AND dco.ID_HABITACION=hb.ID_HABITACION )";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Habitaciondisponible();
                 u.setIdhabitacion(rs.getString("id_habitacion"));
                 u.setHabitacion(rs.getString("numero_cuarto"));
                 u.setPiso(rs.getString("numero_piso"));
                 u.setNumeropersonas(rs.getString("personas"));
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
    public List<Habitacion> listarhabitacion() {
       List<Habitacion> lista =null;
        SessionFactory sf= null;
         Session session=null;    
         try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            lista=new ArrayList<Habitacion>();
             Query query=session.createQuery("from Habitacion");
             lista=query.list();
             session.close();
             
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
         return lista;
           }

    @Override
    public List<Habitaciondisponible> listarpersonasporhabitacion(String idhabitacion) {
       List<Habitaciondisponible>  lista=new ArrayList<Habitaciondisponible>();
        Habitaciondisponible u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT p.ID_PERSONA ,p.APELLIDOS,p.NOMBRE,p.DNI,p.N_CELULAR FROM HABITACION h,DETALLE_CONTRATO dc,CONTRATO c,persona p " +
"WHERE h.ID_HABITACION=dc.ID_HABITACION and dc.ID_CONTRATO=c.ID_CONTRATO and c.ID_INQUILINO=p.ID_PERSONA and c.ESTADO='1' " +
"and h.ID_HABITACION='"+idhabitacion+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Habitaciondisponible();
                 u.setIdPersona(rs.getString("ID_PERSONA"));
                 u.setApellidos(rs.getString("APELLIDOS"));
                 u.setNombre(rs.getString("NOMBRE"));
                 u.setDni(rs.getString("DNI"));
                 u.setNCelular(rs.getString("N_CELULAR"));
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
