package modelo;

import java.util.ArrayList;



public class Alumno {
    
    // Atributos:
    
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;
    private String direccion;
    private ArrayList<Grupo> grupos; // Relación de clientela: Un alumno puede estar en varios grupos
    
    // Constructores:
    
    public Alumno(String nombre, String apellidos, int edad, String email, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.direccion = direccion;
    }

    public Alumno(int id, String nombre, String apellidos, int edad, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.direccion = direccion;
    }

    public Alumno(int id, String nombre, String apellidos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
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

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DEL ALUMNO: " +
                       "\nID: " + this.id +
                       "\nNombre: " + this.nombre +
                       "\nApellidos: " + this.apellidos +
                       "\nEdad: " + this.edad +
                       "\nEmail: " + this.email +
                       "\nDireccion: " + this.direccion;
        return texto;
    }

}
