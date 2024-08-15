package com.nPants.nPants.Models;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteid;

    @Nonnull
    private LocalDate fechaPedido;

    @Nonnull
    private double total;

    @Nonnull
    private double saldo;

    @Nonnull
    private byte tipoPago;

    @ManyToOne
    @JoinColumn(name = "estado_pedido_id", referencedColumnName = "id")
    private EstadoPedido estadoPedidoid;

    public Pedido() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public byte getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(byte tipoPago) {
        this.tipoPago = tipoPago;
    }

    public EstadoPedido getEstadoPedidoid() {
        return estadoPedidoid;
    }

    public void setEstadoPedidoid(EstadoPedido estadoPedidoid) {
        this.estadoPedidoid = estadoPedidoid;
    }

}
