package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nPants.nPants.Models.Rol;
import com.nPants.nPants.repository.RolRepository;

@Service
public class RolServices {

    @Autowired
    private RolRepository rolRepository;

    public Page<Rol> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return rolRepository.findAll(pageable);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol ontenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

    public Page<Rol> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return rolRepository.findByNombreContaining(nombre, pageable);
    }
}
