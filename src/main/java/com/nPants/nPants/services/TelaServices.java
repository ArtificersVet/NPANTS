package com.nPants.nPants.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import com.nPants.nPants.Models.Tela;
import com.nPants.nPants.repository.TelaRepository;

@Service
public class TelaServices {


    @Autowired
    private TelaRepository telaRepository;

    public List<Tela> listarTelas() {
        return telaRepository.findAll();
    }
    public Page<Tela> listarTodas(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return telaRepository.findAll(pageable);
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

    public Page<Tela> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return telaRepository.findByNombreContaining(nombre, pageable);
    }
}
