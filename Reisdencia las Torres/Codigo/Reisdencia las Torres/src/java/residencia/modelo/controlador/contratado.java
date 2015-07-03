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
import residencia.modelo.dao.contratodao;
import residencia.modelo.dao.personadao;
import residencia.modelo.daoimpl.contratodaoimpl;
import residencia.modelo.daoimpl.personadaoimpl;

/**
 *
 * @author ulises
 */
public class contratado extends HttpServlet {

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
        personadao personadao = new personadaoimpl();
        contratodao contratodao = new contratodaoimpl();
        String buscardni = request.getParameter("dnibuscar");
        buscardni = buscardni == null ? "" : buscardni;
        
        String buscardni1 = request.getParameter("dnibuscar1");
        buscardni1 = buscardni1 == null ? "" : buscardni1;
        String buscardniapo = request.getParameter("buscardniapo");
        buscardniapo = buscardniapo == null ? "" : buscardniapo;
        String inicio = request.getParameter("inicio");
        inicio = inicio == null ? "" : inicio;
        String idpersona = request.getParameter("idpersona");
        idpersona = idpersona == null ? "" : idpersona;
        String salida = request.getParameter("salida");
        salida = salida == null ? "" : salida;
        String num_habita = request.getParameter("habitacion");
        num_habita = num_habita == null ? "" : num_habita;
        String ocupacion = request.getParameter("ocupacion");
        ocupacion = ocupacion == null ? "" : ocupacion;
        String institucion = request.getParameter("institucion");
        institucion = institucion == null ? "" : institucion;
        String precio_actual = request.getParameter("precio_actual");
        precio_actual = precio_actual == null ? "" : precio_actual;
        String idapoderado = request.getParameter("idapoderado");
        idapoderado = idapoderado == null ? "" : idapoderado;
        String idusuario = request.getParameter("idusuario");
        idusuario = idusuario == null ? "" : idusuario;
        request.getAttribute("dnibuscar");
        if (!buscardni.equals("")) {
                request.setAttribute("opcion1", "buscarinquilino");
                request.setAttribute("persona", personadao.buscarpersona(buscardni));
                request.getRequestDispatcher("contrato.jsp").forward(request, response);
             
        }
        if (!buscardniapo.equals("")) {
            if (personadao.buscarpersona(buscardniapo) != null && !personadao.buscarpersona(buscardniapo).equals("")) {
                request.setAttribute("opcion1", "buscarinquilino");
                request.setAttribute("opcion2", "buscarapoderado");
                request.setAttribute("apoderado", personadao.buscarpersona(buscardniapo));
                request.setAttribute("persona", personadao.buscarpersona(buscardni1));
                request.getRequestDispatcher("contrato.jsp").forward(request, response);
            } else {
                request.setAttribute("opcion2", "buscarapoderado");
                request.setAttribute("opcion1", "buscarinquilino");
                request.setAttribute("mensaje", "apoderadonoencontrado");
                request.setAttribute("persona", personadao.buscarpersona(buscardni1));
                request.getRequestDispatcher("contrato.jsp").forward(request, response);
            }
        }
        if (!inicio.equals("") && !salida.equals("") && !num_habita.equals("") && !idpersona.equals("") && !idusuario.equals("")) {
            if (contratodao.contrato(precio_actual, idpersona, inicio, salida, num_habita, idusuario, ocupacion, institucion, idapoderado)) {
                request.setAttribute("mensaje1", "Su contrato se realizó correctamente");
                request.getRequestDispatcher("contrato.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje1", "No se realizó el contrato");
                request.getRequestDispatcher("contrato.jsp").forward(request, response);
            }
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
