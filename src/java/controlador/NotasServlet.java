/*
El NotasServlet es un controlador encargado de registrar 
las notas de un determinado alumno y grupo de la academia.
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



public class NotasServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recuperamos la sesión activa
        HttpSession objetoSesion = request.getSession(true);
        // Recuperamos el objeto de conexión a la base de datos desde la sesión
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");

        try {
            // Recuperamos los parámetros recibidos desde el formulario
            String grupoStr = request.getParameter("grupo");
            String alumnoStr = request.getParameter("alumno");
            String notaStr = request.getParameter("nota");

            // Validación de que los parámetros no sean nulos
            if (grupoStr == null || alumnoStr == null || notaStr == null) {
                objetoSesion.setAttribute("error", "Por favor, complete todos los campos.");
                response.sendRedirect("./vistas/vistaError.jsp");
                return;
            }

            // Convertimos los parámetros a tipos adecuados
            int grupoId = Integer.parseInt(grupoStr);
            int alumnoId = Integer.parseInt(alumnoStr);
            double nota = Double.parseDouble(notaStr);

            // Verificamos si el alumno está matriculado en el grupo
            boolean isMatriculado = bbdd.verificarMatricula(alumnoId, grupoId);

            if (!isMatriculado) {
                // Si el alumno no está matriculado, redirigimos a la página de error
                objetoSesion.setAttribute("error", "El alumno no está matriculado en este grupo.");
                response.sendRedirect("./vistas/vistaError.jsp");
                return;
            }

            // Intentamos registrar la nota en la base de datos
            boolean resultado = bbdd.registrarNota(alumnoId, grupoId, nota);

            if (resultado) {
                // Si la inserción es exitosa, redirigimos a la página de éxito
                String mensaje = "Nota registrada correctamente.";
                objetoSesion.setAttribute("mensaje", mensaje);
                response.sendRedirect("./vistas/vistaMensaje.jsp");
            } else {
                // Si no se pudo registrar la nota, redirigimos a la página de error
                String error = "No se pudo registrar la nota.";
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }

        } catch (SQLException e) {
            // En caso de error de SQL, redirigimos con un mensaje de error
            String error = "Error al registrar la nota: " + e.getMessage();
            objetoSesion.setAttribute("error", error);
            response.sendRedirect("./vistas/vistaError.jsp");
        } catch (NumberFormatException e) {
            // En caso de que los datos no sean válidos (por ejemplo, si no son números)
            String error = "Formato de los datos incorrecto. Por favor, ingrese valores válidos.";
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
