package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Talla;
import com.nPants.nPants.repository.TallaRepository;

@Service
public class TallaServices {

    @Autowired
    private TallaRepository tallaRepository;

    public List<Talla> listarTodas() {
        return tallaRepository.findAll();
    }

    public Talla guardar (Talla talla) {
        return tallaRepository.save(talla);
    }

    public Talla ontenerPorId (Long id) {
        return tallaRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        tallaRepository.deleteById(id);
    }
}
