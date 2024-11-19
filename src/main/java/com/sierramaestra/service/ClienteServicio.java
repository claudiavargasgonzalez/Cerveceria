package com.sierramaestra.service;

import java.util.List;

import com.sierramaestra.model.Cliente;

public interface ClienteServicio {

    public List<Cliente> listarTodosLosClientes();  // Cambié el nombre para que coincida con el de la clase

    public Cliente guardarClientes(Cliente cliente);

    public Cliente obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Cliente cliente);

    public void eliminarCliente(Long id);

    // Métodos del servicio, como contarClientes y listarClientes
    public long contarClientes(String id);  // Cambié 'legajo' a 'id'

    public List<Cliente> listarClientes(int page, int pageSize, String id);  // Cambié 'legajo' a 'id'
}

