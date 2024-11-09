package com.sierramaestra.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sierramaestra.model.Accesorio	;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AccesorioRepositorio extends JpaRepository<Accesorio, Long> {
	  List<Accesorio> findByEstado(String estado);
	  Page<Accesorio> findByEstado(String estado, Pageable pageable);
}
