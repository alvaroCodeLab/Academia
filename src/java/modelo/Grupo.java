package modelo;


public class Grupo {
    
    // Atributos:
    
    private int id;
    private String horario; // "Mañana", "Tarde"
    private int maxAlumnos;
    private int curso; // Relación con Curso (un grupo pertenece a un curso)
    private int profesor; // Relación con Profesor (un grupo tiene un profesor)
    
    // Constructores:
    
    public Grupo(String horario, int maxAlumnos, int curso, int profesor) {
        this.horario = horario;
        this.maxAlumnos = maxAlumnos;
        this.curso = curso;
        this.profesor = profesor;
    }
    
    public Grupo(int id, String horario, int maxAlumnos, int cursoId) {
        this.id = id;
        this.horario = horario;
        this.maxAlumnos = maxAlumnos;
        this.curso = cursoId;
    }

    public Grupo(int id, String horario, int maxAlumnos, int curso, int profesor) {
        this.id = id;
        this.horario = horario;
        this.maxAlumnos = maxAlumnos;
        this.curso = curso;
        this.profesor = profesor;
    }
    
    
    
    // Getters:

    public int getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public int getCurso() {
        return curso;
    }

    public int getProfesor() {
        return profesor;
    }
    
    // Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DEL GRUPO: " +
                       "\nID: " + this.id + 
                       "\nHorario: " + this.horario +
                       "\nMaxAlumnos: " + this.maxAlumnos +
                       "\nCurso: " + this.curso +
                       "\nProfesor: " + this.profesor;
        return texto;
    }

}
