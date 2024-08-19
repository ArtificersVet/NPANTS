package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  

import org.springframework.web.bind.annotation.GetMapping;  

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 


import com.nPants.nPants.Models.EstadoPedido;
import com.nPants.nPants.services.*;

@Controller
@RequestMapping("estados-pedido") 
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoServices estadoPedidoService;

    @GetMapping()
    public String listarEstadosPedido(Model model) {
        model.addAttribute("estadosPedido", estadoPedidoService.listarTodas()); 
        return "estados-pedido/estados-pedido-list"; 
    }

    @GetMapping("nuevo")
    public String showNewEstadoPedido(Model model) {
        model.addAttribute("estadoPedido", new EstadoPedido());
        return "estados-pedido/estado-pedido-form"; 
    }

    @PostMapping
    public String saveEstadoPedido(EstadoPedido estadoPedido) {
        estadoPedidoService.guardar(estadoPedido); 
        return "redirect:/estados-pedido";
    }

    @GetMapping("/editar/{id}")
    public String showEditEstadoPedido(@PathVariable Long id, Model model) {
        model.addAttribute("estadoPedido", estadoPedidoService.ontenerPorId(id));
        return "estados-pedido/estado-pedido-form";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEstadoPedido(@PathVariable Long id) {
        estadoPedidoService.eliminar(id); 
        return "redirect:/estados-pedido";
    }
}
