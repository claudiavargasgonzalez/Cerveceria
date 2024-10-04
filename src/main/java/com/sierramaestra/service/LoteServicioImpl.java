package com.sierramaestra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Barril;
import com.sierramaestra.model.Lote;
import com.sierramaestra.repository.BarrilRepositorio;
import com.sierramaestra.repository.LoteRepositorio;

@Service
public class LoteServicioImpl implements LoteServicio {
	
	@Autowired
    private LoteRepositorio loteRepositorio;
	
	@Autowired
	private BarrilRepositorio barrilRepositorio;

	@Override
	public List<Lote> listarTodosLosLotes() {
		return loteRepositorio.findAll();
	}

	@Override
	public Lote obtenerLotePorId(Long id) {
		 Optional<Lote> lote = loteRepositorio.findById(id);
	        return lote.orElse(null);
	}

	/*@Override
	public Lote guardarLote(Lote lote) {
		return loteRepositorio.save(lote);
	}*/

	@Override
	public Lote actualizarLote(Lote lote) {
		return loteRepositorio.save(lote);
	}

	@Override
	public void eliminarLote(Long id) {
		loteRepositorio.deleteById(id);
	}

	@Override
	public void crearLote(Lote lote, Long barrilId) {
		Barril barril= barrilRepositorio.findById(barrilId)
		.orElseThrow(() -> new IllegalArgumentException("Barril not found"));
		lote.agregarBarril(barril);
		barril.setEstado("cargado");
		loteRepositorio.save(lote);
	}

	

}
