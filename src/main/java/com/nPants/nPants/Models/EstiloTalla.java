package com.nPants.nPants.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estilos_talla")
public class EstiloTalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double consumoTela;

    @ManyToOne
    @JoinColumn(name = "estilo_id") 
    private Estilo estiloid; 

    @ManyToMany
    @JoinTable(
        name = "talla_estilo_talla", 
        joinColumns = @JoinColumn(name = "estilo_talla_id"), 
        inverseJoinColumns = @JoinColumn(name = "talla_id") 
    )
    private List<Talla> tallas; 

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

    public List<Talla> getTallas() {
        return tallas;
    }

    public void setTallas(List<Talla> tallas) {
        this.tallas = tallas;
    }

    
    
}
