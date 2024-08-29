package com.nPants.nPants.Controllers;

import com.nPants.nPants.Models.Tela;
import com.nPants.nPants.services.TelaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("tela")
public class TelaController
{
    @Autowired
    public TelaServices telaServices;

    @GetMapping
    public String listarTodas(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
    @RequestParam(defaultValue = "") String nombre,Model model) {

         Page<Tela> telas;
        if (nombre.isEmpty()) {
            telas = telaServices.listarTodas(page, size);
        } else {
            telas = telaServices.buscarPorNombre(nombre, page, size);
        }
        model.addAttribute("tela", telas.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", telas.getTotalPages());
        model.addAttribute("totalItems", telas.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("nombre", nombre);
        return "tela/tela-list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaTela(Model model) {
        model.addAttribute("tela", new Tela());
        return "tela/tela-form";
    }

    @PostMapping
    public String guardar(Tela tela) {
        telaServices.guardar(tela);
        return "redirect:/tela";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTela(@PathVariable Long id, Model model) {
        model.addAttribute("tela", telaServices.ontenerPorId(id));
        return "tela/tela-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        telaServices.eliminar(id);
        return "redirect:/tela";
    }
}
