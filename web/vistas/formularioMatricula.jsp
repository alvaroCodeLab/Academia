<%-- 
JSP que contiene el formulario para formalizar la matrícula.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="modelo.Alumno, modelo.Grupo" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Matrícula</title>
    <!-- Enlace a Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./vistas/estilos/estilosFormularioMatricula.css" rel="stylesheet">
</head>
<body>
    <h1>Formulario de Matrícula</h1>

    <!-- Verifica si hay un alumno y un grupo en el contexto -->
    <% 
        Alumno alumno = (Alumno) request.getAttribute("alumno");
        Grupo grupo = (Grupo) request.getAttribute("grupo");
    %>

    <form action="./MatriculaServlet" method="POST">
        <input type="hidden" name="accion" value="realizarMatricula">

        <!-- Datos del alumno -->
        <h2>Datos del Alumno</h2>
        <div>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= alumno.getNombre() %>" readonly>
        </div>
        <div>
            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" value="<%= alumno.getApellidos() %>" readonly>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= alumno.getEmail() %>" readonly>
        </div>
        <div>
            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" value="<%= alumno.getDireccion() %>" readonly>
        </div>

        <!-- Datos del grupo -->
        <h2>Grupo</h2>
        <div>
            <label for="grupo">Grupo:</label>
            <input type="text" id="grupo" name="grupo" value="<%= grupo.getHorario() + " - Max Alumnos: " + grupo.getMaxAlumnos() %>" readonly>
        </div>
        <input type="hidden" name="grupoId" value="<%= grupo.getId() %>">



        <!-- Botón para matricular -->
        <div>
            <button type="submit">Matricularme</button>
        </div>
    </form>

</body>
</html>

