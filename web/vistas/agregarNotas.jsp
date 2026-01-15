<%-- 
JSP que contiene la inserción de notas para los alumnos matriculados.
--%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Grupos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vistas/estilos/estilosAgregarNotas.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <h1>Gestión de Notas</h1>
            <p>Asignación de notas a los alumnos de la academia.</p>
        </div>

        <div class="container mt-5">
            <h2 class="text-center mb-4">Registrar una Nueva Nota</h2>

            <!-- Mensaje de error o éxito -->
            <div class="alert alert-danger" role="alert" <%-- Solo se muestra si hay error --%>
                <% if (request.getAttribute("error") != null) { %>
                    <%= request.getAttribute("error") %>
                <% } %>
            </div>
            <div class="alert alert-success" role="alert" <%-- Solo se muestra si hay éxito --%>
                <% if (request.getAttribute("mensaje") != null) { %>
                    <%= request.getAttribute("mensaje") %>
                <% } %>
            </div>

            <form action="./NotasServlet" method="post">
                <!-- Selección del Grupo -->
                <div class="mb-3">
                    <label for="grupo" class="form-label">Grupo</label>
                    <select id="grupo" name="grupo" class="form-select" required>
                        <option value="" disabled selected>Seleccione un grupo</option>
                        <% List<Grupo> grupos = (List<Grupo>) request.getAttribute("grupos"); 
                           if (grupos != null) { 
                               for (Grupo grupo : grupos) { %>
                                   <option value="<%= grupo.getId() %>"><%= grupo.getHorario() %></option>
                        <%   } 
                           } else { %>
                               <option value="" disabled>No hay grupos disponibles</option>
                        <% } %>
                    </select>
                </div>

                <!-- Selección del Alumno -->
                <div class="mb-3">
                    <label for="alumno" class="form-label">Alumno</label>
                    <select id="alumno" name="alumno" class="form-select" required>
                        <option value="" disabled selected>Seleccione un alumno</option>
                        <% List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos"); 
                           if (alumnos != null) { 
                               for (Alumno alumno : alumnos) { %>
                                   <option value="<%= alumno.getId() %>"><%= alumno.getNombre() + " " + alumno.getApellidos() %></option>
                        <%   } 
                           } else { %>
                               <option value="" disabled>No hay alumnos disponibles</option>
                        <% } %>
                    </select>
                </div>

                <!-- Nota -->
                <div class="mb-3">
                    <label for="nota" class="form-label">Nota</label>
                    <input type="number" id="nota" name="nota" class="form-control" min="0" max="10" step="0.01" required>
                    <div class="form-text">Nota entre 0 y 10</div>
                </div>

                <!-- Botón de Registro -->
                <div class="text-center">
                    <button type="submit" class="btn btn-dark">Registrar Nota</button>
                </div>
            </form>
        </div> 
    </body>
</html>
