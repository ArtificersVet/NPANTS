package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.MetodoPago;
import com.nPants.nPants.services.MetodoPagoServices; // Make sure you have a MetodoPagoService

@Controller
@RequestMapping("metodos-pago") // Adjust the mapping if needed
public class MetodoPagoController {

    @Autowired
    private MetodoPagoServices metodoPagoService; 

    @GetMapping()
    public String listarMetodosPago(Model model) {
        model.addAttribute("metodosPago", metodoPagoService.listarTodas());
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
