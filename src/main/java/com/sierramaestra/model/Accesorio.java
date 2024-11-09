package com.sierramaestra.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "accesorio")
public class Accesorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "notas")
    private String notas;

    // Relación ManyToOne con Lote
    @ManyToOne
    @JoinColumn(name = "barril_id")  // Crea la columna lote_id en la tabla barril para asociar barriles con un lote
    private Barril barril;

    // Constructores
    public Accesorio(Long id, String nombre, String estado, String notas, Barril barril) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.notas = notas;
        this.barril = barril;
    }

    public Accesorio() {
    }

    public Accesorio(String nombre, String estado, String notas) {
        this.nombre = nombre;
        this.estado = estado;
        this.notas = notas;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Barril getBarril() {
        return barril;
    }

    public void setBarril(Barril barril) {
        this.barril = barril;
    }
}
