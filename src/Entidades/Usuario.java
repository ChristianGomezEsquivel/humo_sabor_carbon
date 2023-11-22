package Entidades;

public class Usuario {
    private String nombre;
    private String password;
    private String claveEmpleado; // Clave foránea de EMPLEADO

    public Usuario() {
        
    }

    public Usuario(String nombre, String password, String claveEmpleado) {
        this.nombre = nombre;
        this.password = password;
        this.claveEmpleado = claveEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }
}