package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Tela;
import com.nPants.nPants.repository.TelaRepository;

@Service
public class TelaServices {


    @Autowired
    private TelaRepository telaRepository;

    public List<Tela> listarTodas() {
        return telaRepository.findAll();
    }

    public Tela guardar (Tela tela) {
        return telaRepository.save(tela);
    }

    public Tela ontenerPorId (Long id) {
        return telaRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        telaRepository.deleteById(id);
    }
}
