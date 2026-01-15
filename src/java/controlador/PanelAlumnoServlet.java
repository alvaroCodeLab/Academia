/*
El PanelAlumnoServlet es un controlador encargado de obtener 
los cursos de la base de datos y asignarlos como atributos de la sesión
para utilizarlos en catalogoCursos.jsp.
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
import modelo.Curso;
import modelo.Nota;


public class PanelAlumnoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        // Recogo la acción del botón acción:
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("consultaCursos")) {
            try {
                List<Curso> cursos = bbdd.obtenerCursos();
                String email = (String) objetoSesion.getAttribute("email");
                int alumnoId = bbdd.obtenerIdAlumnoPorEmail(email);

                List<Integer> cursosMatriculados = bbdd.obtenerCursosMatriculadosPorAlumno(alumnoId);

                if (cursos != null && !cursos.isEmpty()) {
                    request.setAttribute("cursos", cursos);
                    request.setAttribute("cursosMatriculados", cursosMatriculados);
                } else {
                    request.setAttribute("mensaje", "No hay cursos disponibles en este momento.");
                }

                request.getRequestDispatcher("./vistas/catalogoCursos.jsp").forward(request, response);

            } catch (SQLException ex) {
                response.sendRedirect("./vistas/vistaError.jsp");
            }
        } else if (accion.equalsIgnoreCase("misNotas")) {

            // Recuperar el email del alumno desde la sesión
            String email = (String) objetoSesion.getAttribute("email");

            try {
                // Obtener el ID del alumno basado en su email
                int alumnoId = bbdd.obtenerIdAlumnoPorEmail(email);

                // Obtener las notas, curso y grupo del alumno
                List<Nota> notas = bbdd.obtenerNotasPorAlumno(alumnoId);

                // Pasar las notas al JSP
                request.setAttribute("notas", notas);

                // Redirigir a la vista de notas
                request.getRequestDispatcher("./vistas/notas.jsp").forward(request, response);

            } catch (SQLException e) {
                // En caso de error con la base de datos, redirigir a una vista de error
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
