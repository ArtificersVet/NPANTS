package com.nPants.nPants.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.annotation.Nonnull;

@Entity
public class EstiloTalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double consumoTela;

    @ManyToOne
    @JoinColumn(name = "estilo_id") 
    private Estilo estilo; 

    //@ManyToMany
    //@JoinTable(
       //name = "talla_estilo_talla", 
       // joinColumns = @JoinColumn(name = "estilo_talla_id"), 
       // inverseJoinColumns = @JoinColumn(name = "talla_id") 
    //)
    @ManyToOne
    @JoinColumn(name = "talla_id", referencedColumnName = "id")
    private Talla talla;

    public EstiloTalla() {
    }


    public EstiloTalla(@Nonnull Talla talla, @Nonnull Estilo estilo, double consumoTela) {
        this.talla = talla;
        this.estilo = estilo;
        this.consumoTela = consumoTela;
    }


    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
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


    public Estilo getEstilo() {
        return estilo;
    }


    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }


}
