package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sierramaestra.model.Fermentador;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FermentadorRepositorio extends JpaRepository<Fermentador, Long> {
    List<Fermentador> findByEstado(String estado);
    Page<Fermentador> findByEstado(String estado, Pageable pageable);
}
