package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.PrendaVestir;
import com.nPants.nPants.repository.PrendaVestirRepository;

@Service
public class PrendaVestirServices {


    @Autowired
    private PrendaVestirRepository prendaVestirRepository;

    public List<PrendaVestir> listarTodas() {
        return prendaVestirRepository.findAll();
    }

    public PrendaVestir guardar (PrendaVestir prendaVestir) {
        return prendaVestirRepository.save(prendaVestir);
    }

    public PrendaVestir ontenerPorId (Long id) {
        return prendaVestirRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        prendaVestirRepository.deleteById(id);
    }
}
