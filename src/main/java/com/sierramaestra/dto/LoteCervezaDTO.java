package com.sierramaestra.dto;

import java.util.Date;

public class LoteCervezaDTO {
	
	private String nombreCerveza;
    private Integer cantidadLitros;
    private String estado;
    private Date fechaVencimiento;

    public LoteCervezaDTO(String nombreCerveza, Integer cantidadLitros, String estado, Date fechaVencimiento) {
        this.nombreCerveza = nombreCerveza;
        this.cantidadLitros = cantidadLitros;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
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

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
    

}
