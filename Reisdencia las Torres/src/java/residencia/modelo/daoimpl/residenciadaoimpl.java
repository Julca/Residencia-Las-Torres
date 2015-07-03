/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.daoimpl;

import static coneccion.coneccion.conectar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.entidad.Mes;

/**
 *
 * @author ulises
 */
public class residenciadaoimpl implements residenciadao{

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

    
}
