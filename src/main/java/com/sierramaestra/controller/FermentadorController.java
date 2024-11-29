package com.sierramaestra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sierramaestra.model.Fermentador;
import com.sierramaestra.service.FermentadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
public class FermentadorController {

    @Autowired
    @Qualifier("fermentadorServicioImp")
    private FermentadorService servicio;

    @GetMapping("/fermentador")
    public String listarFermentadores(
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Model modelo) {

        // Se crea el objeto Pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        // Se recupera la página de fermentadores
        Page<Fermentador> fermentadorPage;
        if (estado == null || estado.isEmpty()) {
            fermentadorPage = servicio.listarTodosLosFermentadores(pageable);
        } else {
            fermentadorPage = servicio.listarFermentadoresPorEstado(estado, pageable);
        }

        modelo.addAttribute("fermentadorPage", fermentadorPage);
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "tabla_fermentador";  // Vista adaptada
    }

    @GetMapping("/fermentador/nuevo")
    public String crearFermentadorFormulario(Model modelo) {
        Fermentador fermentador = new Fermentador();
        modelo.addAttribute("fermentador", fermentador);
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "crear_fermentador";  // Vista adaptada
    }

    @PostMapping("/fermentador")
    public String guardarFermentador(@ModelAttribute("fermentador") Fermentador fermentador) {
        servicio.guardarFermentador(fermentador);
        return "redirect:/fermentador";
    }

    @GetMapping("/fermentador/editarFermentador/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("fermentador", servicio.obtenerFermentadorPorId(id));
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "editar_fermentador";  // Vista adaptada
    }

    @PostMapping("/fermentador/{id}")
    public String actualizarFermentador(@PathVariable Long id, @ModelAttribute("fermentador") Fermentador fermentador) {
        Fermentador fermentadorExistente = servicio.obtenerFermentadorPorId(id);
        fermentadorExistente.setId(id);
        fermentadorExistente.setLitros(fermentador.getLitros());
        fermentadorExistente.setEstado(fermentador.getEstado());
        fermentadorExistente.setNotas(fermentador.getNotas());
        servicio.actualizarFermentador(fermentadorExistente);
        return "redirect:/fermentador";
    }

    @GetMapping("/fermentador/{id}")
    public String eliminarFermentador(@PathVariable Long id) {
        servicio.eliminarFermentador(id);
        return "redirect:/fermentador";
    }

    @GetMapping("/fermentador/showFermentador/{id}")
    public String obtenerFermentadorPorId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("fermentador", servicio.obtenerFermentadorPorId(id));
        return "show_fermentador";  // Vista adaptada
    }

    @GetMapping("/fermentador/limpios")
    public String listarFermentadoresLimpios(Model modelo) {
        List<Fermentador> fermentadoresLimpios = servicio.listarFermentadoresPorEstadoLimpio();
        modelo.addAttribute("fermentadoresLimpios", fermentadoresLimpios);
        return "redirect:/fermentador";
    }
}
