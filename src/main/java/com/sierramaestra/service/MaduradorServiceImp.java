package com.sierramaestra.service;
import com.sierramaestra.repository.MaduradorRepositorio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sierramaestra.model.Madurador;


@Service("maduradorServicioImlp")

public class MaduradorServiceImp implements MaduradorService{
	@Autowired
    private MaduradorRepositorio repositorio;
    
    @Override
    public List<Madurador> listarTodosLosMadurador() {
        return repositorio.findAll();
    }

    @Override
    public Madurador guardarMadurador(Madurador madurador) {
        return repositorio.save(madurador);
    }

    @Override
    public Madurador obtenerMaduradorPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Madurador actualizarMadurador(Madurador madurador) {
        return repositorio.save(madurador);
    }

    @Override
    public void eliminarMadurador(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Madurador> listarMaduradorPorEstado(String estado) {
        return repositorio.findByEstado(estado);
    }
    
    @Override
    public Page<Madurador> listarTodosLosMadurador(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    @Override
    public Page<Madurador> listarMaduradorPorEstado(String estado, Pageable pageable) {
        return repositorio.findByEstado(estado, pageable);
    }
    
    //@Autowired
    //private MaduradorRepositorio maduradorRepositorio;	
    
    @Override
    public List<Madurador> listarMaduradorPorEstadoLimpio() {
        return repositorio.findByEstado("Limpio");
    }
}
