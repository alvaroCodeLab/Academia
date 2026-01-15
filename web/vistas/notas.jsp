<%-- 
JSP que contiene las notas de los alumnos de la academia.
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Nota"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mis Notas</title>
    <!-- Enlace a Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./vistas/estilos/estilosNotas.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Mis Notas</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Curso</th>
                    <th>Horario</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Nota> notas = (List<Nota>) request.getAttribute("notas");
                    if (notas != null && !notas.isEmpty()) {
                        // Bucle para mostrar las notas
                        for (Nota nota : notas) {
                %>
                <tr>
                    <td><%= nota.getCurso()%></td>
                    <td><%= nota.getHorario()%></td>
                    <td><%= nota.getNota()%></td>
                </tr>
                <%
                    }
                } else { 
                %>
                <tr>
                    <td colspan="3" class="no-notas">No tienes notas registradas.</td>
                </tr>
                <% }%> 
            </tbody>
        </table>
    </div>
</body>
</html>


