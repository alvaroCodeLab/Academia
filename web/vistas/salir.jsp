<%-- 
JSP que contiene el cierre de conexión a la base de datos y la invalidación de sesión del usuario.
--%>

<%@page import="dao.ConexionBBDD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acaddemia - Salir</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosSalir.css" rel="stylesheet">
            
    </head>
    <body>
        <header>
            <br>
            <br>
            <h1>Hasta Pronto</h1>
            <br>
            <br>
        </header>
        
        <img src="./img/fondo2.webp" alt="academia" width="500">
        <br>
        <br>
            <center>
                <h1> Gracias por tu visita </h1>
            </center>
        <br>
        <br>
        <% ConexionBBDD bbdd=(ConexionBBDD) session.getAttribute("objetoBBDD");
           if (bbdd!=null) {
                //cerramos todas las conexiones
                bbdd.cerrarConexiones();
           }
           //invalidar la sesion
           session.invalidate();
        %>
    </body>
</html>
