/*
El PanelProfesorServlet es un controlador encargado de obtener 
los grupos y alumnos de la base de datos y asignarlos como atributos de la sesión
para utilizarlos en agregarNotas.jsp.
 */
package controlador;

import dao.ConexionBBDD;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Alumno;
import modelo.Grupo;


public class PanelProfesorServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        // Recogo la acción del botónacción:
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("agregarNotas")) {
            
            try {
                // Obtener los grupos y alumnos de la base de datos:
                List<Grupo> grupos = bbdd.obtenerGrupos();
                List<Alumno> alumnos = bbdd.obtenerAlumnos();

                // Establecer los atributos para el JSP:
                request.setAttribute("grupos", grupos);
                request.setAttribute("alumnos", alumnos);

                // Redirigir a la vista de agregar notas:
                request.getRequestDispatcher("/vistas/agregarNotas.jsp").forward(request, response);
            } catch (SQLException e) {
                String error = "Error al obtener la lista de cursos y profesores: " + e.getMessage();
                objetoSesion.setAttribute("error", error);
                response.sendRedirect("./vistas/vistaError.jsp");
            }
            
        } else {
            response.sendRedirect("./vistas/salir.jsp");
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
