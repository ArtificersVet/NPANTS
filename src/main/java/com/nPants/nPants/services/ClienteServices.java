package com.nPants.nPants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Cliente;
import com.nPants.nPants.repository.ClienteRepository;


@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodas() {
        return clienteRepository.findAll();
    }

    public Cliente guardar (Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente ontenerPorId (Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminar (Long id) {
        clienteRepository.deleteById(id);
    }

}
