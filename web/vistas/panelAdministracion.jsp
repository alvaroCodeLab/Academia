<%-- 
JSP que contiene el panel de administración de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Administración</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vistas/estilos/estilosPanelAdministracion.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">Academia de Cursos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block sidebar bg-dark">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link text-white" href="./vistas/gestionCursos.jsp">
                                    Gestión de Cursos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="GestionarGruposServlet">
                                    Gestión de Grupos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="./vistas/gestionAlumnos.jsp">
                                    Gestión de Alumnos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="./vistas/gestionProfesores.jsp">
                                    Gestión de Profesores
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <h1 class="h2">Bienvenido al Panel de Administración</h1>
                    <p>Aquí puedes gestionar todos los aspectos de la academia.</p>
                    <hr>
                    <h2>Estadísticas</h2>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card text-white bg-success mb-3">
                                <div class="card-header">Cursos Activos</div>
                                <div class="card-body">
                                    <h5 class="card-title"><%= request.getAttribute("totalCursos") %></h5>
                                    <p class="card-text">Número total de cursos disponibles.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card text-white bg-info mb-3">
                                <div class="card-header">Alumnos Matriculados</div>
                                <div class="card-body">
                                    <h5 class="card-title"><%= request.getAttribute("totalAlumnosMatriculados") %></h5>
                                    <p class="card-text">Total de alumnos matriculados en cursos.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card text-white bg-warning mb-3">
                                <div class="card-header">Profesores</div>
                                <div class="card-body">
                                    <h5 class="card-title"><%= request.getAttribute("totalProfesores") %></h5>
                                    <p class="card-text">Número de profesores disponibles.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        
    </body>
</html>

