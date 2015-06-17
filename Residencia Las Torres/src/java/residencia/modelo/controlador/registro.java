
package residencia.modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.entidad.Persona;

/**
 *
 * @author ulises
 */
public class registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        residenciadao residenciadao=new residenciadaoimpl();
        response.setContentType("text/html;charset=UTF-8");
        String region=request.getParameter("region");region=region==null?"": region;
        
        String dni=request.getParameter("dni");dni=dni==null?"": dni;
        String nombre=request.getParameter("nombre");nombre=nombre==null?"":nombre;
        String apellidos=request.getParameter("apellido");apellidos=apellidos==null?"": apellidos;
        String genero=request.getParameter("genero");genero=genero==null?"": genero;
        String celular=request.getParameter("celular");celular=celular==null?"": celular;
        String fecha_nac=request.getParameter("fecha_nac");fecha_nac=fecha_nac==null?"": fecha_nac;
        String distrito=request.getParameter("distrito");distrito=distrito==null?"": distrito;
        
        HttpSession session=request.getSession();
        session.setAttribute("dni", dni);
        session.setAttribute("nombre", nombre);
        session.setAttribute("apellido", apellidos);
        session.setAttribute("genero", genero);
        session.setAttribute("celular", celular);
        session.setAttribute("fecha_nac", fecha_nac);
        request.getRequestDispatcher("reg_persona.jsp").forward(request, response); 
        
        
        if(!nombre.equals("")&!apellidos.equals("")&!dni.equals("")&!genero.equals("")&!fecha_nac.equals("")){
        Persona persona=new Persona();
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDni(dni);
        persona.setGenero(genero);
        persona.setNCelular(celular);
        persona.setFechaNacimiento(fecha_nac);
        persona.setIdubigeo("");
        if(residenciadao.registrarpersona(persona)){          
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response); 
        }else{
          session.setAttribute("mensaje", "No se pudo registrar,Intente nuevamente");     
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response); 
        }
         }
        if(!region.equals("")){
          session.setAttribute("region", region);
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
        if(!distrito.equals("")){
          session.setAttribute("distrito", distrito);
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Destino</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Destino at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
