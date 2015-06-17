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
import residencia.modelo.dao.residenciadao;
import residencia.modelo.daoimpl.residenciadaoimpl;
import residencia.modelo.entidad.Persona1;

/**
 *
 * @author ulises
 */
public class apoderado extends HttpServlet {

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
        HttpSession session=request.getSession();
        String dni=request.getParameter("dni");dni=dni==null?"": dni;

         if(!dni.equals("")){      
          session.setAttribute("dni", dni);
          request.getRequestDispatcher("registrar_apoderado.jsp").forward(request, response); 
        }
        String idapoderado=request.getParameter("nombrea");idapoderado=idapoderado==null?"":idapoderado;
        String nombre=request.getParameter("nombrea");nombre=nombre==null?"":nombre;
        String apellidos=request.getParameter("apellidoa");apellidos=apellidos==null?"": apellidos;
        String dnia=request.getParameter("dnia");dnia=dnia==null?"": dnia;
        String genero=request.getParameter("generoa");genero=genero==null?"": genero;
        String celular=request.getParameter("celulara");celular=celular==null?"": celular;
        String fecha_nac=request.getParameter("fecha_naca");fecha_nac=fecha_nac==null?"": fecha_nac;
        if(!nombre.equals("")&!apellidos.equals("")&!dnia.equals("")&!genero.equals("")&!fecha_nac.equals("")){
        Persona1 persona=new Persona1();
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDni(dnia);
        persona.setGenero(genero);
        persona.setNCelular(celular);
        persona.setFechaNacimiento(fecha_nac);
        persona.setIdubigeo("");
        if(residenciadao.registrarpersona(persona)){
        for(Persona1 pers:residenciadao.buscarpersonasinprocedencia(dnia)){
         idapoderado=pers.getIdPersona();
         }
         session.setAttribute("dnia", dnia);
         session.setAttribute("idapoderado", idapoderado);  
         request.getRequestDispatcher("registrar_apoderado.jsp").forward(request, response); 
        }else{
         session.setAttribute("mensaje", "No se pudo registrar, ingrese nuevamente");     
         request.getRequestDispatcher("registrar_apoderado.jsp").forward(request, response); 
        }
        }
        
        String regiona=request.getParameter("regiona");regiona=regiona==null?"": regiona;

        if(!regiona.equals("")){
          session.setAttribute("regiona", regiona);
          request.getRequestDispatcher("registrar_apoderado.jsp").forward(request, response);
        }
        String distrito=request.getParameter("distritoa");distrito=distrito==null?"": distrito;
        if(!distrito.equals("")){
          session.setAttribute("distritoa", distrito);
          request.getRequestDispatcher("registrar_apoderado.jsp").forward(request, response);
        }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet apoderado</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet apoderado at " + request.getContextPath() + "</h1>");
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
