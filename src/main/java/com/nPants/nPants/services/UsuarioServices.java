package com.nPants.nPants.services;



import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Usuario;
import com.nPants.nPants.repository.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return usuarioRepository.findAll(pageable);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario ontenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    public Page<Usuario> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return usuarioRepository.findByNombreContaining(nombre, pageable);
    }
}
