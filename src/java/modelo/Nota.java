package modelo;

public class Nota {
    // Atributos
    
    private double nota;
    private String curso;
    private String horario;
    private int grupoId;

    //Constructor
    
    public Nota(double nota, String curso, String horario, int grupoId) {
        this.nota = nota;
        this.curso = curso;
        this.horario = horario;
        this.grupoId = grupoId;
    }

    // Getters y setters
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }
}
