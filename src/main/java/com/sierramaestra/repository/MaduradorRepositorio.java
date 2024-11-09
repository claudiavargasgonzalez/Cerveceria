package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sierramaestra.model.Madurador;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MaduradorRepositorio extends JpaRepository<Madurador, Long> {
    List<Madurador> findByEstado(String estado);
    Page<Madurador> findByEstado(String estado, Pageable pageable);
}
