package com.sierramaestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sierramaestra.model.Barril;
import com.sierramaestra.model.Lote;
import com.sierramaestra.service.BarrileServicio;
import com.sierramaestra.service.LoteServicio;

@Controller
@RequestMapping
public class LoteController {
	@Autowired
    private LoteServicio servicio;
    
    @Autowired
    private BarrileServicio barrilServicio;

    @GetMapping("/lote")
    public String listarTodosLosLotes(Model modelo) {
        List<Lote> lotes = servicio.listarTodosLosLotes();
        modelo.addAttribute("lotes", lotes);
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "tabla_lote";
    }

    @GetMapping("/{id}")
    public String obtenerLotePorId(@PathVariable Long id, Model modelo) {
        Lote lote = servicio.obtenerLotePorId(id);
        if (lote != null) {
            modelo.addAttribute("lote", lote);
            return "detalle_lote";
        } else {
            return "404";
        }
    }

    @PostMapping("/lote")
    public String guardarLote(@ModelAttribute Lote lote) {
        servicio.actualizarLote(lote);
        return "redirect:/lote";
    }

    @GetMapping("/lote/nuevo")
    public String crearLoteFormulario(Model modelo) {
        Lote lote = new Lote();
        List<Barril> barrilesLimpios = barrilServicio.listarBarrilesPorEstado("limpio");
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("barrilesLimpios", barrilesLimpios);
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "crear_lote";
    }
    
    @PostMapping("/lote/addnew")
    public void createLoteForm(@RequestBody Lote lote,@RequestParam Long barrilId){
        servicio.crearLote(lote, barrilId);
    }

    @DeleteMapping("/{id}")
    public String eliminarLote(@PathVariable Long id) {
        servicio.eliminarLote(id);
        return "redirect:/lote";
    }

}
