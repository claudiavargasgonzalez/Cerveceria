package com.sierramaestra.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "barril")
public class Barril {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "litros", nullable = false)
    private Integer litros;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "notas")
    private String notas;

	public Barril(Long id, Integer litros, String estado, String notas) {
		super();
		this.id = id;
		this.litros = litros;
		this.estado = estado;
		this.notas = notas;
	}
    
    public Barril() {
    	
    }
    
    public Barril( Integer litros, String estado, String notas) {
		super();
		this.litros = litros;
		this.estado = estado;
		this.notas = notas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLitros() {
		return litros;
	}

	public void setLitros(Integer litros) {
		this.litros = litros;
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
    
}
