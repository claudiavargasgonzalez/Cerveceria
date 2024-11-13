package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sierramaestra.model.Barril;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarrilRepositorio extends JpaRepository<Barril, Long> {
    List<Barril> findByEstado(String estado);
    Page<Barril> findByEstado(String estado, Pageable pageable);
    List<Barril> findByLoteId(Long loteId);
}
