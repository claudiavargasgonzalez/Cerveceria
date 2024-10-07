package com.sierramaestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sierramaestra.service.AuthService;

@Controller
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String legajo,@RequestParam String contrasena, Model model) {
		if(authService.authenticate(legajo, contrasena)) {
			model.addAttribute("legajo", legajo);
			return "menu-principal";
		}else {
			model.addAttribute("error", "Credenciales invalidas");
			return "login";
		}
		
	}

}
