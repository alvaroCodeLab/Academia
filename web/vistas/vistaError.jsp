<%-- 
JSP para visualizar las páginas de errores.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de errores</title>
        <link href="./estilos/estilosError.css" rel="stylesheet">
    </head>
    <body>
        <div class="error-container">
            <h1>¡Ups! Ha ocurrido un error</h1>
            <%!String error;%>  
            <%error=(String)session.getAttribute("error");%>
            <h2><%= error%></h2> <!-- Mostramos el mensaje de error desde la sesión -->

            <div class="error-details">
                <p>Por favor, vuelve a intentarlo más tarde o contacta con el soporte si el problema persiste.</p>
            </div>

            <a href="../index.jsp" class="button">Volver a la página principal</a>
        </div>

        <div class="footer">
            <p>&copy; 2025 Proyecto Web - Todos los derechos reservados.</p>
        </div>
    </body>
</html>
