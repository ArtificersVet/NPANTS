package com.nPants.nPants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nPants.nPants.Models.EstadoPedido;

public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Long> {
// Método para buscar TipoCliente por nombre con paginación
Page<EstadoPedido> findByNombreContaining(String nombre, Pageable pageable);
}
