package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PrendaVestir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String nombre;

    private String descripcion;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "tela_id")
    private Tela telaid;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "estilo_id")
    private Estilo estiloid;
    @Nonnull
    @ManyToOne
    @JoinColumn(name = "tipoprendavestir_id")
    private TipoPrendaVestir tipoPrendaVestirid;

    public PrendaVestir() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tela getTelaid() {
        return telaid;
    }

    public void setTelaid(Tela telaid) {
        this.telaid = telaid;
    }

    public Estilo getEstiloid() {
        return estiloid;
    }

    public void setEstiloid(Estilo estiloid) {
        this.estiloid = estiloid;
    }

    public TipoPrendaVestir getTipoPrendaVestirid() {
        return tipoPrendaVestirid;
    }

    public void setTipoPrendaVestirid(TipoPrendaVestir tipoPrendaVestirid) {
        this.tipoPrendaVestirid = tipoPrendaVestirid;
    }

    
}
