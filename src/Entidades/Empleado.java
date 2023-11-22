/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author crist
 */

import java.sql.Date;

public class Empleado {
    private String clave;
    private String nombre;
    private String cargo;
    private Date fechaRegistro;
    private String email;

    public Empleado() {
        
    }

    public Empleado(String clave, String nombre, String cargo, Date fechaRegistro, String email) {
        this.clave = clave;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaRegistro = fechaRegistro;
        this.email = email;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

