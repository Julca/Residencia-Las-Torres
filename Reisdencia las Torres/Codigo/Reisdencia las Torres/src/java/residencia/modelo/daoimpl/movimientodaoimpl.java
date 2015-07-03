/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import static coneccion.coneccion.conectar;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import residencia.modelo.dao.movimientodao;
import residencia.modelo.entidad.TipoMovimiento;
import residencia.modelo.util.HibernateUtil;

/**
 *
 * @author ulises
 */
public class movimientodaoimpl implements movimientodao {

    @Override
    public boolean registrarmovimiento(String idcontrato, String idtipomovimiento, String codigobaucher,
            String monto,
            String glosa) {
       boolean estado = false;
        Statement st = null;
        String query="begin registrar_movimiento('"+idcontrato+"','"+idtipomovimiento+"','"
                +codigobaucher+"','"+monto+"','"
                +glosa+"');end;"
                ;
        try {
            st = conectar().createStatement();
            st.executeUpdate(query);
            conectar().commit(); //commit();
            conectar().close();//cerrar la conexion
            estado = true;
        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            try {
                conectar().rollback();
                conectar().close();
            } catch (Exception ex) {
            }
        }
        return estado;

}



@Override
    public List<TipoMovimiento> listartipo_movimiento() {
         List<TipoMovimiento> lista =null;
        SessionFactory sf= null;
         Session session=null;    
         try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            lista=new ArrayList<TipoMovimiento>();
             Query query=session.createQuery("from TipoMovimiento");
             lista=query.list();
             session.close();
             
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
         return lista;
           }


    
}
