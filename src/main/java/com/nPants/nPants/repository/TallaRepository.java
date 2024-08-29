package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Talla;

public interface TallaRepository extends JpaRepository<Talla, Long> {
    Page<Talla> findByNombreContaining(String nombre, Pageable pageable);
}
