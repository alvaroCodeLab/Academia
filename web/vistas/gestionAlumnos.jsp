<%-- 
JSP que contiene la parte de gestión de alumnos de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Alumnos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosGestionAlumnos.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <h1>Gestión de Alumnos</h1>
            <p>Registro y gestión de alumnos en la academia</p>
        </div>
        
        <div class="container mt-5">
            <h2 class="text-center mb-4">Registrar un Nuevo Alumno</h2>
            <form action="../AlumnoServlet" method="post">
                <input type="hidden" name="accion" value="registrar">
                
                <!-- Nombre del Alumno -->
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del Alumno</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required>
                </div>
                
                <!-- Apellidos del Alumno -->
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos del Alumno</label>
                    <input type="text" id="apellidos" name="apellidos" class="form-control" required>
                </div>
                
                <!-- Edad -->
                <div class="mb-3">
                    <label for="edad" class="form-label">Edad</label>
                    <input type="number" id="edad" name="edad" class="form-control" required>
                </div>
                
                <!-- Email -->
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control" required>      
                </div>
                
                <!-- Dirección -->
                <div class="mb-3">
                    <label for="direccion" class="form-label">Dirección</label>
                    <input type="text" id="direccion" name="direccion" class="form-control" required>
                </div>
                
                <!-- Botón de registro -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Registrar Alumno</button>
                </div>
                
                
            </form>
        </div>
    </body>
</html>
