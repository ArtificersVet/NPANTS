package com.nPants.nPants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nPants.nPants.Models.Usuario;
import com.nPants.nPants.services.RolServices;
import com.nPants.nPants.services.UsuarioServices;
import com.nPants.nPants.services.UsuarioServicess.sha256;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private RolServices rolServices;

    @GetMapping
    public String ListUsers(Model model) {

        model.addAttribute("usuarios", usuarioServices.listarTodas());
        return "usuario/usuario-list";
    }

    @GetMapping("nuevo")
    public String ShowCreateUser(Model model) {

        model.addAttribute("usuarios", new Usuario());
        model.addAttribute("roles", rolServices.listarTodas(0, 10)); // Fetch the first page with 10 roles per page.


        return "usuario/usuario-form";
    }

    @PostMapping
    public String SaveUser(Usuario usuario) {
        // Encriptar la contraseña antes de guardar el usuario
        // String hashedPassword = sha256.hashPassword(usuario.getPassword());
        // usuario.setPassword(hashedPassword);
        usuarioServices.guardar(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("editar/{id}")
    public String ShowEditUser(@PathVariable Long id, Model model) {

        model.addAttribute("usuarios", usuarioServices.ontenerPorId(id));
        model.addAttribute("roles", rolServices.listarTodas(0, 10)); // Fetch the first page with 10 roles per page.


        return "usuario/usuario-form"; 
    }

    @GetMapping("eliminar/{id}")
    public String DeleteUser(@PathVariable Long id) {

        usuarioServices.eliminar(id);
        return "redirect:/usuario";
    }

}
