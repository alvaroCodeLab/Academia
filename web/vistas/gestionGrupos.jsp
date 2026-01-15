<%-- 
JSP que contiene la parte de gestión de grupos de la academia.
--%>

<%@page import="modelo.Profesor"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Grupos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vistas/estilos/estilosGestionGrupos.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <h1>Gestión de Grupos</h1>
            <p>Asignación de grupos y profesores a los cursos de la academia</p>
        </div>

        <div class="container mt-5">
            <h2 class="text-center mb-4">Registrar un Nuevo Grupo</h2>
            <form action="./GrupoServlet" method="post">
                

                <!-- Selección del Curso -->
                <div class="mb-3">
                    <label for="curso" class="form-label">Curso</label>
                    <select id="curso" name="curso" class="form-select" required>
                        <option value="" disabled selected>Seleccione un curso</option>
                        <!-- Cargar cursos dinámicamente -->
                        <%
                            List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
                            if (cursos != null) {
                                for (Curso curso : cursos) {
                        %>
                        <option value="<%= curso.getId()%>"><%= curso.getNombre()%></option>
                        <%
                            }
                        } else {
                        %>
                        <option value="" disabled>No hay cursos disponibles</option>
                        <%
                            }
                        %>

                    </select>
                </div>

                <!-- Selección del Horario -->
                <div class="mb-3">
                    <label for="horario" class="form-label">Horario</label>
                    <select id="horario" name="horario" class="form-select" required>
                        <option value="" disabled selected>Seleccione un horario</option>
                        <option value="Manana">Mañana</option>
                        <option value="Tarde">Tarde</option>
                    </select>
                </div>

                <!-- Límite de Alumnos -->
                <div class="mb-3">
                    <label for="maxAlumnos" class="form-label">Máximo de Alumnos</label>
                    <input type="number" id="maxAlumnos" name="maxAlumnos" class="form-control" required>
                </div>

                <!-- Selección del Profesor -->
                <div class="mb-3">
                    <label for="profesor" class="form-label">Profesor</label>
                    <select id="profesor" name="profesor" class="form-select" required>
                        <option value="" disabled selected>Seleccione un profesor</option>
                        <!-- Cargar profesores dinámicamente -->
                        <%
                            List<Profesor> profesores = (List<Profesor>) request.getAttribute("profesores");
                            if (profesores != null) {
                                for (Profesor profesor : profesores) {
                        %>
                        <option value="<%= profesor.getId()%>"><%= profesor.getNombre()%> <%= profesor.getApellidos() %></option>
                        <%
                            }
                        } else {
                        %>
                        <option value="" disabled>No hay profesores disponibles</option>
                        <%
                            }
                        %>

                    </select>
                </div>

                <!-- Botón de Registro -->
                <div class="text-center">
                    <button type="submit" class="btn btn-danger">Registrar Grupo</button>
                </div>
                
                
            </form>
        </div> 
    </body>
</html>
