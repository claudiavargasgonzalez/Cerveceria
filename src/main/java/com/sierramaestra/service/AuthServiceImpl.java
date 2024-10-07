package com.sierramaestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Usuario;
import com.sierramaestra.repository.UsuarioRepositorio;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Override
	public boolean authenticate(String legajo, String contrasena) {
		Usuario usuario = usuarioRepository.findByLegajo(legajo);
		if(usuario != null) {
			return usuario.getContrasena().equals(contrasena);
		}
		return false;
	}


}
