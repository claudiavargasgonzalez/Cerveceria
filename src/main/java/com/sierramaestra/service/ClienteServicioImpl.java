package com.sierramaestra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierramaestra.model.Cliente;
import com.sierramaestra.repository.ClienteRepositorio;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio repositorio;

    @Override
<<<<<<< HEAD
    public List<Cliente> listarTodosLosClientes() {
=======
    public List<Cliente> listarTodosLosCLientes() {
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
        return repositorio.findAll();
    }

    @Override
    public Cliente guardarClientes(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return repositorio.findById(id).orElse(null); // Usar orElse para evitar excepciones
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        repositorio.deleteById(id);
    }

    @Override
<<<<<<< HEAD
    public List<Cliente> listarClientes(int page, int size, String id) {
        Pageable pageable = PageRequest.of(page, size);
        if (id != null && !id.isEmpty()) {
            Long idLong = Long.parseLong(id);  // Convertir el String 'id' a Long
            // Si buscas clientes con un id específico, no es necesario hacer paginación sobre findById
            return repositorio.findById(idLong, pageable).getContent();
        }
        return repositorio.findAll(pageable).getContent();  // Si no hay id, devolver todos los clientes con paginación
    }
    
    @Override
    public long contarClientes(String id) {
        if (id != null && !id.isEmpty()) {
            Long idLong = Long.parseLong(id);  // Convertir el String 'id' a Long
            return repositorio.countById(idLong);  // Contar los clientes con el id dado
        }
        return repositorio.count();  // Contar todos los clientes si no se especifica un id
    }
}

=======
    public List<Cliente> listarClientes(int page, int size, String legajo) {
        Pageable pageable = PageRequest.of(page, size);
        if (legajo != null && !legajo.isEmpty()) {
            return repositorio.findByLegajoContaining(legajo, pageable).getContent();
        }
        return repositorio.findAll(pageable).getContent();
    }

    @Override
    public long contarClientes(String legajo) {
        if (legajo != null && !legajo.isEmpty()) {
            return repositorio.countByLegajoContaining(legajo); // Corregido el nombre de variable
        }
        return repositorio.count();
    }
}
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd
