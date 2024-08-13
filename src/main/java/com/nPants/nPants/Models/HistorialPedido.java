package com.nPants.nPants.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class HistorialPedido {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedidoid;

    private LocalDateTime fecha;

    private String comentario;

    @OneToOne
    @JoinColumn(name = "estadopedido_id")
    private EstadoPedido estadoPedidoid;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioid;
}
