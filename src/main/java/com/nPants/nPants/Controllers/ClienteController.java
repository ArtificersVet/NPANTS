package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.Cliente;
import com.nPants.nPants.services.ClienteServices; // Asegúrate de tener este servicio
import com.nPants.nPants.services.TipoClienteServices; // Asegúrate de tener este servicio

@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteServices clienteService; // Inyecta tu servicio ClienteService

    @Autowired
    private TipoClienteServices tipoClienteService; // Inyecta tu servicio TipoClienteService

    @GetMapping()
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodas()); // Usa el método del servicio
        return "clientes/clientes-list"; // Ajusta el nombre de la vista
    }

    @GetMapping("nuevo")
    public String showNewCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("tiposClientes", tipoClienteService.listarTodas()); // Para el dropdown de tipoCliente
        return "clientes/cliente-form"; // Ajusta el nombre de la vista
    }

    @PostMapping
    public String saveCliente(Cliente cliente) {
        clienteService.guardar(cliente); 
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String showEditCliente(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.ontenerPorId(id)); 
        model.addAttribute("tiposClientes", tipoClienteService.listarTodas()); // Para el dropdown de tipoCliente
        return "clientes/cliente-form"; 
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.eliminar(id); 
        return "redirect:/clientes";
    }
}
