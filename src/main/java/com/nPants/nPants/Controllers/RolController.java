package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;



import com.nPants.nPants.Models.Rol;
import com.nPants.nPants.services.RolServices;

@Controller
@RequestMapping("rol")
public class RolController {

    @Autowired
    private RolServices rolService;

    @GetMapping
    public String listarRol(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "") String nombre,
        Model model) {
        
        Page<Rol> roles;
        if (nombre.isEmpty()) {
            roles = rolService.listarTodas(page, size);
        } else {
            roles = rolService.buscarPorNombre(nombre, page, size);
        }

        model.addAttribute("roles", roles.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", roles.getTotalPages());
        model.addAttribute("totalItems", roles.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("nombre", nombre);
        
        return "rol/rol-list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol/rol-forn";
    }

    @PostMapping
    public String guardarRol(Rol roles) {
        rolService.guardar(roles);
        return "redirect:/rol";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarRol(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.ontenerPorId(id));
        return "rol/rol-forn";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/rol";
    }

}
