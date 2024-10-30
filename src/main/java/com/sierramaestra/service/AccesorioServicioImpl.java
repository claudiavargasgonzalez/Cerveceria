package com.sierramaestra.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Accesorio;
import com.sierramaestra.repository.AccesorioRepositorio;

@Service("accesorioServicioImpl")
public class AccesorioServicioImpl implements AccesorioServicio{
	  @Autowired
	    private AccesorioRepositorio repositorio;
	    
	    @Override
	    public List<Accesorio> listarTodosLosAccesorio() {
	        return repositorio.findAll();
	    }

	    @Override
	    public Accesorio guardarAccesorio(Accesorio accesorio) {
	        return repositorio.save(accesorio);
	    }

	    @Override
	    public Accesorio obtenerAccesorioPorId(Long id) {
	        return repositorio.findById(id).orElse(null);
	    }

	    @Override
	    public Accesorio actualizarAccesorio(Accesorio accesorio) {
	        return repositorio.save(accesorio);
	    }

	    @Override
	    public void eliminarAccesorio(Long id) {
	        repositorio.deleteById(id);
	    }

	    @Override
	    public List<Accesorio> listarAccesorioPorEstado(String estado) {
	        return repositorio.findByEstado(estado);
	    }
	    
	    @Override
	    public Page<Accesorio> listarTodosLosAccesorio(Pageable pageable) {
	        return repositorio.findAll(pageable);
	    }

	    @Override
	    public Page<Accesorio> listarAccesorioPorEstado(String estado, Pageable pageable) {
	        return repositorio.findByEstado(estado, pageable);
	    }
	    
	    @Autowired
	    private AccesorioRepositorio accesorioRepositorio;	
	    
	    @Override
	    public List<Accesorio> listarAccesorioPorEstadoLimpio() {
	        return accesorioRepositorio.findByEstado("Limpio");
	    }

}
