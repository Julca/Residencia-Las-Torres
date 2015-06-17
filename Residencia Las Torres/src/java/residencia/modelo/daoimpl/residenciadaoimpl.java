package residencia.modelo.daoimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.entidad.Deudaporpersona;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Habitacion;
import residencia.modelo.entidad.Habitaciondisponible;
import residencia.modelo.entidad.Institucion;
import residencia.modelo.entidad.Mes;
import residencia.modelo.entidad.Ocupacion;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Persona1;
import residencia.modelo.entidad.Personahospedada;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;
import residencia.modelo.entidad.Reporte_mensual;
import residencia.modelo.entidad.TipoMovimiento;
import residencia.modelo.entidad.Usuario;
import residencia.modelo.util.HibernateUtil;
public class residenciadaoimpl implements residenciadao{
public Connection conectar(){
    return coneccion.coneccion.conectar();
}
    @Override
    public boolean registrarpersona(Persona1 persona) {
    boolean estado = false;
        Statement st = null;
        String query="insert into PERSONA  values ('','"
                +persona.getNombre()+"','"
                +persona.getApellidos()+"','"
                +persona.getDni()+"','"
                +persona.getNCelular()+"','"
                +persona.getGenero()+"',"
                +"to_date('"+persona.getFechaNacimiento()+"','yyyy-mm-dd'),'"
                +persona.getIdubigeo()+"')"
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
    public String validarusuario(String user, String password) {
        String lista=null;
        Statement st=null;
        ResultSet rs=null;
        String query="select u.id_usuario from persona p,usuario u where p.id_persona=u.id_usuario"
                + " and u.users='"+user+"' and u.contrasenia='"+password+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                 lista=rs.getString("id_usuario");
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
    @Override
    public List<Habitaciondisponible> listarhabitacionesdisponibles() {
       List<Habitaciondisponible>  lista=new ArrayList<Habitaciondisponible>();
        Habitaciondisponible u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT numero_cuarto,numero_piso FROM HABITACION WHERE numero_cuarto "
                + "NOT IN (SELECT h.numero_cuarto FROM PERSONA p,CONTRATO c,DETALLE_CONTRATO "
                + "dc,HABITACION h WHERE p.id_persona=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO"
                + " AND dc.ID_HABITACION=h.ID_HABITACION) order by numero_cuarto asc";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Habitaciondisponible();
                 u.setHabitacion(rs.getString("numero_cuarto"));
                 u.setPiso(rs.getString("numero_piso"));
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
    public List<Personahospedada> listarpersonashospedadas() {
       List<Personahospedada>  lista=new ArrayList<Personahospedada>();
        Personahospedada u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="select p.id_persona,p.apellidos,p.nombre,p.dni,p.n_celular,h.numero_cuarto FROM PERSONA p,"
                + "CONTRATO c,DETALLE_CONTRATO dc,HABITACION h WHERE p.id_persona=c.ID_INQUILINO "
                + "AND c.ID_CONTRATO=dc.ID_CONTRATO AND dc.ID_HABITACION=h.ID_HABITACION "
                + "order by p.apellidos asc ";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Personahospedada();
                 u.setIdpersona(rs.getString("id_persona"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
                 u.setDni(rs.getString("dni"));
                 u.setNcelular(rs.getString("n_celular"));
                 u.setHabitacion(rs.getString("numero_cuarto"));
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
    public List<Persona1> buscarpersona(String dni) {
       List<Persona1> lista=new ArrayList<Persona1>();
        Persona1 u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT p.id_persona,p.apellidos,p.nombre,p.dni,p.N_CELULAR,"
                + "to_char(p.FECHA_NACIMIENTO,'dd-mm-yyyy') as fecha,u3.nombre AS distrito,u2.NOMBRE AS provincia,u1.NOMBRE AS region,"
                + "u.NOMBRE AS pais FROM PERSONA p,UBIGEO u,UBIGEO u1 ,UBIGEO u2,UBIGEO u3 "
                + "WHERE  p.ID_UBIGEO=u3.ID_UBIGEO AND  u.id_ubigeo=u1.id_ubigeo_sup "
                + "AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND u2.ID_UBIGEO=u3.ID_UBIGEO_SUP "
                + "and p.dni='"+dni+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Persona1();
                 u.setIdPersona(rs.getString("id_persona"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
                 u.setDni(rs.getString("dni"));
                 u.setNCelular(rs.getString("N_CELULAR"));
                 u.setFechaNacimiento(rs.getString("fecha"));
                 u.setDistrito(rs.getString("distrito"));
                 u.setProvincia(rs.getString("provincia"));
                 u.setRegion(rs.getString("region"));
                 u.setPais(rs.getString("pais"));
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
    @Override
    public List<Institucion> listarinstitucion() {
         List<Institucion> lista =null;
        SessionFactory sf= null;
         Session session=null;    
         try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            lista=new ArrayList<Institucion>();
             Query query=session.createQuery("from Institucion");
             lista=query.list();
             session.close();
             
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
         return lista;
           }

    @Override
    public boolean contrato( String precio, String idpersona, String finicio, 
            String ffinal, String idhabitacion, String idusuario, String idocupacion,
            String idinstitucion, String idapoderado) {
            boolean estado = false;
        Statement st = null;
        String query="begin Registro_Contrato('"+precio+"','"+idpersona+"',"
                + "to_date('"+finicio+"','yyyy-mm-dd'),to_date('"
                +ffinal+"','yyyy-mm-dd'),'"+idhabitacion+"','"+idusuario+"','"+idocupacion+"',"
                + "'"+idinstitucion+"','"+idapoderado+"');end;";
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
    public List<Mes> meses(String idpersona) {
      List<Mes>  lista=new ArrayList<Mes>();
        Mes u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT  c.fecha_inicio AS finicio ,TRUNC(MONTHS_BETWEEN( c.fecha_salida,"
                + "c.fecha_inicio ))AS cantidad  FROM PERSONA p,CONTRATO c "
                + "WHERE p.id_persona=c.id_persona AND p.id_persona='"+idpersona+"' ";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Mes();
                 u.setCantidad(rs.getString("cantidad"));
                 u.setFinicio(rs.getString("finicio"));
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
    public boolean insertardetallecontrato(String idpago, String idhabitacion,
            String precioactual, String finicio, String number1, String number2) {
        boolean estado = false;
        Statement st = null;
        String query="begin insertar_detallepago("+idpago+","+idhabitacion+","
                + ""+precioactual+","+finicio+","+number1+","+number2+");end;"
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
    public List<Reporte_mensual> listarReporte_mensual() {
        List<Reporte_mensual>  lista=new ArrayList<Reporte_mensual>();
        Reporte_mensual u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="  select p.apellidos, p.nombre, p.dni, p.n_celular, dp.fecha_inicial, "
                + "dp.fecha_final from persona p, contrato c, detalle_contrato dc, pago pa, "
                + "detalle_pago dp where p.id_persona = c.id_persona and c.id_contrato = dc.id_contrato "
                + "and dc.id_contrato = pa.id_contrato and pa.id_pago = dp.id_pago and dp.estado ='1'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Reporte_mensual();
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
                 u.setDni(rs.getString("dni"));
                 u.setN_celular(rs.getString("n_celular"));
                 u.setFecha_inicial(rs.getString("fecha_inicial"));
                 u.setFecha_final(rs.getString("fecha_final"));
                 
                
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
    public boolean actualizarpersona(Persona1 persona) {
          boolean estado=true;
        Statement st=null;
        String query="UPDATE PERSONA SET nombre='"+persona.getNombre()+"',apellidos='"+persona.getApellidos()+"', "
                + "dni="+persona.getDni()+",N_celular="+persona.getNCelular()+","
                + "fecha_nacimiento= to_date('"+persona.getFechaNacimiento()+"','dd-mm-yyyy'),id_ubigeo="+persona.getIdubigeo()
                +" WHERE id_persona='"+persona.getIdPersona()+"'";
        try {
            st=conectar().createStatement();
            st.executeUpdate(query);
            conectar().commit();//el comiitt
            conectar().close();//cerrar coneccion
            estado=true;
        } catch (Exception e) {
            e.printStackTrace();
            estado=false;
            try {
                conectar().rollback();
                conectar().close();
            } catch (Exception ex) {
            }
        }
        return estado;
    }

    

    @Override
    public List<Persona1> deudadeunmes(String fecha) {
         List<Persona1> lista=new ArrayList<Persona1>();
        Persona1 u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT p.apellidos,p.nombre ,p.dni,p.n_celular,h.numero_cuarto,deudadeunmes(DNI,to_date('"+fecha+"','dd/mm/yyyy'))AS debe"
                + " FROM PERSONA p,CONTRATO c,DETALLE_CONTRATO dc ,HABITACION h "
                + "WHERE p.ID_PERSONA=c.ID_inquilino AND c.ID_CONTRATO=dc.ID_CONTRATO AND "
                + "dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1' AND deudadeunmes(DNI,to_date('"+fecha+"','dd/mm/yyyy'))>0";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Persona1();
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
                 u.setDni(rs.getString("dni"));
                 u.setNCelular(rs.getString("n_celular"));
                 u.setHabitacion(rs.getString("numero_cuarto"));
                 u.setDeuda(rs.getString("debe"));
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
    public static String dateMonth(Date date){
 String result="";
 Calendar calendar=Calendar.getInstance();
 calendar.setTime(date);
 int month=0;
 
 try{
   month=calendar.get(Calendar.MONTH);
 }catch(Exception ex){}
 switch(month){
  case 0:
    {
      result="Enero";
      break;
    }
  case 1:
    {
      result="Febrero";
      break;
    }
  case 2:
    {
      result="Marzo";
      break;
    }
  case 3:
    {
      result="Abril";
      break;
    }
  case 4:
    {
      result="Mayo";
      break;
    }
  case 5:
    {
      result="Junio";
      break;
    }
  case 6:
    {
      result="Julio";
      break;
    }
  case 7:
    {
      result="Agosto";
      break;
    }
  case 8:
    {
      result="Septiembre";
      break;
    }
  case 9:
    {
      result="Octubre";
      break;
    }
  case 10:
    {
      result="Noviembre";
      break;
    }
  case 11:
    {
      result="Diciembre";
      break;
    }
  default:
    {
      result="Error";
      break;
    }
 }
 return result;
} 
   @Override
public List<Mes>  nombremes(String fecha){
List<Mes> lista=new ArrayList<Mes>();
        Mes u=new Mes();
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaDate = null;
    try {
        fechaDate = formato.parse(fecha);
    } 
    catch (ParseException ex) 
    {
        System.out.println(ex);
    }
      String mes=dateMonth(fechaDate);
      u.setNombre(mes);
      lista.add(u);
    return lista;
}

    @Override
    public boolean registrarusuario(Usuario usuario) {
       boolean estado = false;
        Statement st = null;
        String query="begin Registrarusuario('"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getDni()+"',"
                + "'"+usuario.getCelular()+"','"+usuario.getGenero()+"',to_date('"+usuario.getFechaNacimiento()+"','yyyy-mm-dd'),'"+usuario.getUsers()+"',"
                + "'"+usuario.getPassword()+"');end;";
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
    public String dniexistente(String dni) {
       String dniexistente=null;
        Statement st=null;
        ResultSet rs=null;
        String query="select dni from persona where dni='"+dni+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                 dniexistente=rs.getString("dni");
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
         return dniexistente;
       }
          }


    
    

