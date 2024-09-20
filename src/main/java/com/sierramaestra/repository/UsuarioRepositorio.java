package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sierramaestra.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    // Métodos personalizados pueden ser añadidos aquí si es necesario
	Usuario findByEmail(String email);
}
