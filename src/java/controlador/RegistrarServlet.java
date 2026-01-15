/*
El RegistrarServlet es un controlador encargado de gestionar 
el registro de nuevos usuarios en la aplicación.
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
import org.mindrot.jbcrypt.BCrypt;


public class RegistrarServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recoger los campos del formulario de registro:
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Asignamos "alumno" como rol por defecto
        String role = "alumno";
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        try {
            
            // Encriptar la contraseña con BCrypt
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // Crear una conexión a la base de datos:
            ConexionBBDD bbdd = new ConexionBBDD();
            
            // Almacenar la conexión en la sesión:
            objetoSesion.setAttribute("objetoBBDD", bbdd);
            
            // Llamar al método para registrar el usuario, pasamos la contraseña encriptada
            boolean exito = bbdd.registrarUsuario(email, hashedPassword, role);
            
            if (exito) {
                // Si el registro fue exitoso, enviar un mensaje de confirmación a la sesión
                objetoSesion.setAttribute("mensajeExito", "Registro exitoso. Ahora puedes iniciar sesión.");
                response.sendRedirect("./vistas/login.jsp");
            } else {
                response.sendRedirect("./vistas/registro.jsp");
            }
            
        } catch (SQLException e1) {
            String error = "Error al registrar el usuario: " + e1.getMessage();
            objetoSesion.setAttribute("error", error);
            response.sendRedirect("./vistas/vistaError.jsp");
        } catch (ClassNotFoundException e2) {
            String error = "Error de clase no encontrada: " + e2.getMessage();
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
