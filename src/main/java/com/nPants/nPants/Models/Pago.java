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
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Pedido_id")
    private Pedido pedidoid;

    private LocalDate fechaPago;

    private Double monto;

    @OneToMany
    @JoinColumn(name = "MetodoPago_id")
    private MetodoPago metodoPago;
}
