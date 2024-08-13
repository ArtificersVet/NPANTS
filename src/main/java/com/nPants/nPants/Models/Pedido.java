package com.nPants.nPants.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteid;

    private LocalDate fechaPedido;

    private double total;

    private double saldo;

    private byte tipoPago;

    @OneToMany
    @JoinColumn(name = "estado_pedido_id", referencedColumnName = "id")
    private int estadoPedidoid;
    
}
