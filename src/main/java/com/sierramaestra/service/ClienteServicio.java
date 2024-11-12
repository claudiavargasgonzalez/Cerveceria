package com.sierramaestra.service;

import java.util.List;

import com.sierramaestra.model.Cliente;

public interface ClienteServicio {

    public List<Cliente> listarTodosLosCLientes();
    
    public Cliente guardarClientes(Cliente cliente);
    
    public Cliente obtenerClientePorId(Long id);
    
    public Cliente actualizarCliente(Cliente cliente);
    	
    public void eliminarCliente(Long id);

    // Métodos del servicio, como contarUsuarios y listarUsuarios
    public long contarClientes(String legajo);

    public List<Cliente> listarClientes(int page, int pageSize, String legajo);

	
}
