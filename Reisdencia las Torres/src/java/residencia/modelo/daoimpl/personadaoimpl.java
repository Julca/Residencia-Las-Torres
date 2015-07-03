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
import residencia.modelo.dao.personadao;
import residencia.modelo.entidad.Deudaporpersona;
import residencia.modelo.entidad.Estadodecuenta;
import residencia.modelo.entidad.Persona;
import residencia.modelo.entidad.Personahospedada;

/**
 *
 * @author ulises
 */
public class personadaoimpl implements personadao {

    @Override
    public Persona buscarpersona(String dni) {

        Persona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT p.id_ubigeo,p.id_persona,p.apellidos,p.nombre,p.dni,p.N_CELULAR, " +
"                to_char(p.FECHA_NACIMIENTO,'dd-mm-yyyy') as fecha,u3.nombre AS distrito,u2.NOMBRE AS provincia,u1.NOMBRE AS region," +
"                u.NOMBRE AS pais FROM PERSONA p,UBIGEO u,UBIGEO u1 ,UBIGEO u2,UBIGEO u3  " +
"                WHERE  p.ID_UBIGEO=u3.ID_UBIGEO AND  u.id_ubigeo=u1.id_ubigeo_sup " +
"                AND u1.ID_UBIGEO=u2.ID_UBIGEO_SUP AND u2.ID_UBIGEO=u3.ID_UBIGEO_SUP " +
"                and p.dni like '"+dni+"%' " +
"                union " +
"                SELECT p.id_ubigeo,p.id_persona,p.apellidos,p.nombre,p.dni,p.N_CELULAR," +
"                to_char(p.FECHA_NACIMIENTO,'dd-mm-yyyy') as fecha,'' AS distrito,'' AS provincia,'' AS region, " +
"                '' AS pais FROM PERSONA p " +
"                WHERE " +
"                dni like '"+dni+"%'";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                u = new Persona();
                u.setIdubigeo(rs.getString("id_ubigeo"));
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

            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return u;
    }

    @Override
    public boolean registrarpersona(Persona persona) {
        boolean estado = false;
        Statement st = null;
        String query = "insert into PERSONA  values ('','"
                + persona.getNombre() + "','"
                + persona.getApellidos() + "','"
                + persona.getDni() + "','"
                + persona.getNCelular() + "','"
                + persona.getGenero() + "',"
                + "to_date('" + persona.getFechaNacimiento() + "','yyyy-mm-dd'),'"
                + persona.getIdubigeo() + "')";
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
    public boolean actualizarpersona(Persona persona) {
        boolean estado = true;
        Statement st = null;
        String query = "UPDATE PERSONA SET nombre='" + persona.getNombre() + "',apellidos='" + persona.getApellidos() + "', "
                + "dni=" + persona.getDni() + ",N_celular=" + persona.getNCelular() + ","
                + "fecha_nacimiento= to_date('" + persona.getFechaNacimiento() + "','dd-mm-yyyy'),id_ubigeo=" + persona.getIdubigeo()
                + " WHERE id_persona='" + persona.getIdPersona() + "'";
        try {
            st = conectar().createStatement();
            st.executeUpdate(query);
            conectar().commit();//el comiitt
            conectar().close();//cerrar coneccion
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
    public List<Personahospedada> listarpersonashospedadas() {
        List<Personahospedada> lista = new ArrayList<Personahospedada>();
        Personahospedada u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "select p.id_persona,p.apellidos,p.nombre,p.dni,p.n_celular,h.numero_cuarto FROM PERSONA p,"
                + "CONTRATO c,DETALLE_CONTRATO dc,HABITACION h WHERE p.id_persona=c.ID_INQUILINO "
                + "AND c.ID_CONTRATO=dc.ID_CONTRATO AND dc.ID_HABITACION=h.ID_HABITACION "
                + "order by p.apellidos asc ";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Personahospedada();
                u.setIdpersona(rs.getString("id_persona"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getString("dni"));
                u.setNcelular(rs.getString("n_celular"));
                u.setHabitacion(rs.getString("numero_cuarto"));
                lista.add(u);
            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return lista;
    }

    @Override
    public List<Deudaporpersona> listardeuda(String dni) {
        List<Deudaporpersona> lista = new ArrayList<Deudaporpersona>();
        Deudaporpersona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,"
                + "to_date(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,to_char(c.FECHA_SALIDA,'dd-mm-yyyy') as salida,"
                + "h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00' "
                + "AS debe FROM CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO "
                + "AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1' AND p.DNI like '" + dni + "%'";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Deudaporpersona();
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
        } catch (Exception e) {
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
        List<Deudaporpersona> lista = new ArrayList<Deudaporpersona>();
        Deudaporpersona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = " SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,"
                + "to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,to_char(c.FECHA_SALIDA,'dd-mm-yyyy') AS salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00' "
                + "AS debe FROM CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO "
                + "AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1'";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Deudaporpersona();
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
        } catch (Exception e) {
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
        List<Deudaporpersona> lista = new ArrayList<Deudaporpersona>();
        Deudaporpersona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = " SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,"
                + "to_char(c.FECHA_SALIDA,'dd-mm-yyyy') as salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00' AS debe FROM "
                + "CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO"
                + " AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1'"
                + " AND Deudor(C.ID_CONTRATO)IN(SELECT MAX(Deudor( ID_CONTRATO)) FROM CONTRATO ) ";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Deudaporpersona();
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
        } catch (Exception e) {
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
        List<Deudaporpersona> lista = new ArrayList<Deudaporpersona>();
        Deudaporpersona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT c.ID_CONTRATO, P.apellidos, P.NOMBRE, P.DNI, P.N_CELULAR,to_char(c.FECHA_INICIO,'dd-mm-yyyy') as inicio,"
                + "to_char(c.FECHA_SALIDA,'dd-mm-yyyy') as salida,h.NUMERO_CUARTO,'S/. '||Deudor(C.ID_CONTRATO)||'.00'"
                + " AS debe "
                + "FROM CONTRATO c,PERSONA  p,DETALLE_CONTRATO dc,HABITACION h "
                + "WHERE  p.ID_PERSONA=c.ID_INQUILINO AND c.ID_CONTRATO=dc.ID_CONTRATO "
                + "AND dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1' "
                + "AND Deudor(C.ID_CONTRATO)IN(SELECT min(Deudor( ID_CONTRATO)) FROM CONTRATO ) ";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Deudaporpersona();
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
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return lista;
    }

    @Override
    public Persona buscarpersonasinprocedencia(String dni) {
        Persona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT id_persona,apellidos,nombre,dni,N_CELULAR,genero,id_ubigeo,"
                + "to_char(FECHA_NACIMIENTO,'dd-mm-yyyy') as fecha FROM PERSONA  "
                + "WHERE  dni='" + dni + "'";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                u = new Persona();
                u.setIdPersona(rs.getString("id_persona"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getString("dni"));
                u.setNCelular(rs.getString("N_CELULAR"));
                u.setGenero(rs.getString("genero"));
                u.setFechaNacimiento(rs.getString("fecha"));
                u.setIdubigeo(rs.getString("id_ubigeo"));

            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return u;
    }

    @Override
    public List<Persona> deudadeunmes(String fecha) {
        List<Persona> lista = new ArrayList<Persona>();
        Persona u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT p.apellidos,p.nombre ,p.dni,p.n_celular,h.numero_cuarto,deudadeunmes(c.id_contrato,to_date('" + fecha + "','dd/mm/yyyy'))AS debe"
                + " FROM PERSONA p,CONTRATO c,DETALLE_CONTRATO dc ,HABITACION h "
                + "WHERE p.ID_PERSONA=c.ID_inquilino AND c.ID_CONTRATO=dc.ID_CONTRATO AND "
                + "dc.ID_HABITACION=h.ID_HABITACION AND c.ESTADO='1' AND deudadeunmes(c.id_contrato,to_date('" + fecha + "','dd/mm/yyyy'))>0";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Persona();
                u.setApellidos(rs.getString("apellidos"));
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getString("dni"));
                u.setNCelular(rs.getString("n_celular"));
                u.setHabitacion(rs.getString("numero_cuarto"));
                u.setDeuda(rs.getString("debe"));
                lista.add(u);
            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return lista;
    }

    @Override
    public String dniexistente(String dni) {
        String dniexistente = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "select dni from persona where dni='" + dni + "'";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                dniexistente = rs.getString("dni");
            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return dniexistente;
    }

    @Override
    public List<Estadodecuenta> estadodecuenta(String id) {
        List<Estadodecuenta> lista = new ArrayList<Estadodecuenta>();
        Estadodecuenta u = null;
        Statement st = null;
        ResultSet rs = null;
        String query = "select to_date( c.FECHA_CONTRATO,'dd/mm/yyyy') as fecha,'' as baucher,'Inicio de contrato' as GLOSA, dc.TOTAL as debito,0 as credito "
                + "from  persona p,contrato c,detalle_contrato dc,habitacion h "
                + "where  p.ID_PERSONA=c.ID_INQUILINO and c.ID_CONTRATO=dc.ID_CONTRATO and dc.ID_HABITACION=h.ID_HABITACION "
                + "and p.ID_PERSONA='" + id + "' "
                + "union "
                + "select to_date(mf.FECHA_MOVIMIENTO,'dd/mm/yyyy') as fecha ,mf.CODIGO_BAUCHER as baucher,mf.GLOSA,0 as debito,mf.MONTO as credito "
                + "from persona p,contrato c,detalle_contrato dc,habitacion h,movimiento_financiero mf "
                + "where p.ID_PERSONA=c.ID_INQUILINO and c.ID_CONTRATO=dc.ID_CONTRATO and dc.ID_HABITACION=h.ID_HABITACION "
                + "and c.ID_CONTRATO=mf.ID_CONTRATO  and p.ID_PERSONA='" + id + "' order by fecha";
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Estadodecuenta();
                u.setBaucher(rs.getString("baucher"));
                u.setFecha(rs.getString("fecha"));
                u.setGlosa(rs.getString("GLOSA"));
                u.setDebito(rs.getString("debito"));
                u.setCredito(rs.getString("credito"));

                lista.add(u);
            }
            conectar().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conectar().close();
            } catch (Exception ex) {

            }
        }
        return lista;
    }

}
