package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Usuario;
import com.nPants.nPants.repository.UsuarioRepository;


@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodas() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario ontenerPorId (Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        usuarioRepository.deleteById(id);
    }
}
