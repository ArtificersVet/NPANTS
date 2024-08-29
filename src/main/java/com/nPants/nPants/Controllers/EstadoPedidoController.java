package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  

import org.springframework.web.bind.annotation.GetMapping;  

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nPants.nPants.Models.EstadoPedido;
import com.nPants.nPants.services.*;

@Controller
@RequestMapping("estados-pedido") 
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoServices estadoPedidoService;

    @GetMapping()
    public String listarEstadosPedido(@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "") String nombre,Model model) {


             Page<EstadoPedido> estadopedido;
        if (nombre.isEmpty()) {
            estadopedido = estadoPedidoService.listarTodas(page, size);
        } else {
            estadopedido = estadoPedidoService.buscarPorNombre(nombre, page, size);
        }

        model.addAttribute("estadosPedido", estadopedido.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", estadopedido.getTotalPages());
        model.addAttribute("totalItems", estadopedido.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("nombre", nombre);
        
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
