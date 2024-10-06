package com.sierramaestra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Usuario;
import com.sierramaestra.repository.UsuarioRepositorio;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return repositorio.findById(id).orElse(null); // Usar orElse para evitar excepciones
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Usuario> listarUsuarios(int page, int size, String legajo) {
        Pageable pageable = PageRequest.of(page, size);
        if (legajo != null && !legajo.isEmpty()) {
            return repositorio.findByLegajoContaining(legajo, pageable).getContent();
        }
        return repositorio.findAll(pageable).getContent();
    }

    @Override
    public long contarUsuarios(String legajo) {
        if (legajo != null && !legajo.isEmpty()) {
            return repositorio.countByLegajoContaining(legajo); // Corregido el nombre de variable
        }
        return repositorio.count();
    }
}
