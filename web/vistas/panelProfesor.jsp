<%-- 
JSP que contiene el panel de profesores de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia - Inicio</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosPanelProfesor.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <br>
            <br>
            <h1>Bienvenido a la Academia</h1>
            <br>
            <br>
        </header>
        
        <img src="./img/fondo.jpg" alt="academia" width="300">
        
        <form action="../PanelProfesorServlet" method="post">
            <button type="submit" name="accion" value="agregarNotas">Poner Notas</button> 
            <br>
            <br>
            <button type="submit" name="accion" value="salir">Salir de la Aplicación</button>
            <br>
            <br>
        </form>
        
        <section>
            <p>Selecciona una opción del menú para continuar.</p>
        </section>
    </body>
</html>