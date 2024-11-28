package com.sierramaestra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.sierramaestra.model.Cerveza;
import com.sierramaestra.model.Lote;

@Repository
public interface LoteRepositorio extends JpaRepository <Lote, Long>{
	@Query("select l from Lote l where l.cervezaO.id=:cervezaId")
	List<Lote> findByCerveza(Long cervezaId);
	List<Lote> findByCervezaO(Cerveza cervezaO);
}
