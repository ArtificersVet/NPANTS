package com.nPants.nPants.services;


import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.TipoCliente;
import com.nPants.nPants.repository.TipoClienteRepository;

@Service
public class TipoClienteServices {

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    public Page<TipoCliente> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return tipoClienteRepository.findAll(pageable);
    }

    public TipoCliente guardar (TipoCliente tipoCliente) {
        return tipoClienteRepository.save(tipoCliente);
    }

    public TipoCliente ontenerPorId (Long id) {
        return tipoClienteRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        tipoClienteRepository.deleteById(id);
    }
    public Page<TipoCliente> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return tipoClienteRepository.findByNombreContaining(nombre, pageable);
    }
}
