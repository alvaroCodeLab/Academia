/*
El AlumnoServlet es un controlador encargado de gestionar 
el registro de nuevos alumnos en la aplicación.
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


public class AlumnoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        try {
            // Recoger los datos del alumno:
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String email = request.getParameter("email");
            String direccion = request.getParameter("direccion");
            
            // Crear un nuevo objeto alumno:
            Alumno alumno = new Alumno(nombre, apellidos, edad, email, direccion);
            
            // Llamar al método para registrar el alumno:
            boolean exito = bbdd.registrarAlumno(alumno);
            
            if (exito) {
                String mensaje = "Se ha registrado el alumno correctamente.";
                objetoSesion.setAttribute("mensaje", mensaje);
                response.sendRedirect("./vistas/vistaMensaje.jsp");
            } else {
                String error = "No se ha podido registrar el alumno.";
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
            
            
        } catch (SQLException e) {
            String error = "Error al registrar el alumno: " + e.getMessage();
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
