/*
El FormularioMatriculaServlet es un controlador encargado de obtener 
los datos de un alumno a partir de el email del usuario que inicia sesión
en la aplicación y pasar los mismos como atributo de la sesión.
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
import modelo.Alumno;
import modelo.Grupo;


public class FormularioMatriculaServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        // Recoger la acción del botón acción:
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("verFormularioMatricula")) {
            
            // Recoger el email del alumno desde la sesión:
            String email = (String) objetoSesion.getAttribute("email");
            
            if (email != null) {
                try {
                    // Obtener los datos del alumno por su email:
                    Alumno alumno = bbdd.obtenerAlumnoPorEmail(email);
                    
                    // Obtener el Id del grupo:
                    int grupoId = Integer.parseInt(request.getParameter("grupoId"));
                    Grupo grupo = bbdd.obtenerGrupoPorId(grupoId);
                    
                    // Pasar los datos al formulario:
                    request.setAttribute("alumno", alumno);
                    request.setAttribute("grupo", grupo);
                    
                    // Redirigir a la vista del formulario de matrícula:
                    request.getRequestDispatcher("./vistas/formularioMatricula.jsp").forward(request, response);
                    
                    
                } catch (SQLException e) {
                    String error = "Error al obtener los datos de la matricula: " + e.getMessage();
                    request.setAttribute("error", error);
                    response.sendRedirect("./vistas/vistaError.jsp");
                }
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
