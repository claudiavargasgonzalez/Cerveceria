package com.sierramaestra.model;

<<<<<<< HEAD
import java.time.LocalDate;

=======
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
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

<<<<<<< HEAD
=======
    @Column(name = "legajo", nullable = false, length = 50)
    private String legajo;

>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

<<<<<<< HEAD
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    // Constructor vacío
    public Cliente() {
        this.fechaRegistro = LocalDate.now(); // Se asigna la fecha actual por defecto
    }

    // Constructor completo
    public Cliente(Long id, String nombre, String apellido, String email, String dni, String direccion, String telefono, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
=======
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
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
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

<<<<<<< HEAD
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

=======
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

<<<<<<< HEAD
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
=======
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
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + "]";
    }
}

=======
        return "Usuario [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", tipo=" + tipo + ", activo=" + activo + "]";
    }
    
}
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
