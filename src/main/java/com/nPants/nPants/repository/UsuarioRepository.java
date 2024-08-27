package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.nPants.nPants.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// Método para buscar roles por nombre con paginación
    Page<Usuario> findByNombreContaining(String nombre, Pageable pageable);
}
