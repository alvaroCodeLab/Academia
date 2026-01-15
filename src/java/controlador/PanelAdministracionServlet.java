/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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


public class PanelAdministracionServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Crear o recuperar la sesión:
        HttpSession objetoSesion = request.getSession(true);

        // Recuperar la conexión a la base de datos:
        ConexionBBDD bbdd = (ConexionBBDD) objetoSesion.getAttribute("objetoBBDD");

        try {
            // Obtener estadísticas desde la base de datos
            int totalCursos = bbdd.obtenerTotalCursos();
            int totalAlumnosMatriculados = bbdd.obtenerTotalAlumnosMatriculados();
            int totalProfesores = bbdd.obtenerTotalProfesores();

            // Pasar los datos al JSP
            request.setAttribute("totalCursos", totalCursos);
            request.setAttribute("totalAlumnosMatriculados", totalAlumnosMatriculados);
            request.setAttribute("totalProfesores", totalProfesores);

            // Redirigir a la vista del panel de administración
            request.getRequestDispatcher("/vistas/panelAdministracion.jsp").forward(request, response);

        } catch (SQLException ex) {
            response.sendRedirect("/vistas/vistaError.jsp");
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
