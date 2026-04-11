<%-- 
JSP que contiene el panel de alumnos de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <!-- 🔥 CLAVE para responsive -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Academia - Inicio</title>

    <link href="./vistas/img/favicom/website_icon.png" rel="icon" type="image/png">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./estilos/estilosPanelAlumno.css" rel="stylesheet">
</head>

<body>

<header class="text-center py-4">
    <h1>Bienvenido a la Academia</h1>
</header>

<div class="container text-center">

    <!-- Imagen responsive -->
    <img src="./img/fondo3.jpg" alt="academia" class="img-fluid my-4">

    <!-- Formulario -->
    <form action="../PanelAlumnoServlet" method="post" class="panel-form mx-auto">

        <button type="submit" name="accion" value="consultaCursos" class="btn btn-primary w-100">
            Consulta de Cursos
        </button>

        <button type="submit" name="accion" value="misNotas" class="btn btn-primary w-100">
            Mis Notas
        </button>

        <button type="submit" name="accion" value="salir" class="btn btn-danger w-100">
            Salir de la Aplicación
        </button>

    </form>

    <section class="mt-4">
        <p>Selecciona una opción del menú para continuar.</p>
    </section>

</div>

</body>
</html>
