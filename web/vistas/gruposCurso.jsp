<%-- 
JSP que muestra los grupos disponibles para cada curso del catálogo.
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- 🔥 CLAVE -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Grupos del Curso</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./vistas/estilos/estilosGruposCurso.css" rel="stylesheet">
</head>

<body>

<div class="container py-4">

    <h1 class="text-center mb-3">Grupos disponibles</h1>
    <p class="text-center mb-4">Consulta los grupos disponibles para este curso.</p>

    <div class="row g-4">

        <%
            List<Grupo> grupos = (List<Grupo>) request.getAttribute("grupos");
            if (grupos != null && !grupos.isEmpty()) {
                for (Grupo grupo : grupos) {
        %>

        <!-- 🔥 Responsive real -->
        <div class="col-12 col-sm-6 col-lg-4">
            <div class="card h-100">

                <div class="card-body d-flex flex-column">

                    <h5 class="card-title">Grupo #<%= grupo.getId() %></h5>

                    <p class="card-text">
                        <strong>Horario:</strong> <%= grupo.getHorario() %>
                    </p>

                    <p class="card-text">
                        <strong>Capacidad:</strong> <%= grupo.getMaxAlumnos() %> alumnos
                    </p>

                    <!-- Botón abajo -->
                    <div class="mt-auto">
                        <form action="./FormularioMatriculaServlet" method="post">
                            <input type="hidden" name="accion" value="verFormularioMatricula">
                            <input type="hidden" name="grupoId" value="<%= grupo.getId()%>">

                            <button type="submit" class="btn btn-success w-100">
                                Matricularse
                            </button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <%
                }
            } else {
        %>

        <div class="col-12">
            <div class="alert alert-warning text-center">
                No hay grupos disponibles para este curso.
            </div>
        </div>

        <% } %>

    </div>
</div>

</body>
</html>
