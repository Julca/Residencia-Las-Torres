package vista;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.entidad.Persona;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.entidad.Distrito;
import residencia.modelo.entidad.Habitaciondisponible;
import residencia.modelo.entidad.Pais;
import residencia.modelo.entidad.Personahospedada;
import residencia.modelo.entidad.Provincia;
import residencia.modelo.entidad.Region;
import residencia.modelo.entidad.Usuario;
import static vista.consola.main;
public class consola {
    public static void main(String[] args) {
        consola main=new consola();
      // main.insertarpersona();
        //main.validaruser();
       // main.listarpaiss();
      // main.listarregion();
       //main.listarprovincia();
      //  main.listardistrito();
      //  main.listarhabitacionesdisponibles();
        //main.listarhospedadas();
       // main.buscarpersona();
        // TODO code application logic here
        main.imprimir();
    }
    public void insertarpersona(){
        residenciadao residenciadao=new residenciadaoimpl();
        Persona persona=new Persona();
        persona.setNombre("uli");
        persona.setApellidos("julca");
        persona.setDni("32521567");
        persona.setNcelular("342456789");
        persona.setGenero("M");
        persona.setFechanacimiento("2014-12-11");
        if(residenciadao.registrarpersona(persona)){
            System.out.println("se inserto");
            
        }else{
            System.out.println("no se inserto");
        }
    }
    public void validaruser(){
       
            residenciadao residenciadao=new residenciadaoimpl();
            for (Usuario u : residenciadao.validarusuario("ulices", "ulices")) { 
                System.out.println("users: "+u.getUsers());
                System.out.println("password "+u.getPassword());
        }
    }
    public void listarpaiss(){
       
            residenciadao residenciadao=new residenciadaoimpl();
            for (Pais u : residenciadao.listarpais()) { 
                System.out.println("id: "+u.getIdpais()+"pais :"+u.getPais());
             
        }
    }
    public void listarregion(){
       
            residenciadao residenciadao=new residenciadaoimpl();
            for (Region u : residenciadao.listarregiones("51000000")) { 
                System.out.println("id: "+u.getIdregion()+"region :"+u.getRegion());
             
        }
    }
    public void listarprovincia(){
            residenciadao residenciadao=new residenciadaoimpl();
            for (Provincia u : residenciadao.listarprovincias("51210000")) { 
                System.out.println("id: "+u.getIdprovincia()+"provincia :"+u.getProvincia());
             
        }
    }
    public void listardistrito(){
            residenciadao residenciadao=new residenciadaoimpl();
            for (Distrito u : residenciadao.listardistritos("51010100")) { 
                System.out.println("id: "+u.getIddistrito()+"distrito :"+u.getDistrito());
             
        }
    }
     public void listarhabitacionesdisponibles(){
            residenciadao residenciadao=new residenciadaoimpl();
            for (Habitaciondisponible u : residenciadao.listarhabitacionesdisponibles()) { 
                System.out.println("id: "+u.getHabitacion()+"distrito :"+u.getPiso());
             
        }
    }
      public void listarhospedadas(){
            residenciadao residenciadao=new residenciadaoimpl();
            for (Personahospedada u : residenciadao.listarpersonashospedadas()) { 
                System.out.println("id: "+u.getApellidos()+" "+u.getNombre()+" "+u.getNcelular()+" "+u.getHabitacion());
             
        }
    }
       public void buscarpersona(){
            residenciadao residenciadao=new residenciadaoimpl();
            for (Persona u : residenciadao.buscarpersona("76354454")) { 
                System.out.println(" "+u.getApellidos()+" "+u.getNombre()+" "+u.getNcelular()+" "+u.getFechanacimiento());
             
        }
    }
       public void imprimir(){
           for(int i=0;i<5;i++){
               System.out.println(i+"  "+(i+1));
               
              
           }
       }
}
