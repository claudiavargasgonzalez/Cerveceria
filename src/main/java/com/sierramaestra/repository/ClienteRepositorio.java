package com.sierramaestra.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sierramaestra.model.Cliente;



@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Page<Cliente> findByLegajoContaining(String legajo, Pageable pageable);
    long countByLegajoContaining(String legajo);
	Cliente findByLegajo(String legajo);
}