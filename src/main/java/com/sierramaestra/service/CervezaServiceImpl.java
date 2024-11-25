package com.sierramaestra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Cerveza;
import com.sierramaestra.repository.CervezaRepository;

@Service
public class CervezaServiceImpl implements CervezaService {

	@Autowired
	private CervezaRepository repositorio;

	@Override
	public List<Cerveza> listarTodasLasCervezas() {
		return repositorio.findAll();
	}

	@Override
	public Cerveza crearCerveza(Cerveza cerveza) {
		return repositorio.save(cerveza);
	}

	@Override
	public Cerveza obtenerCervezaPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Cerveza actualizarCerveza(Cerveza cerveza) {
		return repositorio.save(cerveza);
	}

	@Override
	public void eliminarCerveza(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
    public List<Cerveza> listarCervezasDisponibles() {
		return repositorio.findAll();
    }

	@Override
    public List<Cerveza> listarCervezas() {
        return repositorio.findAll(); // Recupera todas las cervezas desde la base de datos
    }
}
