<%-- 
JSP que contiene la parte de gestión de cursos de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Cursos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosGestionCursos.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <h1>Gestión de Cursos</h1>
            <p>Registro de nuevos cursos en la academia</p>
        </div>

        <div class="container mt-5">
            <h2 class="text-center mb-4">Registrar un Nuevo Curso</h2>
            <form action="../CursoServlet" method="post">
                <input type="hidden" name="accion" value="registrar">

                <!-- Nombre del Curso -->
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del Curso</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required>
                </div>

                <!-- Descripción -->
                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea id="descripcion" name="descripcion" class="form-control" rows="4" required></textarea>
                </div>

                <!-- Duración -->
                <div class="mb-3">
                    <label for="duracion" class="form-label">Duración (en horas)</label>
                    <input type="number" id="duracion" name="duracion" class="form-control" required>
                </div>

                <!-- Nivel de Dificultad -->
                <div class="mb-3">
                    <label for="nivel" class="form-label">Nivel de Dificultad</label>
                    <select id="nivel" name="nivel" class="form-select" required>
                        <option value="" disabled selected>Seleccione un nivel</option>
                        <option value="Basico">Básico</option>
                        <option value="Intermedio">Intermedio</option>
                        <option value="Avanzado">Avanzado</option>
                    </select>
                </div>

                <!-- Categoría -->
                <div class="mb-3">
                    <label for="categoria" class="form-label">Categoría</label>
                    <select id="categoria" name="categoria" class="form-select" required>
                        <option value="" disabled selected>Seleccione una categoría</option>
                        <option value="Programacion">Programación</option>
                        <option value="Diseno">Diseño</option>
                        <option value="Marketing">Marketing</option>
                    </select>
                </div>

                <!-- Costo -->
                <div class="mb-3">
                    <label for="costo" class="form-label">Costo (en €)</label>
                    <input type="number" step="0.01" id="costo" name="costo" class="form-control" required>
                </div>

                <!-- Estado del Curso -->
                <div class="mb-3 form-check">
                    <input type="checkbox" id="estado" name="estado" class="form-check-input" checked>
                    <label class="form-check-label" for="estado">Publicar Curso</label>
                </div>

                <!-- Botón de Registro -->
                <div class="text-center">
                    <button type="submit" class="btn btn-success">Registrar Curso</button>
                </div>
                
                
            </form>
        </div>
    </body>
</html>
