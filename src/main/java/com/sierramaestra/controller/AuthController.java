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
	public String login(@RequestParam String email,@RequestParam String password, Model model) {
		if(authService.authenticate(email, password)) {
			model.addAttribute("email", email);
			return "homeWelcome";
		}else {
			model.addAttribute("error", "invalid credentials");
			return "login";
		}
		
	}

}
