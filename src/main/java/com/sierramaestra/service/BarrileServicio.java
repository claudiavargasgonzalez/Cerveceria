package com.sierramaestra.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sierramaestra.model.Barril;

public interface BarrileServicio {
    List<Barril> listarTodosLosBarriles();
    
    Barril guardarBarril(Barril barril);
    
    Barril obtenerBarrilPorId(Long id);
    
    Barril actualizarBarril(Barril barril);
    
    void eliminarBarril(Long id);
    
    Page<Barril> listarTodosLosBarriles(Pageable pageable);

    Page<Barril> listarBarrilesPorEstado(String estado, Pageable pageable);

	List<Barril> listarBarrilesPorEstado(String estado);
}
