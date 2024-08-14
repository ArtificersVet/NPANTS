package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nPants.nPants.Models.TipoPrendaVestir;
import com.nPants.nPants.repository.TipoPrendaVestirRepository;

@Service
public class TipoPrendaVestirServices {


    @Autowired
    private TipoPrendaVestirRepository tipoPrendaVestirRepository;

    public List<TipoPrendaVestir> listarTodas() {
        return tipoPrendaVestirRepository.findAll();
    }

    public TipoPrendaVestir guardar (TipoPrendaVestir tipoPrendaVestir) {
        return tipoPrendaVestirRepository.save(tipoPrendaVestir);
    }

    public TipoPrendaVestir ontenerPorId (Long id) {
        return tipoPrendaVestirRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        tipoPrendaVestirRepository.deleteById(id);
    }
}
