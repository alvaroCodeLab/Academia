package modelo;

import java.util.ArrayList;


public class Profesor {
    
    // Atributos: 
   
    private int id;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private int experiencia;
    private ArrayList<Grupo> grupos; // Relación de clientela: Un profesor puede tener varios grupos
    
    // Constructores:
    
    public Profesor(String nombre, String apellidos, String especialidad, int experiencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }
    
    public Profesor(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    // Getters:

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    
    // Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DEL PROFESOR: " +
                       "\nID: " + this.id +
                       "\nNombre: " + this.nombre +
                       "\nApellidos: " + this.apellidos +
                       "\nEspecialidad: " + this.especialidad +
                       "\nExperiencia: " + this.experiencia;
        return texto;
    }

}
