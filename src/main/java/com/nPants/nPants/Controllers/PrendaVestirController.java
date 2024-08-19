package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.PrendaVestir;
import com.nPants.nPants.services.EstiloServices;
import com.nPants.nPants.services.PrendaVestirServices;
import com.nPants.nPants.services.TelaServices;
import com.nPants.nPants.services.TipoPrendaVestirServices;

@Controller
@RequestMapping("prendas")
public class PrendaVestirController {

    @Autowired
    private PrendaVestirServices prendaVestirService;

    @Autowired
    private TipoPrendaVestirServices tipoPrendaVestirService;

    @Autowired
    private TelaServices telaService;

    @Autowired
    private EstiloServices estiloService;

    @GetMapping
    public String listarPrendas(Model model) {
        model.addAttribute("prendas", prendaVestirService.listarTodas()); 
        return "prendas/prendas-list";
    }

    @GetMapping("nuevo")
    public String showNewPrendaVestir(Model model) {
        model.addAttribute("prenda", new PrendaVestir());
        model.addAttribute("telas", telaService.listarTodas());
        model.addAttribute("estilos", estiloService.listarTodas());
        model.addAttribute("tiposPrenda", tipoPrendaVestirService.listarTodas());
        return "prendas/prenda-form";
    }

    @PostMapping
    public String savePrendaVestir(PrendaVestir prendaVestir) {
        prendaVestirService.guardar(prendaVestir);
        return "redirect:/prendas";
    }

    @GetMapping("/editar/{id}")
    public String editarPrenda(@PathVariable("id") Long id, Model model) {
        PrendaVestir prenda = prendaVestirService.ontenerPorId(id);
        model.addAttribute("prenda", prenda);
        model.addAttribute("telas", telaService.listarTodas());
        model.addAttribute("estilos", estiloService.listarTodas());
        model.addAttribute("tiposPrenda", tipoPrendaVestirService.listarTodas());
        return "prendas/prenda-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrenda(@PathVariable Long id) {
        prendaVestirService.eliminar(id);
        return "redirect:/prendas";
    }
}
