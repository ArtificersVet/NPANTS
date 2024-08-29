package com.nPants.nPants.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.nPants.nPants.Models.PrendaVestir;
import com.nPants.nPants.repository.PrendaVestirRepository;

@Service
public class PrendaVestirServices {


    @Autowired
    private PrendaVestirRepository prendaVestirRepository;

    public Page<PrendaVestir> listarTodas(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return prendaVestirRepository.findAll(pageable);
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
     public Page<PrendaVestir> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return prendaVestirRepository.findByNombreContaining(nombre, pageable);
    }
}
