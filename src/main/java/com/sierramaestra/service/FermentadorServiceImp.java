package com.sierramaestra.service;

import com.sierramaestra.repository.FermentadorRepositorio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sierramaestra.model.Fermentador;

@Service("fermentadorServicioImp")
public class FermentadorServiceImp implements FermentadorService {
    
    @Autowired
    private FermentadorRepositorio repositorio;
    
    @Override
    public List<Fermentador> listarTodosLosFermentadores() {
        return repositorio.findAll();
    }

    @Override
    public Fermentador guardarFermentador(Fermentador fermentador) {
        return repositorio.save(fermentador);
    }

    @Override
    public Fermentador obtenerFermentadorPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Fermentador actualizarFermentador(Fermentador fermentador) {
        return repositorio.save(fermentador);
    }

    @Override
    public void eliminarFermentador(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Fermentador> listarFermentadoresPorEstado(String estado) {
        return repositorio.findByEstado(estado);
    }
    
    @Override
    public Page<Fermentador> listarTodosLosFermentadores(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    @Override
    public Page<Fermentador> listarFermentadoresPorEstado(String estado, Pageable pageable) {
        return repositorio.findByEstado(estado, pageable);
    }
    
    @Override
    public List<Fermentador> listarFermentadoresPorEstadoLimpio() {
        return repositorio.findByEstado("Limpio");
    }
}
