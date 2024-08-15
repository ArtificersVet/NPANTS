package com.nPants.nPants.Models;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "Pedido_id")
    private Pedido pedidoid;

    @Nonnull
    private LocalDate fechaPago;

    @Nonnull
    private Double monto;

    @Nonnull
    @ManyToOne 
    @JoinColumn(name = "MetodoPago_id")
    private MetodoPago metodoPago;

    // Constructor, getters, and setters

    public Pago() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Pedido pedidoid) {
        this.pedidoid = pedidoid;  

    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago
 = metodoPago;
    }

    


}
