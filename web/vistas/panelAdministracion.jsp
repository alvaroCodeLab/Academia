<%-- 
JSP que contiene el panel de administración de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Administración</title>
        
        <!-- Icono del sitio web -->
        <link href="./vistas/img/favicom/website_icon.png" rel="website icon" type="png">
        
        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap Icons -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Estilos propios -->
        <link href="./vistas/estilos/estilosPanelAdministracion.css" rel="stylesheet">
    </head>
    <body>

        <!-- Navbar superior -->
        <nav class="navbar navbar-dark bg-primary fixed-top shadow-sm">
            <div class="container-fluid">
                <span class="navbar-brand fw-bold">
                    <i class="bi bi-mortarboard-fill me-2"></i> Academia de Cursos
                </span>
                <span class="text-white small">
                    Panel de Administración
                </span>
                <!-- Botón cerrar sesión -->
                <form action="./vistas/salir.jsp" method="post" class="m-0">
                    <button type="submit" class="btn btn-outline-light btn-sm">
                        <i class="bi bi-box-arrow-right me-1"></i> Cerrar sesión
                    </button>
                </form>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">

                <!-- Sidebar -->
                <aside class="col-md-3 col-lg-2 sidebar">
                    <ul class="nav flex-column mt-4">
                        <li class="nav-item">
                            <a class="nav-link active" href="./vistas/gestionCursos.jsp">
                                <i class="bi bi-journal-bookmark-fill me-2"></i> Gestión de Cursos
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="GestionarGruposServlet">
                                <i class="bi bi-people-fill me-2"></i> Gestión de Grupos
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./vistas/gestionAlumnos.jsp">
                                <i class="bi bi-person-lines-fill me-2"></i> Gestión de Alumnos
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./vistas/gestionProfesores.jsp">
                                <i class="bi bi-person-badge-fill me-2"></i> Gestión de Profesores
                            </a>
                        </li>
                    </ul>
                </aside>

                <!-- Contenido principal -->
                <main class="col-md-9 col-lg-10 ms-sm-auto px-4 main-content">

                    <div class="pt-4 pb-3">
                        <h1 class="fw-bold">Panel de Administración</h1>
                        <p class="text-muted">Resumen general del estado de la academia</p>
                    </div>

                    <div class="row g-4">

                        <!-- Cursos -->
                        <div class="col-md-4">
                            <div class="stat-card bg-success text-white">
                                <div class="icon">
                                    <i class="bi bi-book-fill"></i>
                                </div>
                                <div>
                                    <h3><%= request.getAttribute("totalCursos")%></h3>
                                    <span>Cursos activos</span>
                                </div>
                            </div>
                        </div>

                        <!-- Alumnos -->
                        <div class="col-md-4">
                            <div class="stat-card bg-info text-white">
                                <div class="icon">
                                    <i class="bi bi-people-fill"></i>
                                </div>
                                <div>
                                    <h3><%= request.getAttribute("totalAlumnosMatriculados")%></h3>
                                    <span>Alumnos matriculados</span>
                                </div>
                            </div>
                        </div>

                        <!-- Profesores -->
                        <div class="col-md-4">
                            <div class="stat-card bg-warning text-dark">
                                <div class="icon">
                                    <i class="bi bi-person-workspace"></i>
                                </div>
                                <div>
                                    <h3><%= request.getAttribute("totalProfesores")%></h3>
                                    <span>Profesores</span>
                                </div>
                            </div>
                        </div>

                    </div>

                </main>
            </div>
        </div>
                                    
    </body>
    
</html>

