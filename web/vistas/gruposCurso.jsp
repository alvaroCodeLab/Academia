<%-- 
JSP que muestra los grupos disponibles para cada curso del catálogo.
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Grupos del Curso</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Grupos disponibles</h1>
        <p class="text-center">Aquí puedes consultar los grupos disponibles para este curso.</p>

        <div class="row">
            <%
                List<Grupo> grupos = (List<Grupo>) request.getAttribute("grupos");
                if (grupos != null && !grupos.isEmpty()) {
                    for (Grupo grupo : grupos) {
            %>
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Grupo: <%= grupo.getId() %></h5>
                        <p class="card-text">Horario: <%= grupo.getHorario() %></p>
                        <p class="card-text">Capacidad máxima: <%= grupo.getMaxAlumnos() %> alumnos</p>
                        <form action="./FormularioMatriculaServlet" method="post">
                            <input type="hidden" value="verFormularioMatricula" name="accion">
                            <input type="hidden" name="grupoId" value="<%= grupo.getId()%>">
                            <button type="submit" class="btn btn-success">Matricularse</button>
                        </form>

                    </div>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <div class="col-12">
                <div class="alert alert-warning" role="alert">
                    No hay grupos disponibles para este curso.
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>

