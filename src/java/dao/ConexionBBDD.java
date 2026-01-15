/*
 * Clase para realizar todas las operaciones en la base de datos Academia.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.*;



public class ConexionBBDD {
    
    private String url;
    private String usuario;
    private String contraseña;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public ConexionBBDD() throws SQLException, ClassNotFoundException {
        
        // Cargar el driver para que Java y MySQL se entiendan
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Se otiene una conexión a la base de datos. Usurio root y sin contraseña
        this.url="jdbc:mysql://localhost:3306/academia";
        this.usuario="root";
        this.contraseña="";
        conexion = DriverManager.getConnection(url, usuario, contraseña);
        // Se crea un Statement, para realizar las acciones
        sentencia = conexion.createStatement();
        
    } 
    
    // Método para cerrar las conexiones a la base de datos
    public void cerrarConexiones() throws SQLException {
        resultado.close();
        sentencia.close();
        conexion.close();
    }
    
    // Método para registrar un nuevo usuario en la base de datos
    public boolean registrarUsuario(String email, String password, String role) throws SQLException  {
        boolean exito = false;
        String sql = "INSERT INTO usuarios (email, password, role) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros del SQL
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, role);
            
            // Ejecutar la inserción
            int filasAfectadas = stmt.executeUpdate();
            
            // Si se afectaron filas, el registro fue exitoso
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        
        return exito;
        
    }
    
    // Método para buscar el role y la contraseña encriptada de un usuario por su email
    public String[] buscarRoleYPassword(String email) throws SQLException {
        String sql = "SELECT role, password FROM usuarios WHERE email = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String role = rs.getString("role");
            String password = rs.getString("password");
            return new String[]{role, password};
        }

        return null; // Si no se encuentra el usuario
    }

    
    // Método para registrar un nuevo curso en la base de datos
    public boolean registrarCurso(Curso curso) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO cursos (nombre, descripcion, duracion, nivelDificultad, categoria, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setInt(3, curso.getDuracion());
            stmt.setString(4, curso.getNivelDificultad());
            stmt.setString(5, curso.getCategoria());
            stmt.setDouble(6, curso.getCosto());
            stmt.setString(7, curso.getEstado());
            
            // Ejecutar la inserción
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        return exito;
    }
    
    //Método para registrar un nuevo grupo en la base de datos:
    public boolean registrarGrupo (Grupo grupo) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO grupos (horario, maxAlumnos, curso, profesor) VALUES (?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros
            stmt.setString(1, grupo.getHorario());
            stmt.setInt(2, grupo.getMaxAlumnos());
            stmt.setInt(3, grupo.getCurso());
            stmt.setInt(4, grupo.getProfesor());
            
            // Ejecutar la inserción
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        return exito;
    }
    
    // Método para registrar un nuevo alumno en la base de datos:
    public boolean registrarAlumno (Alumno alumno) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO alumnos (nombre, apellidos, edad, email, direccion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidos());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getEmail());
            stmt.setString(5, alumno.getDireccion());
            
            // Ejecutar la insercion
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        return exito;
    }
    
    // Método para registrar un nuevo profesor en la base de datos:
    public boolean registrarProfesor (Profesor profesor) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO profesores (nombre, apellidos, especialidad, experiencia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros del SQL
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getEspecialidad());
            stmt.setInt(4, profesor.getExperiencia());
            
            // Ejecuto la inserción:
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        return exito;
    }
    
    // Método para obtener los cursos:
    public List<Curso> obtenerCursos() throws SQLException {
    List<Curso> cursos = new ArrayList<>();
    String sql = "SELECT * FROM cursos WHERE estado = 'Habilitado'"; // Asegúrate de que los cursos estén habilitados

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        resultado = stmt.executeQuery();

        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            int duracion = resultado.getInt("duracion");
            String nivelDificultad = resultado.getString("nivelDificultad");
            String categoria = resultado.getString("categoria");
            double costo = resultado.getDouble("costo");
            String estado = resultado.getString("estado");

            // Crear el objeto Curso con todos los atributos
            Curso curso = new Curso(id, nombre, descripcion, duracion, nivelDificultad, categoria, costo, estado);
            cursos.add(curso);
        }
    }
    return cursos;
}

    
    // Método para obtener los profesores:
    public List<Profesor> obtenerProfesores() throws SQLException {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos FROM profesores";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                profesores.add(new Profesor(id, nombre, apellidos));
            }
        }
        return profesores;
    }
    
    // Método para obtener el ID del alumno basado en el email
    public int obtenerIdAlumnoPorEmail(String email) throws SQLException {
        String sql = "SELECT id FROM alumnos WHERE email = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, email);

            resultado = stmt.executeQuery();

            if (resultado.next()) {
                return resultado.getInt("id");
            }
            return -1; // Si no se encuentra el alumno
        }
    }

    // Método para obtener las notas del alumno
    public List<Nota> obtenerNotasPorAlumno(int alumnoId) throws SQLException {
        List<Nota> notas = new ArrayList<>();

        String sql = "SELECT DISTINCT n.nota, c.nombre AS curso, g.horario, g.id AS grupo_id \n"
                + "FROM notas n \n"
                + "JOIN matriculas m ON n.grupo = m.grupo \n"
                + "JOIN grupos g ON n.grupo = g.id \n"
                + "JOIN cursos c ON g.curso = c.id \n"
                + "WHERE n.alumno = ?;";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, alumnoId);

            resultado = stmt.executeQuery();

            while (resultado.next()) {
                double nota = resultado.getDouble("nota");
                String curso = resultado.getString("curso");
                String horario = resultado.getString("horario");
                int grupoId = resultado.getInt("grupo_id");

                // Crear un objeto Nota y agregarlo a la lista
                Nota notaObj = new Nota(nota, curso, horario, grupoId);
                notas.add(notaObj);
            }
        }
        return notas;
    }
    
    // Método para obtener el ID del profesor basado en el email:
    public int obtenerIdProfesorPorEmail (String email) throws SQLException {
        String sql = "SELECT id FROM profesores WHERE email = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, email);
            
            resultado = stmt.executeQuery();
            
            if (resultado.next()) {
                return resultado.getInt("id");
            } else {
                return -1; // Si no se encuentra el profesor
            }
        }
    }

    // Método para obtener grupos de un determinado curso a través de su id:
    public List<Grupo> obtenerGruposPorCurso(int cursoId) throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String sql
                = "SELECT g.id, g.horario, g.maxAlumnos, g.curso, "
                + "       (SELECT COUNT(*) FROM matriculas m WHERE m.grupo = g.id) AS inscritos "
                + "FROM grupos g "
                + "WHERE g.curso = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cursoId);
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String horario = resultado.getString("horario");
                int maxAlumnos = resultado.getInt("maxAlumnos");
                int inscritos = resultado.getInt("inscritos");

                if (inscritos < maxAlumnos) {
                    Grupo grupo = new Grupo(id, horario, maxAlumnos, cursoId);
                    grupos.add(grupo);
                }
            }
        }
        return grupos;
    }


    
    public boolean registrarMatricula (int alumnoId, int grupoId) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO matriculas (alumno, grupo) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, alumnoId);
            stmt.setInt(2, grupoId);
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                exito = true;
            }
        }
        return exito;
    }
    
    // Método para obtener un alumno por su email:
    public Alumno obtenerAlumnoPorEmail(String email) throws SQLException {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE email = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar el parámetro del SQL
            stmt.setString(1, email);

            // Ejecutar la consulta
            resultado = stmt.executeQuery();

            // Si hay resultados, creamos el objeto Alumno
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                int edad = resultado.getInt("edad");
                String direccion = resultado.getString("direccion");

                // Crear el objeto Alumno con los datos obtenidos
                alumno = new Alumno(id, nombre, apellidos, edad, email, direccion);
            }
        }

        return alumno;
    }
    
    // Método para obtener un grupo por su ID:
    public Grupo obtenerGrupoPorId(int grupoId) throws SQLException {
        Grupo grupo = null;
        String sql = "SELECT * FROM grupos WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar el parámetro del SQL
            stmt.setInt(1, grupoId);

            // Ejecutar la consulta
            resultado = stmt.executeQuery();

            // Si hay resultados, creamos el objeto Grupo
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String horario = resultado.getString("horario");
                int maxAlumnos = resultado.getInt("maxAlumnos");
                int cursoId = resultado.getInt("curso");
                int profesorId = resultado.getInt("profesor");

                // Crear el objeto Grupo con los datos obtenidos
                grupo = new Grupo(id, horario, maxAlumnos, cursoId, profesorId);
            }
        }

        return grupo;
    }
    
    // Método para obtener los Ids de cursos en los que el alumno ya está matriculado:
    public List<Integer> obtenerCursosMatriculadosPorAlumno(int alumnoId) throws SQLException {
        List<Integer> cursosMatriculados = new ArrayList<>();
        String sql = "SELECT DISTINCT g.curso FROM matriculas m "
                + "JOIN grupos g ON m.grupo = g.id "
                + "WHERE m.alumno = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, alumnoId);
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                cursosMatriculados.add(resultado.getInt("curso"));
            }
        }

        return cursosMatriculados;
    }
    
    // Método para obtener los grupos
    public List<Grupo> obtenerGrupos() throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT g.id, g.horario, g.maxAlumnos, g.curso, g.profesor "
                + "FROM grupos g";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String horario = resultado.getString("horario");
                int maxAlumnos = resultado.getInt("maxAlumnos");
                int cursoId = resultado.getInt("curso");
                int profesorId = resultado.getInt("profesor");

                // Crear el objeto Grupo con los datos obtenidos
                Grupo grupo = new Grupo(id, horario, maxAlumnos, cursoId, profesorId);
                grupos.add(grupo);
            }
        }
        return grupos;
    }
    
    // Método para obtener los alumnos
    public List<Alumno> obtenerAlumnos() throws SQLException {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos, edad, email, direccion FROM alumnos";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                int edad = resultado.getInt("edad");
                String email = resultado.getString("email");
                String direccion = resultado.getString("direccion");

                // Crear el objeto Alumno con los datos obtenidos
                Alumno alumno = new Alumno(id, nombre, apellidos, edad, email, direccion);
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }


    // Método para registrar una nueva nota en la base de datos
    public boolean registrarNota(int alumnoId, int grupoId, double nota) throws SQLException {
        boolean exito = false;
        String sql = "INSERT INTO notas (alumno, grupo, nota) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Configurar los parámetros del SQL
            stmt.setInt(1, alumnoId);
            stmt.setInt(2, grupoId);
            stmt.setDouble(3, nota);

            // Ejecutar la inserción
            int filasAfectadas = stmt.executeUpdate();

            // Si se afectaron filas, el registro fue exitoso
            if (filasAfectadas > 0) {
                exito = true;
            }
        }

        return exito;
    }

    // Método para verificar la matricula de un alumno y su grupo correspondiente:
    public boolean verificarMatricula(int alumnoId, int grupoId) throws SQLException {
        String query = "SELECT COUNT(*) FROM matriculas WHERE alumno = ? AND grupo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, alumnoId);
            ps.setInt(2, grupoId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;  // Si el contador es mayor que 0, el alumno está matriculado
            }
        }
        return false;  // Si no se encontró la matrícula
    }


    // Método para obtener el total de cursos disponibles
    public int obtenerTotalCursos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM cursos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Devuelve el total de cursos
            }
        }
        return 0;
    }

    // Método para obtener el total de alumnos matriculados
    public int obtenerTotalAlumnosMatriculados() throws SQLException {
        String sql = "SELECT COUNT(DISTINCT alumno) FROM matriculas";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Devuelve el total de alumnos matriculados
            }
        }
        return 0;
    }

    // Método para obtener el total de profesores disponibles
    public int obtenerTotalProfesores() throws SQLException {
        String sql = "SELECT COUNT(*) FROM profesores";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Devuelve el total de profesores
            }
        }
        return 0;
    }


    

    
    
}
