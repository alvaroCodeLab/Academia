<%-- 
JSP que contiene el catálogo de cursos y grupos disponibles de la academia.
--%>
<%@page import="modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- 🔥 CLAVE -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Catálogo de Cursos</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./vistas/estilos/estilosCatalogoCursos.css" rel="stylesheet">
</head>

<body>

<div class="container py-4">

    <h1 class="text-center mb-3">Catálogo de Cursos</h1>
    <p class="text-center mb-4">Aquí puedes consultar los cursos disponibles y sus descripciones.</p>

    <div class="row g-4">
        <%
            List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
            List<Integer> cursosMatriculados = (List<Integer>) request.getAttribute("cursosMatriculados");
        %>

        <% if (cursos != null && !cursos.isEmpty()) {
            for (Curso curso : cursos) {
                boolean yaMatriculado = cursosMatriculados != null && cursosMatriculados.contains(curso.getId());
        %>

        <!-- 🔥 Responsive real -->
        <div class="col-12 col-sm-6 col-lg-4">
            <div class="card h-100">

                <div class="card-body d-flex flex-column">

                    <h5 class="card-title"><%= curso.getNombre()%></h5>

                    <p class="card-text">
                        <strong>Descripción:</strong>
                        <%= curso.getDescripcion() != null ? curso.getDescripcion() : "No disponible"%>
                    </p>

                    <p class="card-text"><strong>Duración:</strong> <%= curso.getDuracion()%> horas</p>
                    <p class="card-text"><strong>Nivel:</strong> <%= curso.getNivelDificultad()%></p>
                    <p class="card-text"><strong>Categoría:</strong> <%= curso.getCategoria()%></p>
                    <p class="card-text"><strong>Costo:</strong> $<%= curso.getCosto()%></p>

                    <!-- 🔥 Empuja el botón abajo -->
                    <div class="mt-auto">

                        <% if (yaMatriculado) { %>
                            <div class="alert alert-danger mt-3">
                                Ya estás matriculado en este curso.
                            </div>
                        <% } else { %>

                        <form action="./CatalogoCursosServlet" method="post">
                            <input type="hidden" name="accion" value="verGrupos">
                            <input type="hidden" name="cursoId" value="<%= curso.getId()%>">

                            <button type="submit" class="btn btn-success w-100">
                                Ver grupos
                            </button>
                        </form>

                        <% } %>

                    </div>

                </div>
            </div>
        </div>

        <%  }
        } else { %>

        <div class="col-12">
            <div class="alert alert-warning text-center">
                No hay cursos disponibles en este momento.
            </div>
        </div>

        <% } %>
    </div>
</div>

<footer class="text-center mt-5">
    <p>&copy; 2025 Academia - Todos los derechos reservados.</p>
</footer>

</body>
</html>
