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
import com.sierramaestra.model.Accesorio;
import com.sierramaestra.service.AccesorioServicio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
public class AccesorioControlador {
	@Autowired
    @Qualifier("accesorioServicioImpl")
    private AccesorioServicio servicio;

    @GetMapping("/accesorio")
    public String listarAccesorio(
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Model modelo) {

        // Se crea el objeto Pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        // Se recupera la página de barriles
        Page<Accesorio> accesorioPage;
        if (estado == null || estado.isEmpty()) {
        	accesorioPage = servicio.listarTodosLosAccesorio(pageable);
        } else {
        	accesorioPage = servicio.listarAccesorioPorEstado(estado, pageable);
        }

        modelo.addAttribute("accesorioPage", accesorioPage);
        modelo.addAttribute("estados", new String[]{"Alqulado","Devuelto","Limpio", "Inactivo"});
        return "tabla_accesorio";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/accesorio/nuevo")
    public String crearAccesorioFormulario(Model modelo) {
    	Accesorio accesorio = new Accesorio();
        modelo.addAttribute("accesorio", accesorio);
        modelo.addAttribute("estados", new String[]{"Alquilado","Devuelto", "Limpio", "Inactivo"});
        return "crear_accesorio";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/accesorio")
    public String guardarAccesorio(@ModelAttribute("accesorio") Accesorio accesorio) {
        servicio.guardarAccesorio(accesorio);
        return "redirect:/accesorio";
    }

    @GetMapping("/accesorio/editarAccesorio/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("accesorio", servicio.obtenerAccesorioPorId(id));
        modelo.addAttribute("estados", new String[]{"Alquilado", "Devuelto", "Limpio", "Inactivo"});
        return "editar_accesorio";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/accesorio/{id}")
    public String actualizarAccesorio(@PathVariable Long id, @ModelAttribute("accesorio") Accesorio accesorio) {
    	Accesorio accesorioExistente = servicio.obtenerAccesorioPorId(id);
    	accesorioExistente.setId(id);
    	accesorioExistente.setNombre(accesorio.getNombre());
    	accesorioExistente.setEstado(accesorio.getEstado());
    	accesorioExistente.setNotas(accesorio.getNotas());
        servicio.actualizarAccesorio(accesorioExistente);
        return "redirect:/accesorio";
    }

    @GetMapping("/accesorio/{id}")
    public String eliminarAccesorio(@PathVariable Long id) {
        servicio.eliminarAccesorio(id);
        return "redirect:/accesorio";
    }

    @GetMapping("/accesorio/showAccesorio/{id}")
    public String obtenerAccesorioPorId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("accesorio", servicio.obtenerAccesorioPorId(id));
        return "show_accesorio";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/accesorio/limpios")
    public String listarAccesorioLimpios(Model modelo) {
        List<Accesorio> accesorioLimpios = servicio.listarAccesorioPorEstadoLimpio();
        modelo.addAttribute("accesorioLimpios", accesorioLimpios);
        return "redirect:/accesorio";  // Asegúrate de que esta vista sea la correcta
    }
}
