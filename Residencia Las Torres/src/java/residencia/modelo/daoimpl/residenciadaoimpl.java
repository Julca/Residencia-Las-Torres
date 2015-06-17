package residencia.modelo.daoimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import residencia.modelo.dao.residenciadao;
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
                +persona.getNcelular()+"','"
                +persona.getGenero()+"',"
                +"to_date('"+persona.getFechanacimiento()+"','yyyy-mm-dd'),'"
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
    public List<Usuario> validarusuario(String user, String password) {
        List<Usuario>  lista=new ArrayList<Usuario>();
        Usuario u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="select p.nombre ,p.apellidos ,p.dni ,u.users,u.contrasenia ,u.id_usuario from persona p,usuario u where p.id_persona=u.id_usuario and u.users='"+user+"' and u.contrasenia='"+password+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Usuario();
                 u.setNombre(rs.getString("nombre"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setDni(rs.getString("dni"));
                 u.setUsers(rs.getString("users"));
                 u.setPassword(rs.getString("contrasenia"));
                 u.setIdusuario(rs.getString("id_usuario"));
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
    public List<Region> listarregiones(String id_pais) {
       List<Region>  lista=new ArrayList<Region>();
        Region u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT DISTINCT u1.id_ubigeo,u1.nombre FROM UBIGEO u,UBIGEO u1 ,UBIGEO u2,UBIGEO u3"
                +" WHERE u.id_ubigeo=u1.id_ubigeo_sup AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND "
                +"u2.ID_UBIGEO=u3.ID_UBIGEO_SUP AND u.id_ubigeo='"+id_pais+"'";
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
        String query=" SELECT DISTINCT u2.id_ubigeo,u2.nombre FROM UBIGEO u,UBIGEO u1 ,UBIGEO u2,UBIGEO u3"
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
        String query=" SELECT DISTINCT u3.id_ubigeo,u3.nombre FROM UBIGEO u,UBIGEO u1 ,UBIGEO u2,UBIGEO u3"
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
                + "dc,HABITACION h WHERE p.id_persona=c.ID_PERSONA AND c.ID_CONTRATO=dc.ID_CONTRATO"
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
        String query="select p.apellidos,p.nombre,p.n_celular,h.numero_cuarto FROM PERSONA p,CONTRATO c,DETALLE_CONTRATO dc,HABITACION h WHERE p.id_persona=c.ID_PERSONA AND c.ID_CONTRATO=dc.ID_CONTRATO AND dc.ID_HABITACION=h.ID_HABITACION order by p.apellidos asc ";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Personahospedada();
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
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
    public List<Persona> buscarpersona(String dni) {
       List<Persona>  lista=new ArrayList<Persona>();
        Persona u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="select apellidos,nombre,dni,n_celular,genero,fecha_nacimiento from persona where dni='"+dni+"'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Persona();
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("nombre"));
                 u.setDni(rs.getString("dni"));
                 u.setNcelular(rs.getString("n_celular"));
                 u.setGenero(rs.getString("genero"));
                 u.setFechanacimiento(rs.getString("fecha_nacimiento"));
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
    public boolean contrato(String personas, String precio, String idpersona, String finicio, 
            String ffinal, String idhabitacion, String idusuario, String idocupacion, String idinstitucion, String idapoderado) {
            boolean estado = false;
        Statement st = null;
        String query="begin registro_contrato("+personas+","+precio+","+idpersona+","+finicio+","
        +ffinal+","+idhabitacion+","+idusuario+","+idocupacion+","+idinstitucion+","+idapoderado+");end;"
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
    public List<Mes> meses(String idpersona) {
      List<Mes>  lista=new ArrayList<Mes>();
        Mes u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT  c.fecha_inicio AS finicio ,TRUNC(MONTHS_BETWEEN( c.fecha_salida,c.fecha_inicio ))AS cantidad  FROM PERSONA p,CONTRATO c WHERE p.id_persona=c.id_persona AND p.id_persona='"+idpersona+"';";
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
    public boolean insertardetallecontrato(String idpago, String idhabitacion, String precioactual, String finicio, String number1, String number2) {
        boolean estado = false;
        Statement st = null;
        String query="begin insertar_detallepago("+idpago+","+idhabitacion+","+precioactual+","+finicio+","
        +number1+","+number2+");end;"
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
        String query="  select p.apellidos, p.nombre, p.dni, p.n_celular, dp.fecha_inicial, dp.fecha_final from persona p, contrato c, detalle_contrato dc, pago pa, detalle_pago dp where p.id_persona = c.id_persona and c.id_contrato = dc.id_contrato and dc.id_contrato = pa.id_contrato and pa.id_pago = dp.id_pago and dp.estado ='0'";
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
    public List<Deudaporpersona> deudadelinquilino() {
       List<Deudaporpersona>  lista=new ArrayList<Deudaporpersona>();
        Deudaporpersona u=null;
        Statement st=null;
        ResultSet rs=null;
        String query=" SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,"
                + "to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,to_char(c.FECHA_SALIDA,'dd-mm-yyyy') AS salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00' "
                + "AS debe FROM CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO "
                + "AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1'";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Deudaporpersona();
                 u.setIdcontrato(rs.getString("ID_CONTRATO"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("NOMBRE"));
                 u.setDni(rs.getString("DNI"));
                 u.setNCelular(rs.getString("N_CELULAR"));
                 u.setFechainicio(rs.getString("inicio"));
                 u.setFechasalida(rs.getString("salida"));
                 u.setNumero_habitacion(rs.getString("NUMERO_CUARTO"));
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

@Override
    public List<Deudaporpersona> elmasdudor() {
        List<Deudaporpersona>  lista=new ArrayList<Deudaporpersona>();
        Deudaporpersona u=null;
        Statement st=null;
        ResultSet rs=null;
        String query=" SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,"
                + "to_char(c.FECHA_SALIDA,'dd-mm-yyyy') as salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00' AS debe FROM "
                + "CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO"
                + " AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1'"
                + " AND Deudor(C.ID_CONTRATO)IN(SELECT MAX(Deudor( ID_CONTRATO)) FROM CONTRATO ) ";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Deudaporpersona();
                 u.setIdcontrato(rs.getString("ID_CONTRATO"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("NOMBRE"));
                 u.setDni(rs.getString("DNI"));
                 u.setNCelular(rs.getString("N_CELULAR"));
                 u.setFechainicio(rs.getString("inicio"));
                 u.setFechasalida(rs.getString("salida"));
                 u.setNumero_habitacion(rs.getString("NUMERO_CUARTO"));
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




@Override
    public List<Deudaporpersona> elmenosdeudor() {
      List<Deudaporpersona>  lista=new ArrayList<Deudaporpersona>();
        Deudaporpersona u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,"
                + "to_char(c.FECHA_SALIDA,'dd-mm-yyyy') as salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00'"
                + " AS debe "
                + "FROM CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO "
                + "AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1' "
                + "AND Deudor(C.ID_CONTRATO)IN(SELECT min(Deudor( ID_CONTRATO)) FROM CONTRATO ) ";
         try {
            st=conectar().createStatement();
            rs=st.executeQuery(query);
             while (rs.next()) {
                 u=new Deudaporpersona();
                 u.setIdcontrato(rs.getString("ID_CONTRATO"));
                 u.setApellidos(rs.getString("apellidos"));
                 u.setNombre(rs.getString("NOMBRE"));
                 u.setDni(rs.getString("DNI"));
                 u.setNCelular(rs.getString("N_CELULAR"));
                 u.setFechainicio(rs.getString("inicio"));
                 u.setFechasalida(rs.getString("salida"));
                 u.setNumero_habitacion(rs.getString("NUMERO_CUARTO"));
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


@Override
    public List<Persona1> buscarpersonasinprocedencia(String dni) {
         List<Persona1> lista=new ArrayList<Persona1>();
        Persona1 u=null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT id_persona,apellidos,nombre,dni,N_CELULAR,genero,id_ubigeo,"
                + "to_char(FECHA_NACIMIENTO,'dd-mm-yyyy') as fecha FROM PERSONA  "
                + "WHERE  dni='"+dni+"'";
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
                 u.setGenero(rs.getString("genero"));
                 u.setFechaNacimiento(rs.getString("fecha"));
                 u.setIdubigeo(rs.getString("id_ubigeo"));
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


    
    

