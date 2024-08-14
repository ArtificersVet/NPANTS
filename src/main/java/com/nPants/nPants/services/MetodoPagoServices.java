package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.MetodoPago;
import com.nPants.nPants.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServices {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> listarTodas() {
        return metodoPagoRepository.findAll();
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
}
