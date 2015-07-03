package vista;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import residencia.modelo.dao.habitaciondao;
import residencia.modelo.dao.personadao;
import residencia.modelo.dao.procedenciadao;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.dao.usuariodao;
import residencia.modelo.daoimpl.habitaciondaoimpl;
import residencia.modelo.daoimpl.personadaoimpl;
import residencia.modelo.daoimpl.procedenciadaoimpl;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.daoimpl.usuariodaoimpl;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Habitaciondisponible;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Persona;
import residencia.modelo.entidad.Personahospedada;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;
import residencia.modelo.entidad.Usuario;
import static vista.consola.main;
public class consola {
    procedenciadao procedenciadao=new procedenciadaoimpl();
     personadao personadao=new personadaoimpl();
     habitaciondao habitaciondao=new habitaciondaoimpl();
     usuariodao usuariodao=new usuariodaoimpl();
    
    public static void main(String[] args) {
        consola main=new consola();
       //main.insertarpersona();
      //  main.validarusuario();
       //main.listarpaiss();
     //main.listarregion();
      // main.listarprovincia();
       //main.listardistrito();
      //  main.listarhabitacionesdisponibles();
        //main.listarhospedadas();
      main.buscarpersona();
        // TODO code application logic here
      //main.imprimir();
       // main.actualizarpersona();
       // main.DateFormatExample4();
      //main.result();
        
    }
    public void insertarpersona(){
       
        Persona persona=new Persona();
        persona.setNombre("uli");
        persona.setApellidos("julca");
        persona.setDni("55555555");
        persona.setNCelular("342456789");
        persona.setGenero("M");
        persona.setFechaNacimiento("2014-12-11");
        persona.setIdubigeo("");
        if(personadao.registrarpersona(persona)){
            System.out.println("se inserto");
            
        }else{
            System.out.println("no se inserto");
        }
    }
//    public void validaruser(){
//       
//            residenciadao residenciadao=new residenciadaoimpl();
//            for (Usuario u : residenciadao.validarusuario("ulices", "ulices")) { 
//                System.out.println("users: "+u.getUsers());
//                System.out.println("password "+u.getPassword());
//        }
//    }
    public void listarpaiss(){
       
            
            for (Pais u : procedenciadao.listarpais()) { 
                System.out.println("id: "+u.getIdpais()+"pais :"+u.getPais());
             
        }
    }
    public void listarregion(){
       
            ;
            for (Region u : procedenciadao.listarregiones()) { 
                System.out.println("id: "+u.getIdregion()+"region :"+u.getRegion());
             
        }
    }
    public void listarprovincia(){
            
            for (Provincia u : procedenciadao.listarprovincias("51210000")) { 
                System.out.println("id: "+u.getIdprovincia()+"provincia :"+u.getProvincia());
             
        }
    }
    public void listardistrito(){
            
            for (Distrito u : procedenciadao.listardistritos("51210500")) { 
                System.out.println("id: "+u.getIddistrito()+"distrito :"+u.getDistrito());
             
        }
    }
     public void listarhabitacionesdisponibles(){
            
            for (Habitaciondisponible u : habitaciondao.listarhabitacionesdisponibles()) { 
                System.out.println("id: "+u.getHabitacion()+"distrito :"+u.getPiso());
             
        }
    }
      public void listarhospedadas(){
             
            for (Personahospedada u : personadao.listarpersonashospedadas()) { 
                System.out.println("id: "+u.getApellidos()+" "+u.getNombre()+" "+u.getNcelular()+" "+u.getHabitacion());
             
        }
    }
       public void buscarpersona(){
             
          Persona persona=personadao.buscarpersona("48501245");
           
                System.out.println(" "+persona.getIdPersona()+" "+persona.getDni()+""+persona.getApellidos()+" "+persona.getNombre()+" "+persona.getNCelular()+" "+persona.getFechaNacimiento());
           
        }
    
       public void imprimir(){
           for(int i=0;i<5;i++){
               System.out.println(i+"  "+(i+1));

           }
       }
         public void validarusuario(){
           String id=usuariodao.validarusuario("uli", "uli");
             System.out.println(id);
       }
        public void actualizarpersona(){
          
           Persona persona=new Persona();
           persona.setApellidos("Julca Ramirez");
           persona.setNombre("Noe");
           persona.setDni("47589900");
           persona.setNCelular("478874987");
           persona.setIdPersona("P-NOE47589900JUL");
           persona.setGenero("M");
           persona.setIdubigeo("");
           persona.setFechaNacimiento("07-08-2002");
           if(personadao.actualizarpersona(persona)){
               System.out.println("Se actualizo");
           }else{
               System.out.println("No se actualizo");
           }
       }

 
public void DateFormatExample4() {

        Date now = new Date();
        String dateString = now.toString();
        System.out.println(" 1. " + dateString);
        SimpleDateFormat format = new SimpleDateFormat("MMM");
        System.out.println(" 3. " + format.format(now));
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
public String  mes(String fecha){

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
    return mes;
}
public void result(){
    System.out.println(mes("01/12/2014"));
}
        }
       
