package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   // Método para cliente por nombre con paginación
    Page<Cliente> findByNombreContaining(String nombre, Pageable pageable);
}
