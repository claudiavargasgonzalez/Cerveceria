package com.sierramaestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sierramaestra.dto.UsuarioRegistroDto;
import com.sierramaestra.service.UsuarioService;

@Controller
@RequestMapping("/registro")
public class UsuarioRegistroController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDto retornarNuevoUsuarioRegistroDto() {
		return new UsuarioRegistroDto();
	}
	
	@GetMapping
	public String mostrarFormDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDto usuarioRegistroDto) {
		usuarioService.guardar(usuarioRegistroDto);
		return "redirect:/registro?exito";
	}
	
	@GetMapping("/login")
	public String mostrarLogIn() {
		return "login";
	}

}
