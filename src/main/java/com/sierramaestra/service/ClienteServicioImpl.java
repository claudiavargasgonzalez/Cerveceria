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
    public List<Cliente> listarTodosLosCLientes() {
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
