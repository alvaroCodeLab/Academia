/*
El CatalogoCursosServlet es un controlador encargado de recoger 
el Id de un determinado curso y pasar como atributos de la sesión
los grupos del mismo.
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
import modelo.Grupo;


public class CatalogoCursosServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);
        
        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");
        
        // Recoger la acción del botón acción:
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("verGrupos")) {
            try {
                // Recoger el Id del curso:
                int cursoId = Integer.parseInt(request.getParameter("cursoId"));

                // Obtener los grupos de ese curso:
                List<Grupo> grupos = bbdd.obtenerGruposPorCurso(cursoId);

                // Verificar que la lista de grupos no sea nula:
                if (grupos != null && !grupos.isEmpty()) {
                    request.setAttribute("grupos", grupos);
                    // Pasar el Id del curso a la vista
                    request.setAttribute("cursoId", cursoId);
                } else {
                    String mensaje = "No hay grupos disponibles para este curso.";
                    request.setAttribute("mensaje", mensaje);
                }

                // Redirigir a la vista donde se muestran los grupos:
                request.getRequestDispatcher("./vistas/gruposCurso.jsp").forward(request, response);

            } catch (SQLException e) {
                String error = "Error al intentar obtener los grupos: " + e.getMessage();
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
