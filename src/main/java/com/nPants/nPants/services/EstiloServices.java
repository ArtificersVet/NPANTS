package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Estilo;
import com.nPants.nPants.repository.EstiloRepository;

@Service
public class EstiloServices {

    @Autowired
    private EstiloRepository estiloRepository;

    public List<Estilo> listarTodas() {
        return estiloRepository.findAll();
    }

    public Estilo guardar (Estilo estilo) {
        return estiloRepository.save(estilo);
    }

    public Estilo ontenerPorId (Long id) {
        return estiloRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        estiloRepository.deleteById(id);
    }

}
