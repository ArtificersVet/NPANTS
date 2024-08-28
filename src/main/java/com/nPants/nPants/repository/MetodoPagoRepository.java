package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
// Método para buscar usuario por nombre con paginación
    Page<MetodoPago> findByNombreContaining(String nombre, Pageable pageable);
}
