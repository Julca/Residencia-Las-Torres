/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import residencia.modelo.dao.ocupaciondao;
import residencia.modelo.entidad.Ocupacion;
import residencia.modelo.util.HibernateUtil;

/**
 *
 * @author ulises
 */
public class ocupaciondaoimpl implements ocupaciondao{

    @Override
    public List<Ocupacion> listarocupacion() {
       List<Ocupacion> lista =null;
        SessionFactory sf= null;
         Session session=null;    
         try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            lista=new ArrayList<Ocupacion>();
             Query query=session.createQuery("from Ocupacion");
             lista=query.list();
             session.close();
             
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
         return lista;
           }
}
