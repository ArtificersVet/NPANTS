package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.TipoCliente;
import com.nPants.nPants.repository.TipoClienteRepository;

@Service
public class TipoClienteServices {

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    public List<TipoCliente> listarTodas() {
        return tipoClienteRepository.findAll();
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
}
