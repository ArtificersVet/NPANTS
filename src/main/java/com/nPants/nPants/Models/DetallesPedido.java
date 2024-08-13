package com.nPants.nPants.Models;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DetallesPedido") 
public class DetallesPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id") 
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "prenda_vestir_id", referencedColumnName = "id") 
    private PrendaVestir prendaVestir;

    private BigDecimal precioUnitario;

    private String descripcion;

    private BigDecimal subTotal;

    private int totalPieza;
}
