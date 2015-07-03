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
import residencia.modelo.dao.personadao;
import residencia.modelo.dao.residenciadao;
import residencia.modelo.daoimpl.personadaoimpl;
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
            personadao personadao=new personadaoimpl();
        String dni=request.getParameter("dni");dni=dni==null?"": dni;
        String nombre=request.getParameter("nombre");nombre=nombre==null?"":nombre;
        String apellidos=request.getParameter("apellido");apellidos=apellidos==null?"": apellidos;
        String genero=request.getParameter("genero");genero=genero==null?"": genero;
        String celular=request.getParameter("celular");celular=celular==null?"": celular;
        String fecha_nac=request.getParameter("fecha_nac");fecha_nac=fecha_nac==null?"": fecha_nac;
        
        if(!nombre.equals("")&!apellidos.equals("")&!dni.equals("")&!genero.equals("")&!fecha_nac.equals("")){
        Persona persona=new Persona();
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDni(dni);
        persona.setGenero(genero);
        persona.setNCelular(celular);
        persona.setFechaNacimiento(fecha_nac);
        persona.setIdubigeo("");
        if(personadao.registrarpersona(persona)){
            request.setAttribute("dni",dni);
          request.setAttribute("opcion", "procedencia");
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response); 
        }else{
          request.setAttribute("mensaje", "No se pudo registrar,Intente nuevamente");     
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response); 
        }
         }
        
        
        
        
//        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet registro</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet registro at " + request.getContextPath() + "</h1>");
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
        personadao personadao=new personadaoimpl();
        String region=request.getParameter("region");region=region==null?"": region;
        String region1=request.getParameter("region1");region1=region1==null?"": region1;
        String region2=request.getParameter("region2");region2=region2==null?"": region2;
        String provincia = request.getParameter("provincia");provincia = provincia == null ? "" : provincia;
        String provincia1 = request.getParameter("provincia1");provincia1 = provincia1 == null ? "" : provincia1;
        String distrito=request.getParameter("distrito");distrito=distrito==null?"": distrito;
        String distrito1=request.getParameter("distrito1");distrito1=distrito1==null?"": distrito1;
        String guardar = request.getParameter("guardar");guardar = guardar == null ? "" : guardar;
        String otros = request.getParameter("otros"); otros = otros == null ? "" : otros;
        String dni1=request.getParameter("dni1");dni1=dni1==null?"": dni1;
        String dni2=request.getParameter("dni2");dni2=dni2==null?"": dni2;
        String dni3=request.getParameter("dni3");dni3=dni3==null?"": dni3;
        String dni4=request.getParameter("dni4");dni4=dni4==null?"": dni4;
        
        if(!region.equals("")){
            request.setAttribute("dni", dni1);
          request.setAttribute("region", region);
          request.setAttribute("opcion", "procedencia");
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
        if(!provincia.equals("")){
            request.setAttribute("dni", dni2);
          request.setAttribute("region", region1);
          request.setAttribute("provincia", provincia);
          request.setAttribute("opcion", "procedencia");
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
        if(!distrito.equals("")){
          request.setAttribute("dni", dni3);
          request.setAttribute("region", region2);
          request.setAttribute("provincia", provincia1);
          request.setAttribute("distrito", distrito);
          request.setAttribute("opcion", "procedencia");
          request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
        
        if (guardar.equals("guardar")) {
        
        String idpersona="";
        String dni="";
        String nombre="";
        String apellidos="";
        String genero="";
        String celular="";
        String fecha_nac="";
        
        Persona pers= personadao.buscarpersonasinprocedencia(dni4);
            idpersona = pers.getIdPersona();
            nombre = pers.getNombre();
            apellidos = pers.getApellidos();
            celular = pers.getNCelular();
            fecha_nac = pers.getFechaNacimiento();
            dni = pers.getDni();
        Persona persona1 = new Persona();
        persona1.setIdPersona(idpersona);
        persona1.setNombre(nombre);
        persona1.setApellidos(apellidos);
        persona1.setDni(dni);
        persona1.setNCelular(celular);
        persona1.setFechaNacimiento(fecha_nac);
        persona1.setIdubigeo(distrito1);
        if (personadao.actualizarpersona(persona1)) {
            if(personadao.buscarpersona(dni)!=null&&!personadao.buscarpersona(dni).equals("")){
            request.setAttribute("opcion1","buscarinquilino");
            request.setAttribute("persona", personadao.buscarpersona(dni));
            request.getRequestDispatcher("contrato.jsp").forward(request, response);
        }else{
             request.setAttribute("opcion1","buscarinquilino");
            request.setAttribute("mensaje","noencontrado");
            request.getRequestDispatcher("contrato.jsp").forward(request, response); 
            }
        }else {
            request.getRequestDispatcher("reg_persona.jsp").forward(request, response);
        }
        
    }
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
