package com.sierramaestra.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sierramaestra.model.Madurador;

public interface MaduradorService {
	 List<Madurador> listarTodosLosMadurador();
	    
	 	Madurador guardarMadurador(Madurador madurador);
	    
	    Madurador obtenerMaduradorPorId(Long id);
	    
	    Madurador actualizarMadurador(Madurador madurador);
	    
	    void eliminarMadurador(Long id);

	    List<Madurador> listarMaduradorPorEstado(String estado);
	    
	    Page<Madurador> listarTodosLosMadurador(Pageable pageable);
	    
	    Page<Madurador> listarMaduradorPorEstado(String estado, Pageable pageable);
	    
	    List<Madurador> listarMaduradorPorEstadoLimpio();
}
