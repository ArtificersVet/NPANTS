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

import com.nPants.nPants.Models.MetodoPago;
import com.nPants.nPants.services.MetodoPagoServices; // Make sure you have a MetodoPagoService

@Controller
@RequestMapping("metodos-pago") // Adjust the mapping if needed
public class MetodoPagoController {

    @Autowired
    private MetodoPagoServices metodoPagoService; 

    @GetMapping()
    public String listarMetodosPago( @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "") String nombre,
        Model model) {

            Page<MetodoPago> metodopago;
        if (nombre.isEmpty()) {
            metodopago = metodoPagoService.listarTodas(page, size);
        } else {
            metodopago = metodoPagoService.buscarPorNombre(nombre, page, size);
        }
       
        model.addAttribute("metodosPago", metodopago.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", metodopago.getTotalPages());
        model.addAttribute("totalItems", metodopago.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("nombre", nombre);
        return "metodos-pago/metodos-pago-list"; 
    }

    @GetMapping("nuevo")
    public String showNewMetodoPago(Model model) {
        model.addAttribute("metodoPago", new MetodoPago());
        return "metodos-pago/metodo-pago-form"; 
    }

    @PostMapping
    public String saveMetodoPago(MetodoPago metodoPago) {
        metodoPagoService.guardar(metodoPago);
        return "redirect:/metodos-pago";
    }

    @GetMapping("/editar/{id}")
    public String showEditMetodoPago(@PathVariable Long id, Model model) {
        model.addAttribute("metodoPago", metodoPagoService.ontenerPorId(id)); 
        return "metodos-pago/metodo-pago-form";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteMetodoPago(@PathVariable Long id) {
        metodoPagoService.eliminar(id); 
        return "redirect:/metodos-pago";
    }
}
