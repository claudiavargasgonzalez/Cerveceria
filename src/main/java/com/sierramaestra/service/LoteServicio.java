package com.sierramaestra.service;

import java.util.List;
import com.sierramaestra.model.Lote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LoteServicio {
	 List<Lote> listarTodosLosLotes();
	    
	    Lote obtenerLotePorId(Long id);
	    
	    Lote guardarLote(Lote lote);
	    
	    Lote actualizarLote(Lote lote);
	    
	    void eliminarLote(Long id);
	    
	    Page<Lote> listarTodosLosLotes(Pageable pageable);
	    

}
