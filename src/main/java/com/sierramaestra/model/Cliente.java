package com.sierramaestra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "legajo", nullable = false, length = 50)
    private String legajo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "activo", nullable = false)
    private boolean activo;

	

    // Constructor vacío
    public Cliente() {

    }

    // Constructor completo
    public Cliente(Long id, String legajo, String nombre, String apellido, String dni, String email, String tipo, boolean activo) {
        this.id = id;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.tipo = tipo;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

       public String getEstadoActivo() {
        return this.activo ? "Activo" : "Inactivo";
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", tipo=" + tipo + ", activo=" + activo + "]";
    }
    
}