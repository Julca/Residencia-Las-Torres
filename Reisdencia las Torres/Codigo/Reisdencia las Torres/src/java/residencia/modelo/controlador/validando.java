/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import residencia.modelo.dao.usuariodao;
import residencia.modelo.daoimpl.usuariodaoimpl;
import residencia.modelo.entidad.Persona;
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
         
        usuariodao usuariodao=new usuariodaoimpl();
        String action = request.getParameter("action");
            action = action == null ? "" : action;
        String usuario=request.getParameter("users");usuario=usuario==null?"": usuario;
        String password=request.getParameter("password");password=password==null?"": password;
           if(usuariodao.validarusuario(usuario, password)!=null&&!usuariodao.validarusuario(usuario, password).equals("")){
             HttpSession session=request.getSession();
              session.setAttribute("idusuario",usuariodao.validarusuario(usuario, password));
              request.getRequestDispatcher("Pagina.jsp").forward(request, response);
             }else{
               request.setAttribute("mensaje","Usuario o contraseña incorrecto");
                request.getRequestDispatcher("index.jsp").forward(request, response);
           }
        
            if (action.equals("registrarusuario")) {
                Persona persona = new Persona();
            Usuario us = new Usuario();
            
            String nombre = request.getParameter("nombre");
            nombre = nombre == null ? "" : nombre;
            String apellidos = request.getParameter("apellido");
            apellidos = apellidos == null ? "" : apellidos;
            String dni = request.getParameter("dni");
            dni = dni == null ? "" : dni;
            String genero = request.getParameter("genero");
            genero = genero == null ? "" : genero;
            String celular = request.getParameter("celular");
            celular = celular == null ? "" : celular;
            String fecha_nac = request.getParameter("fecha_nac");
            fecha_nac = fecha_nac == null ? "" : fecha_nac;
            String usuarioreg = request.getParameter("usuarioreg");
            usuarioreg = usuarioreg == null ? "" : usuarioreg;
            String passwordreg = request.getParameter("passwordreg");
            passwordreg = passwordreg == null ? "" : passwordreg;
                us.setNombre(nombre);
                us.setApellidos(apellidos);
                us.setDni(dni);
                us.setGenero(genero);
                us.setCelular(celular);
                us.setFechaNacimiento(fecha_nac);
                us.setUsers(usuarioreg);
                us.setPassword(passwordreg);
                us.setIdusuario("");
                if (usuariodao.registrarusuario(us)) {
               request.setAttribute("mensaje","Se registro correctamente");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
               request.setAttribute("mensaje","No se pudo registrar");
                   request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
           
           
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet validando</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet validando at " + request.getContextPath() + "</h1>");
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
