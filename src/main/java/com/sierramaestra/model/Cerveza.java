package com.sierramaestra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cervezas")
public class Cerveza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre",nullable = false, length = 50)
	private String nombreCerveza;
	@Column(name="tipo",nullable = false, length = 30)
	private String tipoCerveza;
	@Column(name="grado alcoholico", nullable=false)
	private Double gradoAlcoholico;
	@Column(name="amargor IBU", nullable=false)
	private Double amargorIbu;
	@Column(name="descripcion", nullable=true)
	private String descripcion;
	@Column(name="precioLitro", nullable = true)
	private Double precioPorLitro;
	@Column(name="estado")
	private Boolean estado;
	
	public Cerveza(){}

	public Cerveza(Long id, String nombreCerveza, String tipoCerveza, Double gradoAlcoholico, Double precioPorLitro) {
		super();
		this.id = id;
		this.nombreCerveza = nombreCerveza;
		this.tipoCerveza = tipoCerveza;
		this.gradoAlcoholico = gradoAlcoholico;
		this.precioPorLitro = precioPorLitro;
	}

	public Cerveza(String nombreCerveza, String tipoCerveza, Double gradoAlcoholico, Double precioPorLitro) {
		super();
		this.nombreCerveza = nombreCerveza;
		this.tipoCerveza = tipoCerveza;
		this.gradoAlcoholico = gradoAlcoholico;
		this.precioPorLitro = precioPorLitro;
	}

	public Cerveza(Long id, String nombreCerveza, String tipoCerveza, Double gradoAlcoholico, String descripcion,
			Double precioPorLitro) {
		super();
		this.id = id;
		this.nombreCerveza = nombreCerveza;
		this.tipoCerveza = tipoCerveza;
		this.gradoAlcoholico = gradoAlcoholico;
		this.descripcion = descripcion;
		this.precioPorLitro = precioPorLitro;
	}
	
	

	public Cerveza(Long id, String nombreCerveza, String tipoCerveza, Double gradoAlcoholico, Double amargorIbu,
			String descripcion, Double precioPorLitro, Boolean estado) {
		super();
		this.id = id;
		this.nombreCerveza = nombreCerveza;
		this.tipoCerveza = tipoCerveza;
		this.gradoAlcoholico = gradoAlcoholico;
		this.amargorIbu = amargorIbu;
		this.descripcion = descripcion;
		this.precioPorLitro = precioPorLitro;
		this.estado = estado;
	}

	public Double getAmargorIbu() {
		return amargorIbu;
	}

	public void setAmargorIbu(Double amargorIbu) {
		this.amargorIbu = amargorIbu;
	}

	
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getTipoCerveza() {
		return tipoCerveza;
	}

	public void setTipoCerveza(String tipoCerveza) {
		this.tipoCerveza = tipoCerveza;
	}

	public Double getGradoAlcoholico() {
		return gradoAlcoholico;
	}

	public void setGradoAlcoholico(Double gradoAlcoholico) {
		this.gradoAlcoholico = gradoAlcoholico;
	}

	public Double getPrecioPorLitro() {
		return precioPorLitro;
	}

	public void setPrecioPorLitro(Double precioPorLitro) {
		this.precioPorLitro = precioPorLitro;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Cerveza [id=" + id + ", nombreCerveza=" + nombreCerveza + ", tipoCerveza=" + tipoCerveza
				+ ", gradoAlcoholico=" + gradoAlcoholico + ", amargorIbu=" + amargorIbu + ", descripcion=" + descripcion
				+ ", precioPorLitro=" + precioPorLitro + ", estado=" + estado + "]";
	}

	

	

	
	

}
