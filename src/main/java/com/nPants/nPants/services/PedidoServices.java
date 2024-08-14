package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Pedido;
import com.nPants.nPants.repository.PedidoRepository;

@Service
public class PedidoServices {


    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodas() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar (Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido ontenerPorId (Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        pedidoRepository.deleteById(id);
    }
}
