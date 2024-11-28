package com.sierramaestra.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedidoController {

    // Muestra el formulario
    @GetMapping("/formulario-pedido")
    public String mostrarFormulario() {
        return "formulario-pedido";
    }

    // Procesa el formulario
    @PostMapping("/procesar-pedido")
    public String procesarFormulario(
            @RequestParam("cerveza") String cerveza,
            @RequestParam("cliente") String cliente,
            Model model) {
        // Agrega los datos al modelo para mostrarlos en la vista
        model.addAttribute("cerveza", cerveza);
        model.addAttribute("cliente", cliente);
        return "formulario-pedido";
    }
}
