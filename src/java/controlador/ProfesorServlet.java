/*
El ProfesorServlet es un controlador encargado de gestionar 
el registro de nuevos profesores en la aplicación.
 */
package controlador;

import dao.ConexionBBDD;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Profesor;


public class ProfesorServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        try {
            // Recoger los datos del profesor:
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String especialidad = request.getParameter("especialidad");
            int experiencia = Integer.parseInt(request.getParameter("experiencia"));
            
            // Crear un objeto profesor:
            Profesor profesor = new Profesor(nombre, apellidos, especialidad, experiencia);
            
            // Llamar al método para registrar el profesor:
            boolean exito = bbdd.registrarProfesor(profesor);
            
            if (exito) {
                String mensaje = "El profesor se ha registrado correctamente.";
                objetoSesion.setAttribute("mensaje", mensaje);
                response.sendRedirect("./vistas/vistaMensaje.jsp");
            } else {
                String error = "No se ha podido registrar el rpofesor.";
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
            
        } catch (SQLException e) {
            String error = "Error al registrar el profesor: " + e.getMessage();
            objetoSesion.setAttribute("error", error);
            response.sendRedirect("./vistas/vistaError.jsp");
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
