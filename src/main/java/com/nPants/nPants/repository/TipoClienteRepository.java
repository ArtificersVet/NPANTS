package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {
// Método para buscar TipoCliente por nombre con paginación
Page<TipoCliente> findByNombreContaining(String nombre, Pageable pageable);
}
