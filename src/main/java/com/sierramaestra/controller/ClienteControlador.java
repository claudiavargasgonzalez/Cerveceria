package com.sierramaestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sierramaestra.model.Cliente;
import com.sierramaestra.service.ClienteServicio;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/clientes")
    public String listarClientes(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(required = false) String legajo,
                                 Model model) {
        int pageSize = 10; // Tamaño de página
        long totalClientes = servicio.contarClientes(legajo);
        int totalPages = (int) Math.ceil((double) totalClientes / pageSize);
        
        List<Cliente> clientes = servicio.listarClientes(page, pageSize, legajo);
        
        model.addAttribute("clientes", clientes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("legajo", legajo);
        
        return "clientes"; // Nombre de la vista
    }
    
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/clientes/nuevo")
    public String crearClienteFormulario(Model model) {
    	Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @PostMapping("/clientes/guardar")
    public String guardarClientes(@ModelAttribute Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "crear_cliente";
        }
    
        // Aquí se confía en el valor recibido desde el formulario, sin cambiar el estado de 'activo'.
        servicio.guardarClientes(cliente);
    
        return "redirect:/clientes";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", servicio.obtenerClientePorId(id));
        return "editar_cliente";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente, Model model) {
    	Cliente clienteExistente = servicio.obtenerClientePorId(id);
<<<<<<< HEAD
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setFechaRegistro(cliente.getFechaRegistro());

=======
    	clienteExistente.setId(id);
    	clienteExistente.setLegajo(cliente.getLegajo());
    	clienteExistente.setNombre(cliente.getNombre());
    	clienteExistente.setApellido(cliente.getApellido());
    	clienteExistente.setDni(cliente.getDni());
    	clienteExistente.setEmail(cliente.getEmail());
    	clienteExistente.setTipo(cliente.getTipo());
    	clienteExistente.setActivo(cliente.isActivo());
>>>>>>> 004def38029f3e287e3637db4dcc0b1948d275cd

        servicio.actualizarCliente(clienteExistente);
        return "redirect:/clientes";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        servicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    // Nuevo método para mostrar el menú principal
    @GetMapping("/menu-principal-cliente")
    public String mostrarMenuPrincipal() {
        return "menu-principal"; // Retorna el archivo menu-principal.html
    }
}