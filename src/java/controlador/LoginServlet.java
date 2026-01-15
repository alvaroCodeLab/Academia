/*
El LoginServlet es un controlador encargado de gestionar 
el login de los usuarios en la aplicación.
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


public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recoger los parámetros de entrada (email y password) del formulario de login
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);

        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        if (bbdd == null) {
            try {
                bbdd = new ConexionBBDD();
                objetoSesion.setAttribute("objetoBBDD", bbdd);
            } catch (SQLException e1) {
                String error = "Error al validar el usuario: " + e1.getMessage();
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            } catch (ClassNotFoundException e2) {
                String error = "Error de clase no encontrada: " + e2.getMessage();
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
        }
        
        try {
            // Buscar el role y la contraseña encriptada del usuario en la base de datos:
            String[] usuario = bbdd.buscarRoleYPassword(email); // Suponiendo que este método devuelve un array de dos elementos: [role, hashedPassword]

            if (usuario != null) {
                String role = usuario[0];
                String hashedPassword = usuario[1];

                // Verificar si la contraseña proporcionada coincide con la almacenada:
                if (BCrypt.checkpw(password, hashedPassword)) {

                    objetoSesion.setAttribute("email", email);

                    // Si el usuario es válido, redirigir según su role:
                    if (role.equals("administrador")) {
                        response.sendRedirect("./PanelAdministracionServlet");
                    } else if (role.equals("profesor")) {
                        response.sendRedirect("./vistas/panelProfesor.jsp");
                    } else {
                        response.sendRedirect("./vistas/panelAlumno.jsp");
                    }
                } else {
                    // Si la contraseña no coincide
                    String error = "Email o contraseña incorrectos.";
                    objetoSesion.setAttribute("error", error);
                    response.sendRedirect("./vistas/vistaError.jsp");
                }
            } else {
                // Si no se encuentra el usuario:
                String error = "Email o contraseña incorrectos.";
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
        } catch (SQLException e3) {
            String error = "Error al buscar el role de usuario: " + e3.getMessage();
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
