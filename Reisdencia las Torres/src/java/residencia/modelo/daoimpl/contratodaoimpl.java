/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import static coneccion.coneccion.conectar;
import java.sql.Statement;
import residencia.modelo.dao.contratodao;

/**
 *
 * @author ulises
 */
public class contratodaoimpl implements contratodao {

    @Override
    public boolean contrato(String precio, String idpersona, String finicio,
            String ffinal, String idhabitacion, String idusuario, String idocupacion,
            String idinstitucion, String idapoderado) {
        boolean estado = false;
        Statement st = null;
        String query = "begin Registro_Contrato('" + precio + "','" + idpersona + "',"
                + "to_date('" + finicio + "','yyyy-mm-dd'),to_date('"
                + ffinal + "','yyyy-mm-dd'),'" + idhabitacion + "','" + idusuario + "','" + idocupacion + "',"
                + "'" + idinstitucion + "','" + idapoderado + "');end;";
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
    public boolean insertardetallecontrato(String idpago, String idhabitacion,
            String precioactual, String finicio, String number1, String number2) {
        boolean estado = false;
        Statement st = null;
        String query = "begin insertar_detallepago(" + idpago + "," + idhabitacion + ","
                + "" + precioactual + "," + finicio + "," + number1 + "," + number2 + ");end;";
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
