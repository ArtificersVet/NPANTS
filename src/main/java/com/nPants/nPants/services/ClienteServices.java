package com.nPants.nPants.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nPants.nPants.Models.Cliente;
import com.nPants.nPants.repository.ClienteRepository;


@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> listarTodas(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clienteRepository.findAll(pageable);
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

    public Page<Cliente> buscarPorNombre(String nombre, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clienteRepository.findByNombreContaining(nombre, pageable);
    }
}
