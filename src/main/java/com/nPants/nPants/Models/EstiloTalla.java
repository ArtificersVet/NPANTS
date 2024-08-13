package com.nPants.nPants.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class EstiloTalla {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double consumoTela;

    @ManyToMany
    @JoinColumn(name = "estilo_id")
    private Estilo estiloid;

    @ManyToMany
    @JoinColumn(name = "talla_id")
    private Talla tallaid;

    public EstiloTalla() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getConsumoTela() {
        return consumoTela;
    }

    public void setConsumoTela(double consumoTela) {
        this.consumoTela = consumoTela;
    }

    public Estilo getEstiloid() {
        return estiloid;
    }

    public void setEstiloid(Estilo estiloid) {
        this.estiloid = estiloid;
    }

    public Talla getTallaid() {
        return tallaid;
    }

    public void setTallaid(Talla tallaid) {
        this.tallaid = tallaid;
    }

    
    
}
