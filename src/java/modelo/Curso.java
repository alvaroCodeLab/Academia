package modelo;

import java.util.ArrayList;


public class Curso {
    
    // Atributos:
    
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private String nivelDificultad; // "Básico", "Intermedio", "Avanzado"
    private String categoria; // "Programación", "Diseño", "Marketing"
    private double costo;
    private String estado; // "Habilitado", "Deshabilitado"
    private ArrayList<Grupo> grupos; // Relación de clientela: Un curso tiene varios grupos
    
    // Contructores:
    
    public Curso(String nombre, String descripcion, int duracion, String nivelDificultad, String categoria, double costo, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nivelDificultad = nivelDificultad;
        this.categoria = categoria;
        this.costo = costo;
        this.estado = estado;
    }

    public Curso(int id, String nombre, String descripcion, int duracion, String nivelDificultad, String categoria, double costo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nivelDificultad = nivelDificultad;
        this.categoria = categoria;
        this.costo = costo;
        this.estado = estado;
    }
    
    
    
    // Getters:

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCosto() {
        return costo;
    }

    public String getEstado() {
        return estado;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DEL CURSO: " +
                       "\nID: " + this.id + 
                       "\nNombre: " + this.nombre +
                       "\nDescripcion: " + this.descripcion +
                       "\nDuracion: " + this.duracion +
                       "\nNivel de Dificultad: " + this.nivelDificultad +
                       "\nCategoria: " + this.categoria +
                       "\nCosto: " + this.costo +
                       "\nEstado: " + this.estado;
        return texto;
    }
  
}
