package com.nPants.nPants.Models;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Estilo {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nombre;
    @Nonnull
    private String tipo;

    @OneToMany(mappedBy = "estilo")
    private List<EstiloTalla> estiloTallas;
    
    
    public List<EstiloTalla> getEstiloTallas() {
        return estiloTallas;
    }

    public void setEstiloTallas(List<EstiloTalla> estiloTallas) {
        this.estiloTallas = estiloTallas;
    }

    public Estilo() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    
}
