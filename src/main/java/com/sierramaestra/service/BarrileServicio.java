package com.sierramaestra.service;

import java.util.List;

import com.sierramaestra.model.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarrileServicio {
    List<Barril> listarTodosLosBarriles();
    
    Barril guardarBarril(Barril barril);
    
    Barril obtenerBarrilPorId(Long id);
    
    Barril actualizarBarril(Barril barril);
    
    void eliminarBarril(Long id);

    List<Barril> listarBarrilesPorEstado(String estado);
    
    Page<Barril> listarTodosLosBarriles(Pageable pageable);
    
    Page<Barril> listarBarrilesPorEstado(String estado, Pageable pageable);
}
