/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import static coneccion.coneccion.conectar;
import java.sql.ResultSet;
import java.sql.Statement;
import residencia.modelo.dao.usuariodao;
import residencia.modelo.entidad.Usuario;

/**
 *
 * @author ulises
 */
public class usuariodaoimpl implements usuariodao{
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
    public boolean registrarusuario(Usuario usuario) {
       boolean estado = false;
        Statement st = null;
        String query="begin Registrarusuario('"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getDni()+"',"
                + "'"+usuario.getCelular()+"','"+usuario.getGenero()+"',to_date('"+usuario.getFechaNacimiento()+"','yyyy-mm-dd'),'','"
                +usuario.getUsers()+"',"
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
}
