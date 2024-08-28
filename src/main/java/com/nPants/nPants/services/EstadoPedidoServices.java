package com.nPants.nPants.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.EstadoPedido;
import com.nPants.nPants.repository.EstadoPedidoRepository;

@Service
public class EstadoPedidoServices {

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    public Page<EstadoPedido> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return estadoPedidoRepository.findAll(pageable);
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
 public Page<EstadoPedido> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return estadoPedidoRepository.findByNombreContaining(nombre, pageable);
    }
}
