package com.sierramaestra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sierramaestra.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // Busca clientes por id con paginación
    Page<Cliente> findById(Long id, Pageable pageable);

    // Cuenta clientes por id exacto
    long countById(Long id); // Cambiado a countById en lugar de Containing

}
