package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Tela;

public interface TelaRepository extends JpaRepository<Tela, Long> {
    Page<Tela> findByNombreContaining(String nombre, Pageable pageable);
}
