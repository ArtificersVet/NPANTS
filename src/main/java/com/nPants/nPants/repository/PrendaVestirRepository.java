package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.PrendaVestir;
public interface PrendaVestirRepository extends JpaRepository<PrendaVestir, Long> {
    // Método para buscar roles por nombre con paginación
    Page<PrendaVestir> findByNombreContaining(String nombre, Pageable pageable);
}
