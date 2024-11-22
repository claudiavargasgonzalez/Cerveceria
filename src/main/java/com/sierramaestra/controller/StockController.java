package com.sierramaestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sierramaestra.dto.LoteCervezaDTO;
import com.sierramaestra.model.Cerveza;
import com.sierramaestra.model.Lote;
import com.sierramaestra.repository.CervezaRepository;
import com.sierramaestra.service.LoteServicio;

@Controller
@RequestMapping("/stock")
public class StockController {
	@Autowired
    private LoteServicio loteServicio;
    
    @Autowired
    private CervezaRepository cervezaRepositorio;

    @GetMapping
    public String mostrarFormulario(Model model) {
        List<Cerveza> cervezas = cervezaRepositorio.findAll();
        model.addAttribute("cervezas", cervezas);
        return "stockForm";
    }

  /* @PostMapping("/buscar")
    public String buscarLotes(@RequestParam("cervezaId") Long cervezaId, Model model) {
        Cerveza cerveza = cervezaRepositorio.findById(cervezaId).orElse(null);
        if (cerveza != null) {
            List<Lote> lotesActivos = loteServicio.obtenerLotesActivosPorCerveza(cerveza);
            model.addAttribute("lotes", lotesActivos);
        }
        return "stockResultados";
    }*/
    //hacer get para buscarlote con dtos
    @GetMapping("/buscarLotes")
    public String buscarLotes(@RequestParam("cervezaId") Cerveza cervezaId, Model model) {
        List<Lote> lotes = loteServicio.obtenerLotesActivosPorCerveza(cervezaId);
        model.addAttribute("lotes", lotes);
        return "stockResultados";
    }
}

