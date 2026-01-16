<%-- 
Página de inicio o página introductoria (pre-login) 
para dar la bienvenida a los usuarios antes de que inicien sesión en el sistema.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bienvenido a la Academia de Cursos</title>
        <!-- Enlace a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vistas/estilos/estilosIndex.css" rel="stylesheet">
    </head>
    <body>
        <!-- Encabezado -->
        <header class="bg-dark text-white text-center py-5">
            <h1 class="display-4">Academia de Cursos</h1>
            <p class="lead">Tu futuro comienza aquí</p>
            <!-- Imagen de encabezado -->
            <img src="./vistas/img/index.jpg" alt="Academia de Cursos" class="header-image">
        </header>

        <!-- Contenido principal -->
        <div class="container text-center my-5">
            <h2 class="display-5 mb-4">Bienvenido a nuestra Academia</h2>
            <p class="intro-text">En nuestra academia, ofrecemos una amplia variedad de cursos para ayudarte a mejorar tus habilidades. Ya sea que quieras aprender programación, diseño o marketing, tenemos algo para ti.</p>

            <p class="intro-text">Explora nuestros cursos y grupos disponibles para empezar tu camino hacia el éxito. Si ya eres alumno, inicia sesión para consultar tus grupos y notas. Si aún no tienes cuenta, ¡regístrate ahora!</p>

            <!-- Botones de acción -->
            <div class="d-flex justify-content-center mt-4">
                <a href="./vistas/login.jsp" class="main-button btn btn-primary">Iniciar sesión</a>
                <a href="./vistas/registro.jsp" class="secondary-button btn btn-info">Registrarse</a>
            </div>

            <!-- Tarjetas informativas -->
            <div class="row row-cols-1 row-cols-md-3 g-4 mt-5">
                <div class="col">
                    <div class="card card-custom">
                        <img src="./vistas/img/programacion.avif" class="card-img-top" alt="Curso de Programación">
                        <div class="card-body-custom">
                            <h5 class="card-title">Cursos de Programación</h5>
                            <p class="card-text">Aprende a programar desde cero con nuestros cursos interactivos.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-custom">
                        <img src="./vistas/img/diseño.avif" class="card-img-top" alt="Curso de Diseño">
                        <div class="card-body-custom">
                            <h5 class="card-title">Cursos de Diseño</h5>
                            <p class="card-text">Desarrolla tus habilidades creativas y aprende diseño gráfico.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-custom">
                        <img src="./vistas/img/marketing.jpg" class="card-img-top" alt="Curso de Marketing">
                        <div class="card-body-custom">
                            <h5 class="card-title">Cursos de Marketing</h5>
                            <p class="card-text">Conoce las estrategias más efectivas para promover tu negocio en línea.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer">
            <p>&copy; 2025 Academia de Cursos. Todos los derechos reservados.</p>
            <p><a href="#">Política de privacidad</a> | <a href="#">Términos y condiciones</a></p>
        </footer>

        <!-- Enlace a Bootstrap JS y dependencias -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    </body>
</html>



