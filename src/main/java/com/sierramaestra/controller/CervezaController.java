package com.sierramaestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sierramaestra.model.Cerveza;
import com.sierramaestra.service.CervezaService;

@Controller
public class CervezaController {
	
	@Autowired
	private CervezaService service;
	
	@GetMapping("/cervezas")
	public String listarCervezas(Model model) {
		model.addAttribute("cervezas", service.listarTodasLasCervezas());
		return "cervezas";//nos retorna el archivo cervezas
	}
	
	@GetMapping("/cervezas/nuevaCerveza")
	public String crearCervezaForm(Model model) {
		Cerveza cerveza=new Cerveza();
		model.addAttribute("cerveza", cerveza);
		return "crear_cerveza";
	}
	
	@PostMapping("/cervezas")
	public String guardarCerveza(@ModelAttribute Cerveza cerveza) {
		service.crearCerveza(cerveza);
		return "redirect:/cervezas";
	}
	
	/*@GetMapping("/cervezas/editar/{id}")
	public String mostrarCervezaEditForm(@PathVariable Long id,Model model) {
		model.addAttribute("cerveza", service.obtenerCervezaPorId(id));
		return "editar_cerveza";
	}*/
	
	@GetMapping("/cervezas/editar/{id}")
	public String mostrarCervezaEditForm(@PathVariable Long id,Model model) {
		Cerveza cervezaExist = service.obtenerCervezaPorId(id);
		model.addAttribute("cerveza", cervezaExist);
		return "editar_cerveza";
	}
	
	
	@PostMapping("/cervezas/actualizar/{id}")
	public String actualizarCerveza(@PathVariable Long id, @ModelAttribute Cerveza cerveza, Model model) {
		service.actualizarCerveza(cerveza);
		return "redirect:/cervezas";
		
	}
	
	
	@GetMapping("/cervezas/eliminar/{id}")
	public String eliminarCerveza(@PathVariable Long id) {
		service.eliminarCerveza(id);
		return "redirect:/cervezas";
	}
	
	
}

