package com.sierramaestra.service;

import java.util.List;

import com.sierramaestra.model.Usuario;

public interface UsuarioServicio {

	public List<Usuario> listarTodosLosUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
		
}
