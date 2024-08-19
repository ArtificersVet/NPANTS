package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  

import org.springframework.web.bind.annotation.GetMapping; 

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.nPants.nPants.Models.Talla;
import com.nPants.nPants.services.*; 

@Controller
@RequestMapping("/tallas") 
public class TallaController {

    @Autowired
    private TallaServices tallaService; 

    @GetMapping()
    public String listarTallas(Model model) {
        model.addAttribute("tallas", tallaService.listarTodas()); 
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