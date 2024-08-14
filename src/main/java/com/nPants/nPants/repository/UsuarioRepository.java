package com.nPants.nPants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
