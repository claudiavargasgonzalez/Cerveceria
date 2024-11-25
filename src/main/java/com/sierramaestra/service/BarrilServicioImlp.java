package com.sierramaestra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Barril;
import com.sierramaestra.repository.BarrilRepositorio;

@Service("barrilServicioImlp")
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

    @Autowired
    private BarrilRepositorio barrilRepositorio;

    @Override
    public List<Barril> listarBarrilesPorEstadoLimpio() {
        return barrilRepositorio.findByEstado("Limpio");
    }

    // Implementación del método correcto para obtener barriles limpios por ids
    @Override
    public List<Barril> obtenerBarrilesLimpiosPorIds(List<Long> ids) {
        // Filtra barriles por los ids proporcionados y que estén en estado "Limpio"
        return barrilRepositorio.findByIdInAndEstado(ids, "Limpio");
    }

    @Override
    public List<Barril> listarBarrilesPorLote(Long loteId) {
        return repositorio.findByLoteId(loteId);
    }
}