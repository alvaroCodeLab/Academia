/*
El CursoServlet es un controlador encargado de gestionar 
el registro de nuevos cursos en la aplicación.
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
import modelo.Curso;


public class CursoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");

        try {
            // Recoger los datos del curso:
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            String nivel = request.getParameter("nivel");
            String categoria = request.getParameter("categoria");
            double costo = Double.parseDouble(request.getParameter("costo"));
            String estado = request.getParameter("estado") != null ? "Habilitado" : "Deshabilitado";
        
            // Crear un nuevo objeto curso con los datos obtenidos:
            Curso curso = new Curso(nombre, descripcion, duracion, nivel, categoria, costo, estado);
        
            // Llamar al método para registrar el curso:
            boolean exito = bbdd.registrarCurso(curso);
        
            if (exito) {
                String mensaje = "Se ha registrado el curso correctamente.";
                objetoSesion.setAttribute("mensaje", mensaje);
                response.sendRedirect("./vistas/vistaMensaje.jsp");
            } else {
                String error = "No se ha podido registrar el curso.";
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
        
        } catch (SQLException e1) {
            String error = "Error al registrar el curso: " + e1.getMessage();
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
