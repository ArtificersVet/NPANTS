package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.EstiloTalla;
import com.nPants.nPants.repository.EstiloTallaRepository;

@Service
public class EstiloTallaServices {

    @Autowired
    private EstiloTallaRepository estiloTallaRepository;

    public List<EstiloTalla> listarTodas() {
        return estiloTallaRepository.findAll();
    }

    public EstiloTalla guardar (EstiloTalla estiloTalla) {
        return estiloTallaRepository.save(estiloTalla);
    }

    public EstiloTalla ontenerPorId (Long id) {
        return estiloTallaRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        estiloTallaRepository.deleteById(id);
    }

}
