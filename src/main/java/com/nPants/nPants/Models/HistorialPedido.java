package com.nPants.nPants.Models;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_pedidos")
public class HistorialPedido {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Nonnull
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedidoid;

    @Nonnull
    private LocalDateTime fecha;

    private String comentario;

    @Nonnull
    @OneToOne
    @JoinColumn(name = "estadopedido_id")
    private EstadoPedido estadoPedidoid;

    @Nonnull
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioid;

    public HistorialPedido() {
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EstadoPedido getEstadoPedidoid() {
        return estadoPedidoid;
    }

    public void setEstadoPedidoid(EstadoPedido estadoPedidoid) {
        this.estadoPedidoid = estadoPedidoid;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    
}
