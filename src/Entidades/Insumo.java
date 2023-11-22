package Entidades;

import java.sql.Date;
import java.sql.Time;

public class Insumo {
    private String clave;
    private String nombre;
    private int cantidad;
    private String tipo;
    private Date fechaIngreso;
    private Time horaIngreso;
    private String claveEmpleado; // Clave foránea de EMPLEADO

    public Insumo() {

    }

    public Insumo(String clave, String nombre, int cantidad, String tipo, Date fechaIngreso, Time horaIngreso, String claveEmpleado) {
        this.clave = clave;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.claveEmpleado = claveEmpleado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Time getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Time horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }
}
