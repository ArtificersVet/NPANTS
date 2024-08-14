package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.HistorialPedido;
import com.nPants.nPants.repository.HistorialPedidoRepository;

@Service
public class HistorialPedidoServices {

    @Autowired
    private HistorialPedidoRepository historialPedidoRepository;

    public List<HistorialPedido> listarTodas() {
        return historialPedidoRepository.findAll();
    }

    public HistorialPedido guardar (HistorialPedido historialPedido) {
        return historialPedidoRepository.save(historialPedido);
    }

    public HistorialPedido ontenerPorId (Long id) {
        return historialPedidoRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        historialPedidoRepository.deleteById(id);
    }

}
