package com.sierramaestra.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sierramaestra.model.Accesorio;

public interface AccesorioServicio {
	List<Accesorio> listarTodosLosAccesorio();
    
	Accesorio guardarAccesorio(Accesorio accesorio);
    
	Accesorio obtenerAccesorioPorId(Long id);
    
	Accesorio actualizarAccesorio(Accesorio accesorio);
    
    void eliminarAccesorio(Long id);

    List<Accesorio> listarAccesorioPorEstado(String estado);
    
    Page<Accesorio> listarTodosLosAccesorio(Pageable pageable);
    
    Page<Accesorio> listarAccesorioPorEstado(String estado, Pageable pageable);
    
    List<Accesorio> listarAccesorioPorEstadoLimpio();
}
