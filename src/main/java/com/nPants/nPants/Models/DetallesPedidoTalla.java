package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalles_pedido_talla")
public class DetallesPedidoTalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private int tallaId;

    @Nonnull
    private int cantidadPieza;

    @Nonnull
    private BigDecimal consumoTela;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "detalles_pedido_id", referencedColumnName = "id")
    private DetallesPedido detallesPedido;

    public DetallesPedidoTalla() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTallaId() {
        return tallaId;
    }

    public void setTallaId(int tallaId) {
        this.tallaId = tallaId;
    }

    public int getCantidadPieza() {
        return cantidadPieza;
    }

    public void setCantidadPieza(int cantidadPieza) {
        this.cantidadPieza = cantidadPieza;
    }

    public BigDecimal getConsumoTela() {
        return consumoTela;
    }

    public void setConsumoTela(BigDecimal consumoTela) {
        this.consumoTela = consumoTela;
    }

    public DetallesPedido getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(DetallesPedido detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
