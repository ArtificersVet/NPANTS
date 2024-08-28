package com.nPants.nPants.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.MetodoPago;
import com.nPants.nPants.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServices {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public Page<MetodoPago> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return metodoPagoRepository.findAll(pageable);
    }

    public MetodoPago guardar (MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago ontenerPorId (Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        metodoPagoRepository.deleteById(id);
    }
    public Page<MetodoPago> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return metodoPagoRepository.findByNombreContaining(nombre, pageable);
    }
}
