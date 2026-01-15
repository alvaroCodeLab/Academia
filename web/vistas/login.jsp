<%-- 
JSP que contendra el login de usuarios.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login de usuarios</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosLogin.css" rel="stylesheet">
    </head>
    <body>
        <div class="login-container">
            <h2>Iniciar sesión</h2>
            
            <!-- Mostrar mensaje de éxito si está disponible -->
            <% 
                String mensajeExito = (String) session.getAttribute("mensajeExito");
                if (mensajeExito != null) {
            %>
                <div class="alert alert-success" role="alert">
                    <%= mensajeExito %>
                </div>
                <% 
                    // Limpiar el mensaje de la sesión después de mostrarlo
                    session.removeAttribute("mensajeExito");
                }
            %>
            
            <form action="../LoginServlet" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">Correo electrónico</label>
                    <input type="email" name="email" id="email" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Contraseña</label>
                    <input type="password" name="password" id="password" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-custom">Iniciar sesión</button>
            </form>
            <a href="registro.jsp" class="forgot-password">¿Todavía no tienes cuenta? Registrate aquí.</a>
        </div>

        <!-- Enlace a Bootstrap JS y dependencias -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    </body>
</html>
