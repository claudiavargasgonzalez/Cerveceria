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
import com.sierramaestra.model.Madurador;
import com.sierramaestra.service.MaduradorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
public class MaduradorController {

    @Autowired
    @Qualifier("maduradorServicioImlp")
    private MaduradorService servicio;

    @GetMapping("/madurador")
    public String listarMadurador(
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Model modelo) {

        // Se crea el objeto Pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        // Se recupera la página de barriles
        Page<Madurador> maduradorPage;
        if (estado == null || estado.isEmpty()) {
        	maduradorPage = servicio.listarTodosLosMadurador(pageable);
        } else {
        	maduradorPage = servicio.listarMaduradorPorEstado(estado, pageable);
        }

        modelo.addAttribute("maduradorPage", maduradorPage);
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "tabla_madurador";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/madurador/nuevo")
    public String crearMaduradorFormulario(Model modelo) {
    	Madurador madurador = new Madurador();
        modelo.addAttribute("madurador", madurador);
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "crear_madurador";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/madurador")
    public String guardarMadurador(@ModelAttribute("madurador") Madurador madurador) {
        servicio.guardarMadurador(madurador);
        return "redirect:/madurador";
    }

    @GetMapping("/madurador/editarMadurador/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("madurador", servicio.obtenerMaduradorPorId(id));
        modelo.addAttribute("estados", new String[]{"Cargado", "Limpio", "Inactivo"});
        return "editar_madurador";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/madurador/{id}")
    public String actualizarMadurador(@PathVariable Long id, @ModelAttribute("madurador") Madurador madurador) {
    	Madurador maduradorExistente = servicio.obtenerMaduradorPorId(id);
    	maduradorExistente.setId(id);
    	maduradorExistente.setLitros(madurador.getLitros());
    	maduradorExistente.setEstado(madurador.getEstado());
    	maduradorExistente.setNotas(madurador.getNotas());
        servicio.actualizarMadurador(maduradorExistente);
        return "redirect:/madurador";
    }

    @GetMapping("/madurador/{id}")
    public String eliminarMadurador(@PathVariable Long id) {
        servicio.eliminarMadurador(id);
        return "redirect:/madurador";
    }

    @GetMapping("/madurador/showMadurador/{id}")
    public String obtenerMaduradorPorId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("madurador", servicio.obtenerMaduradorPorId(id));
        return "show_madurador";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/madurador/limpios")
    public String listarMaduradorLimpios(Model modelo) {
        List<Madurador> maduradorLimpios = servicio.listarMaduradorPorEstadoLimpio();
        modelo.addAttribute("maduradorLimpios", maduradorLimpios);
        return "redirect:/madurador";  // Asegúrate de que esta vista sea la correcta
    }
}