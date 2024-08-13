package com.nPants.nPants.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DetallesPedidoTalla") 
public class DetallesPedidoTalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long detallesPedidoId;

    private int tallaId;

    private int cantidadPieza;

    private BigDecimal consumoTela;

    @ManyToOne
    @JoinColumn(name = "detalles_pedido_id", referencedColumnName = "id") 
    private DetallesPedido detallesPedido;

}
