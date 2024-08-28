package com.nPants.nPants.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nPants.nPants.Models.EstiloTalla;
import com.nPants.nPants.Models.Talla;
import com.nPants.nPants.services.*;

@Controller
@RequestMapping("/tallas")
public class TallaController {

    @Autowired
    private TallaServices tallaService;

    @Autowired
    private EstiloServices estiloService; // Servicio para manejar Estilo

    @GetMapping()
    public String listarTodas(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String nombre, Model model) {

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
    public String showNewTalla(@RequestParam(required = false) Long id, Model model) {
        // model.addAttribute("talla", new Talla());
        Talla talla = (id != null) ? tallaService.ontenerPorId(id) : new Talla();
        model.addAttribute("talla", talla);
        model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles
        model.addAttribute("action", "create"); // Acción para la vista de formulario
        return "tallas/talla-form";
    }

    @PostMapping("/addestilotallas")
    public String addEstiloTalla(Talla talla, Model model) {
        if (talla.getEstiloTallas() == null) {
            talla.setEstiloTallas(new ArrayList<>());
        }
        talla.getEstiloTallas().add(new EstiloTalla(talla, null, 0.0)); // Crea un nuevo EstiloTalla

        model.addAttribute("talla", talla);
        model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles}
        model.addAttribute("action", "edit"); // Acción para la vista de edición
        return "tallas/talla-form"; // Devuelve al formulario de Talla
    }

    @PostMapping("/delestilotallas/{id}")
    public String delEstiloTalla(@PathVariable("id") Long id, Talla talla, Model model) {
        talla.getEstiloTallas().removeIf(elemento -> elemento.getId().equals(id)); // Elimina el EstiloTalla con el ID
                                                                                   // dado

        model.addAttribute("talla", talla);
        model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles
        model.addAttribute("action", "edit"); // Acción para la vista de edición
        return "tallas/talla-form"; // Devuelve al formulario de Talla
    }

    @PostMapping
    public String saveTalla(Talla talla, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {


            model.addAttribute("talla", talla);
            model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            System.out.println(talla.toString()+ "@@@@@@@@@@@@@@@@@@@@@@@");
            return "tallas/talla-form";
        }
        if (talla.getEstiloTallas() != null) {
            for (EstiloTalla item : talla.getEstiloTallas()) {
                if (item.getId() != null && item.getId() < 0)
                    item.setId(null);
                item.setTalla(talla);
            }
        }

        tallaService.guardar(talla); // Guarda la Talla con sus EstiloTalla asociados
        attributes.addFlashAttribute("msg", "Talla guardada correctamente");
        return "redirect:/tallas"; // Redirige a la lista de tallas
    }

    @GetMapping("/editar/{id}")
    public String showEditTalla(@PathVariable Long id, Model model) {
        Talla talla = tallaService.ontenerPorId(id);
        model.addAttribute("talla", talla);
        model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles
        model.addAttribute("action", "edit"); // Acción para la vista de edición
        return "tallas/talla-form";
    }

    @PostMapping("/editar/{id}")
    public String editTalla(@PathVariable Long id, Talla talla, BindingResult result, Model model,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("talla", talla);
            model.addAttribute("estilos", estiloService.listarTodas()); // Lista de estilos disponibles
            attributes.addFlashAttribute("error", "No se pudo editar debido a un error.");
            return "tallas/talla-form";
        }

        talla.setId(id);
        if (talla.getEstiloTallas() != null) {
            for (EstiloTalla item : talla.getEstiloTallas()) {
                if (item.getId() != null && item.getId() < 0)
                    item.setId(null);
                item.setTalla(talla);
            }
        }

        tallaService.guardar(talla); // Guarda la Talla actualizada con sus EstiloTalla
        attributes.addFlashAttribute("msg", "Talla editada correctamente");
        return "redirect:/tallas"; // Redirige a la lista de tallas
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarTalla(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            tallaService.eliminar(id); // Elimina la Talla junto con sus EstiloTalla asociados
            attributes.addFlashAttribute("msg", "Talla eliminada correctamente.");
        } catch (Exception e) {
            attributes.addFlashAttribute("error",
                    "No se pudo eliminar la Talla. Verifica que no esté relacionada con otros registros.");
        }
        return "redirect:/tallas"; // Redirige a la lista de tallas
    }

}