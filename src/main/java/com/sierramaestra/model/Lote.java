package com.sierramaestra.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "lote")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cerveza", nullable = false)
	private String cerveza;

	@Column(name = "cantidad_litros", nullable = false)
	private Integer cantidadLitros;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "notas")
	private String notas;

	@Column(name = "fecha_carga", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCarga;

	@Column(name = "fecha_vencimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaVencimiento;

	// Relación OneToMany con Barril
	@OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Barril> barriles;

	public Lote() {
		super();
	}
	
	

	/*public Lote(Long id, String cerveza, Integer cantidadLitros, String estado, String notas, Date fechaCarga,
			Date fechaVencimiento, List<Barril> barriles) {
		super();
		this.id = id;
		this.cerveza = cerveza;
		this.cantidadLitros = cantidadLitros;
		this.estado = estado;
		this.notas = notas;
		this.fechaCarga = fechaCarga;
		this.fechaVencimiento = fechaVencimiento;
		this.barriles = barriles;
	}*/



	public Lote(Long id, String cerveza, Integer cantidadLitros, String estado, String notas, Date fechaCarga,
			Date fechaVencimiento) {
		super();
		this.id = id;
		this.cerveza = cerveza;
		this.cantidadLitros = cantidadLitros;
		this.estado = estado;
		this.notas = notas;
		this.fechaCarga = fechaCarga;
		this.fechaVencimiento = fechaVencimiento;
		this.barriles = new ArrayList<>();
	}
	
	public void agregarBarril(Barril barril) {
        barriles.add(barril);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCerveza() {
		return cerveza;
	}

	public void setCerveza(String cerveza) {
		this.cerveza = cerveza;
	}

	public Integer getCantidadLitros() {
		return cantidadLitros;
	}

	public void setCantidadLitros(Integer cantidadLitros) {
		this.cantidadLitros = cantidadLitros;
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

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public List<Barril> getBarriles() {
		return barriles;
	}

	/*public void setBarriles(List<Barril> barriles) {
		this.barriles = barriles;
	}*/
	
	
}
