package com.sierramaestra.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Barril;
import com.sierramaestra.model.Cerveza;
import com.sierramaestra.model.Lote;
import com.sierramaestra.model.Madurador;
import com.sierramaestra.repository.BarrilRepositorio;
import com.sierramaestra.repository.LoteRepositorio;
import com.sierramaestra.repository.MaduradorRepositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service("loteServicioImp")
public class LoteServicioImp implements LoteServicio {

    @Autowired
    private LoteRepositorio loteRepositorio;
    
    @Autowired
    private BarrilRepositorio barrilRepositorio;
    
    @Autowired
    private MaduradorRepositorio maduradorRepositorio;
    
    

    @Override
    public List<Lote> listarTodosLosLotes() {
        return loteRepositorio.findAll();
    }

    @Override
    public Lote obtenerLotePorId(Long id) {
        Optional<Lote> lote = loteRepositorio.findById(id);
        return lote.orElse(null); // Puedes manejar la excepción si el Lote no se encuentra
    }

    @Override
    public Lote guardarLote(Lote lote) {
        return loteRepositorio.save(lote);
    }

    @Override
    public void eliminarLote(Long id) {
        loteRepositorio.deleteById(id);
    }

    @Override
    public Lote actualizarLote(Lote lote) {
        return loteRepositorio.save(lote);
    }
    
    @Override
    public Page<Lote> listarTodosLosLotes(Pageable pageable) {
        return loteRepositorio.findAll(pageable);
    }

	@Override
	public List<Lote> obtenerLotesActivosPorCerveza(Cerveza cerveza) {
		 // Obtener los lotes para una cerveza
        List<Lote> lotes = loteRepositorio.findByCerveza(cerveza);

        // Calcular los lotes activos
        List<Lote> lotesActivos = new ArrayList<>();
        
        for (Lote lote : lotes) {
            // Obtener el total de stock disponible (Maduradores + Barriles)
            double stockDisponible = obtenerStockDisponible(lote);

            if (stockDisponible > 0) {
                // El lote está activo
                lote.setEstado("Activo");
                lotesActivos.add(lote);
            } else {
                // El lote está inactivo
                lote.setEstado("Inactivo");
            }
        }

        // Ordenar los lotes por fecha de vencimiento más próxima
        lotesActivos.sort(Comparator.comparing(Lote::getFechaVencimiento));

        return lotesActivos;
    }

	@Override
	public double obtenerStockDisponible(Lote lote) {
		 // Obtener el stock de barriles y maduradores
        double stockBarriles = barrilRepositorio.findByEstado("Activo").stream()
                .mapToDouble(Barril::getLitros)
                .sum();

        double stockMaduradores = maduradorRepositorio.findByEstado("Activo").stream()
                .mapToDouble(Madurador::getLitros)
                .sum();

        return stockBarriles + stockMaduradores;
    }

	
   
}