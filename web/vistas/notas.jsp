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

    <!-- 🔥 imprescindible -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Mis Notas</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./vistas/estilos/estilosNotas.css" rel="stylesheet">
</head>

<body>

<div class="container py-4">

    <h2 class="text-center mb-4">Mis Notas</h2>

    <!-- 🔥 CLAVE: tabla responsive -->
    <div class="table-responsive">
        <table class="table table-striped align-middle">

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
                <% } %>
            </tbody>

        </table>
    </div>

</div>

</body>
</html>


