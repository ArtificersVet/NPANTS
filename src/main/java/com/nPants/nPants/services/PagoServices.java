package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Pago;
import com.nPants.nPants.repository.PagoRepository;

@Service
public class PagoServices {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> listarTodas() {
        return pagoRepository.findAll();
    }

    public Pago guardar (Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago ontenerPorId (Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        pagoRepository.deleteById(id);
    }

}
