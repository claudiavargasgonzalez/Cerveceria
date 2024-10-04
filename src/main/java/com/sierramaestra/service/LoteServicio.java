package com.sierramaestra.service;

import java.util.List;

import com.sierramaestra.model.Lote;

public interface LoteServicio {
	public List<Lote> listarTodosLosLotes();

	public Lote obtenerLotePorId(Long id);
	
	public void crearLote(Lote lote, Long barrilId);

	//Lote guardarLote(Lote lote);

	Lote actualizarLote(Lote lote);

	void eliminarLote(Long id);
	


}
