package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.EstadoPedido;
import com.nPants.nPants.repository.EstadoPedidoRepository;

@Service
public class EstadoPedidoServices {

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    public List<EstadoPedido> listarTodas() {
        return estadoPedidoRepository.findAll();
    }

    public EstadoPedido guardar (EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    public EstadoPedido ontenerPorId (Long id) {
        return estadoPedidoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        estadoPedidoRepository.deleteById(id);
    }

}
