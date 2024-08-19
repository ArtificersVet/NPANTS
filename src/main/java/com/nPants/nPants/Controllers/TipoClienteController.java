package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.TipoCliente;
import com.nPants.nPants.services.TipoClienteServices; // Asegúrate de tener este servicio

@Controller
@RequestMapping("tipos-clientes")
public class TipoClienteController {

    @Autowired
    private TipoClienteServices tipoClienteService; // Inyecta tu servicio TipoClienteService

    @GetMapping()
    public String listarTiposClientes(Model model) {
        model.addAttribute("tiposClientes", tipoClienteService.listarTodas()); // Usa el método del servicio
        return "tipos-clientes/tipos-clientes-list"; // Ajusta el nombre de la vista
    }

    @GetMapping("nuevo")
    public String showNewTipoCliente(Model model) {
        model.addAttribute("tipoCliente", new TipoCliente());
        return "tipos-clientes/tipo-cliente-form"; // Ajusta el nombre de la vista
    }

    @PostMapping
    public String saveTipoCliente(TipoCliente tipoCliente) {
        tipoClienteService.guardar(tipoCliente); 
        return "redirect:/tipos-clientes";
    }

    @GetMapping("/editar/{id}")
    public String showEditTipoCliente(@PathVariable Long id, Model model) {
        model.addAttribute("tipoCliente", tipoClienteService.ontenerPorId(id)); 
        return "tipos-clientes/tipo-cliente-form"; 
    }

    @GetMapping("/eliminar/{id}")
    public String deleteTipoCliente(@PathVariable Long id) {
        tipoClienteService.eliminar(id); 
        return "redirect:/tipos-clientes";
    }
}
