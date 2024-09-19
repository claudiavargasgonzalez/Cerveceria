package com.sierramaestra.service;

import com.sierramaestra.dto.UsuarioRegistroDto;
import com.sierramaestra.model.Usuario;

public interface UsuarioService{
	public Usuario guardar(UsuarioRegistroDto registroDto);

}
