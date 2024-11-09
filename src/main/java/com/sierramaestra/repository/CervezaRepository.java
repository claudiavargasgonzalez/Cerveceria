package com.sierramaestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierramaestra.model.Cerveza;

@Repository
public interface CervezaRepository extends JpaRepository<Cerveza,Long>{

}
