package com.sierramaestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Usuario;
import com.sierramaestra.repository.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean authenticate(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario != null) {
			return usuario.getPassword().equals(password);
		}
		return false;
	}


}
