package com.sierramaestra.controller;

import com.sierramaestra.model.Barril;
<<<<<<< HEAD
import com.sierramaestra.model.Cerveza;
=======
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
import com.sierramaestra.model.Lote;
import com.sierramaestra.service.BarrileServicio;
import com.sierramaestra.service.LoteServicio;

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
    private LoteServicio servicio;
    
    @Autowired
    private BarrileServicio barrileServicio;

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

    @PostMapping("/lote/{id}/cargarBarriles")
    public String cargarBarrilesEnLote(
        @PathVariable("id") Long id,
        @RequestParam("barrilesSeleccionados") List<Long> barrilesIds,
        Model modelo
    ) {
        // Obtener el lote
        Lote lote = servicio.obtenerLotePorId(id);
        if (lote == null) {
            modelo.addAttribute("error", "Lote no encontrado.");
            return "404";
        }

        // Obtener los barriles seleccionados
        List<Barril> barriles = barrileServicio.listarTodosLosBarriles()
            .stream()
            .filter(b -> barrilesIds.contains(b.getId()) && "Limpio".equalsIgnoreCase(b.getEstado()))
            .toList();

        if (barriles.isEmpty()) {
            modelo.addAttribute("error", "No se encontraron barriles válidos para asignar.");
            return "show_lote";
        }

        // Asignar los barriles al lote
        for (Barril barril : barriles) {
            barril.setEstado("Cargado"); // Cambiar estado a "Cargado"
            barril.setLote(lote);        // Asociar al lote
            barrileServicio.actualizarBarril(barril);
        }

        // Cambiar el estado del lote a "CARGADO"
        lote.setEstado("Cargado");
        servicio.actualizarLote(lote);

        modelo.addAttribute("lote", lote);
        modelo.addAttribute("mensaje", "Barriles cargados exitosamente.");
        return "redirect:/lote/" + id;
    }

    @GetMapping("/lote/{id}")
    public String obtenerLotePorId(@PathVariable Long id, Model model) {
<<<<<<< HEAD
        // Obtener el lote por su ID
        Lote lote = loteServicio.obtenerLotePorId(id);
=======
        Lote lote = servicio.obtenerLotePorId(id);
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
        if (lote == null) {
            model.addAttribute("error", "No se encontró un lote con el ID especificado.");
            return "error";
        }

        // Obtener barriles asociados al lote
<<<<<<< HEAD
        List<Barril> barrilesCargados = barrilServicio.listarBarrilesPorLote(lote.getId());

        // Obtener barriles disponibles para asignar
        List<Barril> barrilesLimpios = barrilServicio.listarBarrilesPorEstado("Limpio");

        // Obtener cervezas disponibles para asignar a los barriles
        List<Cerveza> cervezasDisponibles = cervezaServicio.listarCervezasDisponibles();

        // Añadir los datos al modelo
        model.addAttribute("lote", lote);
        model.addAttribute("barrilesCargados", barrilesCargados);
        model.addAttribute("barrilesLimpios", barrilesLimpios);
        model.addAttribute("cervezasDisponibles", cervezasDisponibles);

        // Retornar la vista con los datos
=======
        List<Barril> barrilesCargados = barrileServicio.listarBarrilesPorLote(lote.getId());

        // Obtener barriles disponibles para asignar
        List<Barril> barrilesLimpios = barrileServicio.listarBarrilesPorEstado("Limpio");

        model.addAttribute("lote", lote);
        model.addAttribute("barrilesCargados", barrilesCargados);
        model.addAttribute("barrilesLimpios", barrilesLimpios);
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
        return "show_lote";
    }


<<<<<<< HEAD

=======
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
    @PostMapping("/lote")
    public String guardarLote(@ModelAttribute("lote") Lote lote) throws Exception {
    	if(servicio.guardarLote(lote) != null)
    		return "redirect:/lote";
    	return "redirect:/lote/nuevo";
    }

    @GetMapping("/lote/nuevo")
    public String crearLoteFormulario(Model modelo) {
        Lote lote = new Lote();
        modelo.addAttribute("lote", lote);
        modelo.addAttribute("estados", new String[]{"Activo"});
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
    
    @GetMapping("/lote/buscar")
    public String buscarLotePorId(@RequestParam("id") Long id, Model modelo) {
        Lote lote = servicio.obtenerLotePorId(id);
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