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

import com.nPants.nPants.Models.Talla;
import com.nPants.nPants.services.*; 

@Controller
@RequestMapping("/tallas") 
public class TallaController {

    @Autowired
    private TallaServices tallaService; 

    @GetMapping()
    public String listarTodas(@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "") String nombre,Model model) {

         Page<Talla> tallas;
        if (nombre.isEmpty()) {
            tallas = tallaService.listarTodas(page, size);
        } else {
            tallas = tallaService.buscarPorNombre(nombre, page, size);
        }
        model.addAttribute("tallas", tallas.getContent()); 
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", tallas.getTotalPages());
        model.addAttribute("totalItems", tallas.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("nombre", nombre);
        return "tallas/tallas-list"; 
    }

    @GetMapping("nuevo")
    public String showNewTalla(Model model) {
        model.addAttribute("talla", new Talla());
        return "tallas/talla-form"; 
    }

    @PostMapping
    public String saveTalla(Talla talla) {
        tallaService.guardar(talla); 
        return "redirect:/tallas";
    }

    @GetMapping("/editar/{id}")
    public String showEditTalla(@PathVariable Long id, Model model) {
        model.addAttribute("talla", tallaService.ontenerPorId(id)); 
        return "tallas/talla-form"; 
    }

    @GetMapping("/eliminar/{id}")
    public String deleteTalla(@PathVariable Long id) {
        tallaService.eliminar(id); 
        return "redirect:/tallas";
    }
}