/*
El MatriculaServlet es un controlador encargado de matricular
un determinado alumno en un curso y grupo determinado.
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


public class MatriculaServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recoger la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        // Recogo la acción del botón acción:
        String accion = request.getParameter("accion");
        
        // Obtener el email del alumno:
        String email = request.getParameter("email");
        
        if (accion.equalsIgnoreCase("realizarMatricula")) {
            try{
                //Obtener el Id del alumno basado en su email:
                int alumnoId = bbdd.obtenerIdAlumnoPorEmail(email);
                
                // Obtener el Id del grupo desde el formulario:
                int grupoId = Integer.parseInt(request.getParameter("grupoId"));
                
                // Registrar la matrícula en la base de datos:
                boolean matriculaExitosa = bbdd.registrarMatricula(alumnoId, grupoId);
                
                if (matriculaExitosa) {
                    // Si la matricula fue exitosa, redirigir a una página de éxito:
                    String mensaje = "Te has matriculado con éxito.";
                    objetoSesion.setAttribute("mensaje", mensaje);
                    response.sendRedirect("./vistas/vistaMensaje.jsp");
                } else {
                    String error = "No te has podido registrar.";
                    objetoSesion.setAttribute("error", error);
                    response.sendRedirect("./vistas/vistaError.jsp");
                    
                }
                
            } catch (SQLException e) {
                String error = "Se ha producido un error al intentar registrar la matrícula: " + e.getMessage();
                request.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
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
