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
import residencia.modelo.dao.habitaciondao;
import residencia.modelo.daoimpl.habitaciondaoimpl;

/**
 *
 * @author Leidy
 */
public class Habitaciones extends HttpServlet {

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
        habitaciondao dao=new habitaciondaoimpl();
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        String idhabitacion = request.getParameter("idhabitacion");
        idhabitacion = idhabitacion == null ? "" : idhabitacion;
        String habitacion = request.getParameter("habitacion");
        habitacion = habitacion == null ? "" : habitacion;
        switch(action){
            case "habitacion":
                request.setAttribute("action",action);
                request.setAttribute("habitaciones", dao.listarhabitacionesdisponibles());
                request.getRequestDispatcher("Habitaciones.jsp").forward(request, response);
                break;
                case "inquilino":
                request.setAttribute("action", "listar");
                request.setAttribute("habitacion", habitacion);
                request.setAttribute("persona",dao.listarpersonasporhabitacion(idhabitacion));
                request.getRequestDispatcher("Habitaciones.jsp").forward(request, response);
                break;
                    case "habitaciondis":
                request.setAttribute("action",action);
                request.setAttribute("habitaciones", dao.listarhabitacionesdisponibles());
                request.getRequestDispatcher("Habitaciones.jsp").forward(request, response);
                break;
                    
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
