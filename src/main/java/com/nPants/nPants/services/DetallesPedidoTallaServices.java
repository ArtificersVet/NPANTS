package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.DetallesPedidoTalla;
import com.nPants.nPants.repository.DetallesPedidoTallaRepository;

@Service
public class DetallesPedidoTallaServices {

    @Autowired
    private DetallesPedidoTallaRepository detallesPedidoTallaRepository;

    public List<DetallesPedidoTalla> listarTodas() {
        return detallesPedidoTallaRepository.findAll();
    }

    public DetallesPedidoTalla guardar (DetallesPedidoTalla detallesPedidoTalla) {
        return detallesPedidoTallaRepository.save(detallesPedidoTalla);
    }

    public DetallesPedidoTalla ontenerPorId (Long id) {
        return detallesPedidoTallaRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        detallesPedidoTallaRepository.deleteById(id);
    }
 
}
