<%-- 
JSP que contiene el panel de alumnos de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia - Inicio</title>
        
        <!-- Icono del panel de alumnos -->
        <link href="./vistas/img/favicom/website_icon.png" rel="website icon" type="png">
        
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./estilos/estilosPanelAlumno.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <br>
            <br>
            <h1>Bienvenido a la Academia</h1>
            <br>
            <br>
        </header>
        
        <img src="./img/fondo3.jpg" alt="academia" width="300">
        
        <form action="../PanelAlumnoServlet" method="post">
            <button type="submit" name="accion" value="consultaCursos">Consulta de Cursos</button>
            <br>
            <br>
            <button type="submit" name="accion" value="misNotas">Mis Notas</button> 
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
