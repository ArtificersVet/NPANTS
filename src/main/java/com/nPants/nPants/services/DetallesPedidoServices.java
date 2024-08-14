package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.DetallesPedido;
import com.nPants.nPants.repository.DetallesPedidoRepository;

@Service
public class DetallesPedidoServices {

    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    public List<DetallesPedido> listarTodas() {
        return detallesPedidoRepository.findAll();
    }

    public DetallesPedido guardar (DetallesPedido detallesPedido) {
        return detallesPedidoRepository.save(detallesPedido);
    }

    public DetallesPedido ontenerPorId (Long id) {
        return detallesPedidoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        detallesPedidoRepository.deleteById(id);
    }

}
