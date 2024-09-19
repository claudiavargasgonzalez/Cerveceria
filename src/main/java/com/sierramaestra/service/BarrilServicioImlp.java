package com.sierramaestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sierramaestra.model.Barril;
import com.sierramaestra.repository.BarrilRepositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class BarrilServicioImlp implements BarrileServicio {

    @Autowired
    private BarrilRepositorio repositorio;
    
    @Override
    public List<Barril> listarTodosLosBarriles() {
        return repositorio.findAll();
    }

    @Override
    public Barril guardarBarril(Barril barril) {
        return repositorio.save(barril);
    }

    @Override
    public Barril obtenerBarrilPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Barril actualizarBarril(Barril barril) {
        return repositorio.save(barril);
    }

    @Override
    public void eliminarBarril(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Barril> listarBarrilesPorEstado(String estado) {
        return repositorio.findByEstado(estado);
    }
    
    @Override
    public Page<Barril> listarTodosLosBarriles(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    @Override
    public Page<Barril> listarBarrilesPorEstado(String estado, Pageable pageable) {
        return repositorio.findByEstado(estado, pageable);
    }
}
