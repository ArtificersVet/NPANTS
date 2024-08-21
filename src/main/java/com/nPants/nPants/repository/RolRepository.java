package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    // Método para buscar roles por nombre con paginación
    Page<Rol> findByNombreContaining(String nombre, Pageable pageable);
}
