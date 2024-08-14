package com.nPants.nPants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   
}
