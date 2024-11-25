package com.sierramaestra.controller;

import com.sierramaestra.model.Barril;
import com.sierramaestra.model.Cerveza;
import com.sierramaestra.model.Lote;
import com.sierramaestra.service.BarrileServicio;
import com.sierramaestra.service.LoteServicio;
import com.sierramaestra.service.CervezaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping
public class LoteControlador {

    @Autowired
    private CervezaService cervezaServicio;

    @Autowired
    private LoteServicio loteServicio;
    
    @Autowired
    private BarrileServicio barrileServicio;

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/lote")
    public String listarTodosLosLotes(@RequestParam(defaultValue = "0") int page, Model modelo) {
        Pageable pageable = PageRequest.of(page, 10); // 10 elementos por página
        Page<Lote> lotesPage = loteServicio.listarTodosLosLotes(pageable);
        modelo.addAttribute("lotes", lotesPage.getContent());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", lotesPage.getTotalPages());
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "tabla_lote";
    }

    //------------------------------------------------------------------------------------------------------------------

    @PostMapping("/lote/{id}/cargarBarriles")
    public String cargarBarrilesEnLote(
        @PathVariable("id") Long id,
        @RequestParam(value = "barrilesSeleccionados", required = false) List<Long> barrilesIds,
        Model modelo
    ) {
        // Obtener el lote
        Lote lote = loteServicio.obtenerLotePorId(id);
        if (lote == null) {
            modelo.addAttribute("error", "Lote no encontrado.");
            return "404";
        }

        // Obtener los barriles seleccionados (optimizado para buscar solo barriles limpios)
        List<Barril> barriles = barrileServicio.obtenerBarrilesLimpiosPorIds(barrilesIds);
        
        if (barriles.isEmpty()) {
            modelo.addAttribute("error", "No se encontraron barriles limpios disponibles para asignar a este lote.");
            return "show_lote";
        }

        // Asignar los barriles al lote y actualizar su estado
        for (Barril barril : barriles) {
            barril.setEstado("Cargado"); // Cambiar estado a "Cargado"
            barril.setLote(lote);        // Asociar al lote
            try {
                barrileServicio.actualizarBarril(barril);
            } catch (Exception e) {
                modelo.addAttribute("error", "Hubo un error al actualizar el barril " + barril.getId() + ": " + e.getMessage());
                return "show_lote";
            }
        }

        // Cambiar el estado del lote a "CARGADO"
        lote.setEstado("Cargado");
        try {
            loteServicio.actualizarLote(lote);
        } catch (Exception e) {
            modelo.addAttribute("error", "Hubo un error al actualizar el estado del lote: " + e.getMessage());
            return "show_lote";
        }

        modelo.addAttribute("lote", lote);
        modelo.addAttribute("mensaje", "Barriles cargados exitosamente.");
        return "redirect:/lote/" + id;
    }

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/lote/{id}")
    public String obtenerLotePorId(@PathVariable Long id, Model model) {
        // Obtener el lote por su ID
        Lote lote = loteServicio.obtenerLotePorId(id);
        if (lote == null) {
            model.addAttribute("error", "No se encontró un lote con el ID especificado.");
            return "error";
        }

        // Obtener barriles asociados al lote
        List<Barril> barrilesCargados = barrileServicio.listarBarrilesPorLote(lote.getId());

        // Obtener barriles disponibles para asignar
        List<Barril> barrilesLimpios = barrileServicio.listarBarrilesPorEstado("Limpio");

        // Obtener cervezas disponibles para asignar a los barriles
        List<Cerveza> cervezasDisponibles = cervezaServicio.listarCervezasDisponibles();

        // Añadir los datos al modelo
        model.addAttribute("lote", lote);
        model.addAttribute("barrilesCargados", barrilesCargados);
        model.addAttribute("barrilesLimpios", barrilesLimpios);
        model.addAttribute("cervezasDisponibles", cervezasDisponibles);

        // Retornar la vista con los datos
        return "show_lote";
    }

    //------------------------------------------------------------------------------------------------------------------

    @PostMapping("/lote")
    public String guardarLote(@ModelAttribute("lote") Lote lote) {
        loteServicio.guardarLote(lote);
        return "redirect:/lote";
    }

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/lote/nuevo")
    public String crearLoteFormulario(Model modelo) {
        Lote lote = new Lote();
        // Llamada al servicio para obtener la lista de cervezas
        List<Cerveza> cervezas = cervezaServicio.listarCervezas();
    
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("cervezas", cervezas); // Agregamos la lista de cervezas
        modelo.addAttribute("estados", new String[]{"Activo"}); // Lista de estados
    
        return "crear_lote";
    }
    

    //------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public String eliminarLote(@PathVariable("id") Long id) {
        Lote lote = loteServicio.obtenerLotePorId(id);
        if (lote == null) {
            return "redirect:/error";  // Si no se encuentra el lote, muestra una página de error
        }
        loteServicio.eliminarLote(id);
        return "redirect:/lote";
    }

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/lote/editarLote/{id}")
    public String editarLote(@PathVariable("id") Long id, Model modelo) {
        Lote lote = loteServicio.obtenerLotePorId(id);
        List<Cerveza> cervezas = cervezaServicio.listarCervezas();
        if (lote == null) {
            modelo.addAttribute("error", "Lote no encontrado.");
            return "404"; // O la página que maneje este tipo de errores
        }
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("cervezas", cervezas); // Agregamos la lista de cervezas
        modelo.addAttribute("estados", new String[]{"Activo", "Inactivo"});
        return "editar_lote"; // Asegúrate de que esta es la vista correcta
    }

    //------------------------------------------------------------------------------------------------------------------

    @PostMapping("/lote/editarLote/{id}")
    public String actualizarLote(@PathVariable("id") Long id, @ModelAttribute("lote") Lote lote) {
        if (lote == null || lote.getId() == null) {
            return "redirect:/error";  // Manejo de error si el lote es null o no tiene ID
        }
        lote.setId(id);
        loteServicio.actualizarLote(lote);
        return "redirect:/lote";
    }

    //------------------------------------------------------------------------------------------------------------------
    
    @GetMapping("/lote/buscar")
    public String buscarLotePorId(@RequestParam("id") Long id, Model modelo) {
        Lote lote = loteServicio.obtenerLotePorId(id);
        if (lote != null) {
            modelo.addAttribute("lotes", List.of(lote)); // Muestra solo el lote encontrado en la tabla
        } else {
            modelo.addAttribute("lotes", List.of()); // Si no existe, muestra la tabla vacía
            modelo.addAttribute("mensajeError", "Lote no encontrado con el ID proporcionado.");
        }
        modelo.addAttribute("currentPage", 0); // Valores por defecto
        modelo.addAttribute("totalPages", 1); // Valores por defecto
        return "tabla_lote";
    }
}

