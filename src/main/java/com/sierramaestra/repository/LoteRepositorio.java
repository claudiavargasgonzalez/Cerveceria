package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierramaestra.model.Lote;

@Repository
public interface LoteRepositorio extends JpaRepository <Lote, Long>{

}
