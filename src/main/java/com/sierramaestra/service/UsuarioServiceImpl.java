package com.sierramaestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.dto.UsuarioRegistroDto;
import com.sierramaestra.model.Usuario;
import com.sierramaestra.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardar(UsuarioRegistroDto registroDto) {
		Usuario usuario = new Usuario(registroDto.getNombre(), registroDto.getApellido(), registroDto.getEmail(),
				registroDto.getPassword(), registroDto.getRol());
		return usuarioRepository.save(usuario);
	}

}
