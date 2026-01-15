<%-- 
JSP que contiene la parte de gestión de profesores de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Profesores</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosGestionProfesores.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <h1>Gestión de Profesores</h1>
            <p>Registro y gestión de profesores de la academia</p>
        </div>
        
        <div class="container mt-5">
            <h2 class="text-center mb-4">Registrar un Nuevo Profesor</h2>
            <form action="../ProfesorServlet" method="post">
                <input type="hidden" name="accion" value="registrar">
                
                <!-- Nombre del Profesor -->
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del Profesor</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required>
                </div>
                
                <!-- Appellidos del Profesor -->
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos del Profesor</label>
                    <input type="text" id="apellidos" name="apellidos" class="form-control" required> 
                </div>
                
                <!-- Especialidad -->
                <div class="mb-3">
                    <label for="especialidad" class="form-label">Especialidad</label>
                    <input type="text" id="especialidad" name="especialidad" class="form-control" required> 
                </div>
                
                <!-- Experiencia -->
                <div class="mb-3">
                    <label for="esperiencia" class="form-label">Años de Experiencia</label>
                    <input type="number" id="experiencia" name="experiencia" class="form-control" required>
                </div>
                
                <!-- Botón de Registro -->
                <div class="text-center">
                    <button type="submit" class="btn btn-warning">Registrar Profesor</button>
                </div>
                
                
            </form>
        </div>
    </body>
</html>
