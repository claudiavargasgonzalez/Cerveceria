package com.sierramaestra.controller;

import com.sierramaestra.model.Lote;
import com.sierramaestra.service.LoteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class LoteControlador {

    @Autowired
    private LoteServicio servicio;
    
    
    @GetMapping("/lote")
    public String listarTodosLosLotes(@RequestParam(defaultValue = "0") int page, Model modelo) {
        Pageable pageable = PageRequest.of(page, 10); // 10 elementos por página
        Page<Lote> lotesPage = servicio.listarTodosLosLotes(pageable);
        modelo.addAttribute("lotes", lotesPage.getContent());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", lotesPage.getTotalPages());
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "tabla_lote";
    }

    @GetMapping("/lote/{id}")
    public String obtenerLotePorId(@PathVariable("id") Long id, Model modelo) {
        Lote lote = servicio.obtenerLotePorId(id);
        if (lote != null) {
            modelo.addAttribute("lote", lote);
            return "show_lote"; // Asegúrate de que este sea el nombre correcto de tu plantilla
        } else {
            return "404";
        }
    }

    @PostMapping("/lote")
    public String guardarLote(@ModelAttribute("lote") Lote lote) {
        servicio.guardarLote(lote);
        return "redirect:/lote";
    }

    @GetMapping("/lote/nuevo")
    public String crearLoteFormulario(Model modelo) {
        Lote lote = new Lote();
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "crear_lote";
    }

    @DeleteMapping("/{id}")
    public String eliminarLote(@PathVariable("id") Long id) {
        servicio.eliminarLote(id);
        return "redirect:/lote";
    }

    @GetMapping("/lote/editarLote/{id}")
    public String editarLote(@PathVariable("id") Long id, Model modelo) {
        Lote lote = servicio.obtenerLotePorId(id);
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"}); // Añade los estados que necesites
        return "editar_lote"; // Asegúrate de que esta es la vista correcta
    }

    @PostMapping("/lote/editarLote/{id}")
    public String actualizarLote(@PathVariable("id") Long id, @ModelAttribute("lote") Lote lote) {
        lote.setId(id); // Asegúrate de establecer el ID correcto
        servicio.actualizarLote(lote);
        return "redirect:/lote"; // Redirige a la lista de lotes después de la actualización
    }

}