package com.sierramaestra.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sierramaestra.model.Fermentador;

public interface FermentadorService {
    List<Fermentador> listarTodosLosFermentadores();
    
    Fermentador guardarFermentador(Fermentador fermentador);
    
    Fermentador obtenerFermentadorPorId(Long id);
    
    Fermentador actualizarFermentador(Fermentador fermentador);
    
    void eliminarFermentador(Long id);

    List<Fermentador> listarFermentadoresPorEstado(String estado);
    
    Page<Fermentador> listarTodosLosFermentadores(Pageable pageable);
    
    Page<Fermentador> listarFermentadoresPorEstado(String estado, Pageable pageable);
    
    List<Fermentador> listarFermentadoresPorEstadoLimpio();
}
