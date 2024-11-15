package com.sierramaestra.repository;
<<<<<<< HEAD

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sierramaestra.model.Cliente;

<<<<<<< HEAD
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // Busca clientes por id con paginación
    Page<Cliente> findById(Long id, Pageable pageable);

    // Cuenta clientes por id exacto
    long countById(Long id); // Cambiado a countById en lugar de Containing

}
=======


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Page<Cliente> findByLegajoContaining(String legajo, Pageable pageable);
    long countByLegajoContaining(String legajo);
	Cliente findByLegajo(String legajo);
}
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
