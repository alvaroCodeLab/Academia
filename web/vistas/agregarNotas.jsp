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
    <meta charset="UTF-8">

    <!-- 🔥 CLAVE -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Gestión de Notas</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./vistas/estilos/estilosAgregarNotas.css" rel="stylesheet">
</head>

<body>

<header class="text-center py-4">
    <h1>Gestión de Notas</h1>
    <p>Asignación de notas a los alumnos</p>
</header>

<div class="container d-flex justify-content-center">

    <div class="form-container w-100">

        <h2 class="text-center mb-4">Registrar una Nueva Nota</h2>

        <!-- ✅ Solo se muestran si existen -->
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger text-center">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <% if (request.getAttribute("mensaje") != null) { %>
            <div class="alert alert-success text-center">
                <%= request.getAttribute("mensaje") %>
            </div>
        <% } %>

        <form action="./NotasServlet" method="post">

            <!-- Grupo -->
            <div class="mb-3">
                <label for="grupo" class="form-label">Grupo</label>
                <select id="grupo" name="grupo" class="form-select" required>
                    <option value="" disabled selected>Seleccione un grupo</option>

                    <%
                        List<Grupo> grupos = (List<Grupo>) request.getAttribute("grupos");
                        if (grupos != null) {
                            for (Grupo grupo : grupos) {
                    %>
                        <option value="<%= grupo.getId() %>">
                            <%= grupo.getHorario() %>
                        </option>
                    <%  }
                        } else { %>
                        <option disabled>No hay grupos disponibles</option>
                    <% } %>
                </select>
            </div>

            <!-- Alumno -->
            <div class="mb-3">
                <label for="alumno" class="form-label">Alumno</label>
                <select id="alumno" name="alumno" class="form-select" required>
                    <option value="" disabled selected>Seleccione un alumno</option>

                    <%
                        List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");
                        if (alumnos != null) {
                            for (Alumno alumno : alumnos) {
                    %>
                        <option value="<%= alumno.getId() %>">
                            <%= alumno.getNombre() + " " + alumno.getApellidos() %>
                        </option>
                    <%  }
                        } else { %>
                        <option disabled>No hay alumnos disponibles</option>
                    <% } %>
                </select>
            </div>

            <!-- Nota -->
            <div class="mb-3">
                <label for="nota" class="form-label">Nota</label>
                <input type="number" id="nota" name="nota"
                       class="form-control"
                       min="0" max="10" step="0.01" required>
                <div class="form-text">Nota entre 0 y 10</div>
            </div>

            <!-- Botón -->
            <button type="submit" class="btn btn-primary w-100">
                Registrar Nota
            </button>

        </form>

    </div>
</div>

</body>
</html>
