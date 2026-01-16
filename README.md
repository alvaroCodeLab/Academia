# Academia

[![Último commit](https://img.shields.io/github/last-commit/alvaroCodeLab/Academia?color=green)](https://github.com/alvaroCodeLab/Academia/commits/main)
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)](https://www.java.com/)
[![NetBeans](https://img.shields.io/badge/IDE-NetBeans-orange?logo=apache-netbeans&logoColor=white)](https://netbeans.apache.org/)
[![GitHub](https://img.shields.io/badge/GitHub-alvaroCodeLab-181717?logo=github&logoColor=white)](https://github.com/alvaroCodeLab)

---

## Descripción

**Academia** es un proyecto de gestión académica desarrollado en **Java** con **Servlets/JSP** y NetBeans IDE.  
Permite gestionar alumnos, profesores, cursos, grupos, matrículas y notas, con paneles personalizados según el tipo de usuario.

---

## Funcionalidades

- Gestión de alumnos, profesores y cursos
- Control de matrículas y grupos
- Registro de notas
- Login y paneles de administración para profesores y administradores
- Vistas personalizadas para alumnos

---

## Tecnologías

- **Java 8+**
- **Servlets y JSP**
- **NetBeans IDE**
- **GlassFish Server** (o servidor compatible)
- **CSS** para estilos
- **Base de datos JDBC** (MySQL u otra compatible)

---

## Estructura del proyecto

/src/java → Código fuente Java
/web → Archivos JSP y recursos (CSS, imágenes)
/web/WEB-INF → Configuración de la aplicación
/nbproject → Configuración de NetBeans
.gitignore → Archivos ignorados por Git


---

## Cómo ejecutar

1. Abrir el proyecto en **NetBeans IDE**.
2. Configurar la conexión a la base de datos en `src/java/dao/ConexionBBDD.java`.
3. Desplegar en **GlassFish** o servidor compatible.
4. Acceder a la aplicación mediante: `http://localhost:8080/Academia`.

---

## Contribuciones

Este proyecto es **personal y educativo**, pero se aceptan sugerencias mediante pull requests.

---

## Licencia

Uso personal y educativo.
