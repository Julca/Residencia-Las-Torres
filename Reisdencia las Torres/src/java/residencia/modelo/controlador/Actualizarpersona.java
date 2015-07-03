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
import residencia.modelo.dao.personadao;
import residencia.modelo.daoimpl.personadaoimpl;
import residencia.modelo.entidad.Persona;

/**
 *
 * @author Leidy
 */
public class Actualizarpersona extends HttpServlet {

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
        
        personadao dao = new personadaoimpl();
        Persona persona=new Persona();
        String dni = request.getParameter("dni");
        dni = dni == null ? "" : dni;
        String nombre = request.getParameter("nombre");
        nombre = nombre == null ? "" : nombre;
        String apellido = request.getParameter("apellido");
        apellido = apellido == null ? "" : apellido;
        String celular = request.getParameter("celular");
        celular = celular == null ? "" : celular;
        String genero = request.getParameter("genero");
        genero = genero == null ? "" : genero;
        String fecha_nac = request.getParameter("fecha_nac");
        fecha_nac = fecha_nac == null ? "" : fecha_nac;
        String idpersona = request.getParameter("idpersona");
        idpersona = idpersona == null ? "" : idpersona;
        String idubigeo = request.getParameter("idubigeo");
        if(!idpersona.equals("")){
            persona.setIdPersona(idpersona);
            persona.setNombre(nombre);
            persona.setApellidos(apellido);
            persona.setDni(dni);
            persona.setGenero(genero);
            persona.setFechaNacimiento(fecha_nac);
            persona.setNCelular(celular);
            persona.setIdubigeo(idubigeo);
          if(dao.actualizarpersona(persona)){
            request.setAttribute("mensaje","Se actualizó");
              request.setAttribute("action", "buscando");
     request.setAttribute("persona", dao.buscarpersona(dni));
     request.getRequestDispatcher("busqueda.jsp").forward(request, response);
          }else{
              request.setAttribute("mensaje","No se actualizó");
              request.setAttribute("persona", dao.buscarpersona(dni));
              request.getRequestDispatcher("actualizar.jsp").forward(request, response);
          }
        }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Actualizarpersona</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Actualizarpersona at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
