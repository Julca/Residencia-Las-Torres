 
package residencia.modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.entidad.Usuario;

/**
 *
 * @author ulises
 */
public class validando extends HttpServlet {

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
        residenciadao usuariodao=new residenciadaoimpl();
        String mensaje="noexiste";
        String usuario=request.getParameter("users");usuario=usuario==null?"": usuario;
        String password=request.getParameter("password");password=password==null?"": password;
           if(usuariodao.validarusuario(usuario, password)!=null&&!usuariodao.validarusuario(usuario, password).equals("")){
              HttpSession session=request.getSession();
              session.setAttribute("idusuario",usuariodao.validarusuario(usuario, password));
              request.getRequestDispatcher("Pagina.jsp").forward(request, response);
             }else{
               HttpSession session=request.getSession();
               session.setAttribute("buscar", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
           }
             
    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validando</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validando at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
