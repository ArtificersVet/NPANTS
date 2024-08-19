package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.TipoPrendaVestir;
import com.nPants.nPants.services.TipoPrendaVestirServices; // Asegúrate de tener este servicio

@Controller
@RequestMapping("tipos-prendas") // Ajusta el mapeo si es necesario
public class TipoPrendaVestirController {

    @Autowired
    private TipoPrendaVestirServices tipoPrendaVestirService; // Inyecta tu servicio TipoPrendaVestirService

    @GetMapping()
    public String listarTiposPrendas(Model model) {
        model.addAttribute("tiposPrendas", tipoPrendaVestirService.listarTodas()); // Usa el método del servicio
        return "tipos-prendas/tipos-prendas-list"; // Ajusta el nombre de la vista
    }

    @GetMapping("nuevo")
    public String showNewTipoPrendaVestir(Model model) {
        model.addAttribute("tipoPrendaVestir", new TipoPrendaVestir());
        return "tipos-prendas/tipo-prenda-form"; // Ajusta el nombre de la vista
    }

    @PostMapping
    public String saveTipoPrendaVestir(TipoPrendaVestir tipoPrendaVestir) {
        tipoPrendaVestirService.guardar(tipoPrendaVestir); 
        return "redirect:/tipos-prendas";
    }

    @GetMapping("/editar/{id}")
    public String showEditTipoPrendaVestir(@PathVariable Long id, Model model) {
        model.addAttribute("tipoPrendaVestir", tipoPrendaVestirService.ontenerPorId(id)); 
        return "tipos-prendas/tipo-prenda-form"; 
    }

    @GetMapping("/eliminar/{id}")
    public String deleteTipoPrendaVestir(@PathVariable Long id) {
        tipoPrendaVestirService.eliminar(id); 
        return "redirect:/tipos-prendas";
    }
}
