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
import residencia.modelo.dao.movimientodao;
import residencia.modelo.dao.personadao;
import residencia.modelo.daoimpl.movimientodaoimpl;
import residencia.modelo.daoimpl.personadaoimpl;

/**
 *
 * @author ulises
 */
public class Pago extends HttpServlet {

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
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        personadao personadao = new personadaoimpl();
        movimientodao dao = new movimientodaoimpl();
        String dni = request.getParameter("dni");
        dni = dni == null ? "" : dni;
        String dni1 = request.getParameter("dni1");
        dni1 = dni1 == null ? "" : dni1;
        String dni2 = request.getParameter("dni2");
        dni2 = dni2 == null ? "" : dni2;
        String monto = request.getParameter("monto");
        monto = monto == null ? "" : monto;
        String cancelar = request.getParameter("cancelar");
        cancelar = cancelar == null ? "" : cancelar;
        String glosa = request.getParameter("glosa");
        glosa = glosa == null ? "" : glosa;
        String codigo = request.getParameter("codigo");
        codigo = codigo == null ? "" : codigo;
        String idcontrato = request.getParameter("idcontrato");
        idcontrato = idcontrato == null ? "" : idcontrato;
        String tipomovimiento = request.getParameter("tipomovimiento");
        tipomovimiento = tipomovimiento == null ? "" : tipomovimiento;
        switch (action) {
            case "cancelar":
                request.getRequestDispatcher("pago.jsp").forward(request, response);
                break;
            case "buscar":
                request.setAttribute("dni", dni);
                request.setAttribute("inquilino", personadao.listardeuda(dni));
                request.getRequestDispatcher("pago.jsp").forward(request, response);
                break;
            case "cancelando":
                 
              request.setAttribute("dni", dni1);
                request.setAttribute("inquilino", personadao.listardeuda(dni1));
                request.setAttribute("action", action);
                request.setAttribute("idcontrato", idcontrato);
                request.setAttribute("tipomovimiento", dao.listartipo_movimiento());
                request.getRequestDispatcher("pago.jsp").forward(request, response);
            case "cancelado":
                if (!idcontrato.equals("") && !monto.equals("")) {
                    if (dao.registrarmovimiento(idcontrato, tipomovimiento, codigo, monto, glosa)) {
                    request.setAttribute("mensaje", "Se guardó la cancelacion correctamente");
                    }else{
                        request.setAttribute("mensaje", "No se guardó la cancelación ");
                    }
                   
                    request.setAttribute("inquilino", personadao.listardeuda(dni2));
                    request.getRequestDispatcher("pago.jsp").forward(request, response);
                    break;

                }
        }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Pago</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Pago at " + request.getContextPath() + "</h1>");
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
