/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencia.modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import residencia.modelo.dao.personadao;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.daoimpl.personadaoimpl;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.entidad.Persona;

/**
 *
 * @author ulises
 */
public class Reportes extends HttpServlet {

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
    
    String action = request.getParameter("action");
    action = action == null ? "" : action;
    String dni = request.getParameter("dni");
    dni = dni == null ? "" : dni;
    String fecha = request.getParameter("fecha");
    fecha = fecha == null ? "" : fecha;
    
    
    
    if(action.equals("inquilinos")){
     request.setAttribute("action", action);
     request.setAttribute("personashospedadas", dao.listarpersonashospedadas());
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("debe")){
     request.setAttribute("action", action);
     request.setAttribute("deudainquilino", dao.deudadelinquilino());
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("deudor")){
     request.setAttribute("action", action);
     request.setAttribute("elmasdeudor", dao.elmasdudor());
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("menosdeudor")){
     request.setAttribute("action", action);
     request.setAttribute("menosdeudor", dao.elmenosdeudor());
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
     
    if(action.equals("estado")){
     request.setAttribute("action", action);
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("mostrarestado")){
     Persona lista=dao.buscarpersona(dni);
     request.setAttribute("action", "estado");
     request.setAttribute("action1", "mostrando");
     request.setAttribute("inquilino", dao.buscarpersona(dni));
     request.setAttribute("estadodecuenta", dao.estadodecuenta(lista.getIdPersona()));
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("buscar")){
     request.getRequestDispatcher("busqueda.jsp").forward(request, response);
    }
    if(action.equals("buscando")){
     request.setAttribute("action", action);
     request.setAttribute("persona", dao.buscarpersona(dni));
     request.getRequestDispatcher("busqueda.jsp").forward(request, response);
    }
    if(action.equals("actualizar")){
        if(!dni.equals("")){
        request.setAttribute("persona", dao.buscarpersona(dni));
     request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }else{
             request.getRequestDispatcher("busqueda.jsp").forward(request, response);
        }
    }
    if(action.equals("mes")){
     request.setAttribute("action", "mes");
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    if(action.equals("deudamensual")){
     request.setAttribute("action", "mes");
     request.setAttribute("mes",fecha);
     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
    }
    
    
    
//    if(action.equals("estado")){
//     request.setAttribute("action", action);
//     request.setAttribute("estado", dao);
//     request.getRequestDispatcher("Inquilinos.jsp").forward(request, response);
//    }
    
    
    
    
    
//    String mes = request.getParameter("mes");
//    mes = mes == null ? "" : mes;
//    String nombre = request.getParameter("nombre");
//    nombre = nombre == null ? "" : nombre;
//    String apellido = request.getParameter("apellido");
//    apellido = apellido == null ? "" : apellido;
//    String dni = request.getParameter("dni");
//    dni = dni == null ? "" : dni;
//    String celular = request.getParameter("celular");
//    celular = celular == null ? "" : celular;
//    String genero = request.getParameter("genero");
//    genero = genero == null ? "" : genero;
//    String fecha_nac = request.getParameter("fecha_nac");
//    fecha_nac = fecha_nac == null ? "" : fecha_nac;
//    String idpersona = request.getParameter("idpersona");
//    idpersona = idpersona == null ? "" : idpersona;
//    String idubigeo = request.getParameter("idubigeo");
//    idubigeo = idubigeo == null ? "" : idubigeo;
//    if (buscar.equals("guardar") && !nombre.equals("") && !apellido.equals("") && !dni.equals("") && !genero.equals("") && !celular.equals("")
//            && !fecha_nac.equals("") && !idpersona.equals("")) {
//        Persona persona = new Persona();
//        persona.setApellidos(apellido);
//        persona.setNombre(nombre);
//        persona.setDni(dni);
//        persona.setGenero(genero);
//        persona.setNCelular(celular);
//        persona.setFechaNacimiento(fecha_nac);
//        persona.setIdPersona(idpersona);
//        persona.setIdubigeo(idubigeo);
//        if (dao.actualizarpersona(persona)) {
//            response.sendRedirect("Inquilinos.jsp?buscar=inquilinos");
//        } else {
//            response.sendRedirect("Inquilinos.jsp?buscar=guardar");
//        }
//    }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Reportes</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Reportes at " + request.getContextPath() + "</h1>");
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
