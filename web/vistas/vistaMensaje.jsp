<%-- 
JSP para visualizar las páginas con mensajes de éxito.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Operación Exitosa</title>
    <link href="./estilos/estilosMensaje.css" rel="stylesheet">
</head>
<body>
    <div class="success-container">
        <h1>¡Éxito! Operación completada correctamente</h1>
        <%!String mensaje;%>  
        <%mensaje = (String) session.getAttribute("mensaje");%>
        <h2><%= mensaje%></h2> <!-- Mostramos el mensaje de éxito desde la sesión -->

        <div class="success-details">
            <p>Gracias por tu acción. Si necesitas realizar otra operación, puedes hacerlo desde el menú.</p>
        </div>

        <a href="../index.jsp" class="button">Volver a la página principal</a>
    </div>

    <div class="footer">
        <p>&copy; 2025 Proyecto Web - Todos los derechos reservados.</p>
    </div>
</body>
</html>