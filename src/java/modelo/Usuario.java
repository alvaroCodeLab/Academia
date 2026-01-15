package modelo;


public class Usuario {
    
    // Atributos:
    
    private String email;
    private String password;
    private String role; // "administrador", "profesor", "alumno"
    
    // Constructor:

    public Usuario(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    // Getters:

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
    // Setters:

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    // Método toString():

    @Override
    public String toString() {
        String texto = "\nDATOS DEL USUARIO: " +
                       "\nEmail: " + this.email +
                       "\nRole: " + this.role;
        return texto;
    }
    
    
}
