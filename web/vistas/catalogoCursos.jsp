<%-- 
JSP que contiene el catálogo de cursos y grupos disponibles de la academia.
--%>
<%@page import="modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de Cursos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vistas/estilos/estilosCatalogoCursos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center">Catálogo de Cursos</h1>
            <p class="text-center">Aquí puedes consultar los cursos disponibles y sus descripciones.</p>

            <div class="row">
                <%
                    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
                    List<Integer> cursosMatriculados = (List<Integer>) request.getAttribute("cursosMatriculados");
                %>

                <% if (cursos != null && !cursos.isEmpty()) {
                        for (Curso curso : cursos) {
                            boolean yaMatriculado = cursosMatriculados != null && cursosMatriculados.contains(curso.getId());
                %>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><%= curso.getNombre()%></h5>
                            <p class="card-text">Descripción: <%= curso.getDescripcion() != null ? curso.getDescripcion() : "No disponible"%></p>
                            <p class="card-text">Duración: <%= curso.getDuracion()%> horas</p>
                            <p class="card-text">Nivel de Dificultad: <%= curso.getNivelDificultad()%></p>
                            <p class="card-text">Categoría: <%= curso.getCategoria()%></p>
                            <p class="card-text">Costo: $<%= curso.getCosto()%></p>

                            <% if (yaMatriculado) { %>
                            <div class="alert alert-danger mt-3">
                                Ya estás matriculado en este curso.
                            </div>
                            <% } else {%>
                            <form action="./CatalogoCursosServlet" method="post">
                                <input type="hidden" name="accion" value="verGrupos">
                                <input type="hidden" name="cursoId" value="<%= curso.getId()%>">
                                <button type="submit" class="btn btn-primary">Ver grupos</button>
                            </form>
                            <% } %>
                        </div>
                    </div>
                </div>
                <%    }
            } else { %>
                <div class="col-12">
                    <div class="alert alert-warning" role="alert">
                        No hay cursos disponibles en este momento.
                    </div>
                </div>
                <% }%>
            </div>
        </div>

        <footer class="text-center mt-5">
            <p>&copy; 2025 Academia - Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
