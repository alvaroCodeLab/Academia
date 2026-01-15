package modelo;



public class Matricula {
    
    // Atributos:
    
    private int id;
    private Alumno alumno;
    private Grupo grupo;

    // Constructor:

    public Matricula(int id, Alumno alumno, Grupo grupo) {
        this.id = id;
        this.alumno = alumno;
        this.grupo = grupo;
    }
    
    // Getters:

    public int getId() {
        return id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    
    // Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DE LA MATRICULA: " +
                       "\nID: " + this.id +
                       "\nAlumno: " + this.alumno +
                       "\nGrupo: " + this.grupo;
        return texto;
    }

}
