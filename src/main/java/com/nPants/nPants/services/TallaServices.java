package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.nPants.nPants.Models.Talla;
import com.nPants.nPants.repository.TallaRepository;

@Service
public class TallaServices {

    @Autowired
    private TallaRepository tallaRepository;

    public List<Talla> listarTallas() {
        return tallaRepository.findAll();
    }

    public Page<Talla> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return tallaRepository.findAll(pageable);
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
    public Page<Talla> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return tallaRepository.findByNombreContaining(nombre, pageable);
    }
}
