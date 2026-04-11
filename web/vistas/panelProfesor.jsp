<%-- 
JSP que contiene el panel de profesores de la academia.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- 🔥 imprescindible -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Academia - Panel Profesor</title>

    <!-- Icono -->
    <link href="./vistas/img/favicom/website_icon.png" rel="icon" type="image/png">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="./estilos/estilosPanelProfesor.css" rel="stylesheet">
</head>

<body>

<header class="text-center py-4">
    <h1>Panel del Profesor</h1>
</header>

<div class="container text-center">

    <!-- Imagen responsive -->
    <img src="./img/fondo.jpg" alt="academia" class="img-fluid my-4">

    <!-- Formulario -->
    <form action="../PanelProfesorServlet" method="post" class="panel-form mx-auto">

        <button type="submit" name="accion" value="agregarNotas" class="btn btn-primary w-100">
            Poner Notas
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