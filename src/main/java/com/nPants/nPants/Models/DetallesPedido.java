package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "detalles_pedido")
public class DetallesPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "prenda_vestir_id", referencedColumnName = "id")
    private PrendaVestir prendaVestir;

    @Nonnull
    private BigDecimal precioUnitario;
    @Nonnull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    @Nonnull
    private BigDecimal subTotal;
    @Nonnull
    private int totalPieza;

    public DetallesPedido() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PrendaVestir getPrendaVestir() {
        return prendaVestir;
    }

    public void setPrendaVestir(PrendaVestir prendaVestir) {
        this.prendaVestir = prendaVestir;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public int getTotalPieza() {
        return totalPieza;
    }

    public void setTotalPieza(int totalPieza) {
        this.totalPieza = totalPieza;
    }

    
}
