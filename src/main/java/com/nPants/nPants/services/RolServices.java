package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Rol;
import com.nPants.nPants.repository.RolRepository;

@Service
public class RolServices {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodas() {
        return rolRepository.findAll();
    }

    public Rol guardar (Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol ontenerPorId (Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        rolRepository.deleteById(id);
    }

}
