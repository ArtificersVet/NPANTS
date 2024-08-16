package com.nPants.nPants.Models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "estilos")
public class Estilo {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String nombre;
    @Nonnull
    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 50, message = "El tipo no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 50)  // Restricción a nivel de base de datos
    private String tipo;

    @Nonnull
    @OneToMany
    @JoinColumn(name = "talla_id")
    private List<Talla> tallas;
    
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

    public List<Talla> getTallas() {
        return tallas;
    }

    public void setTallas(List<Talla> tallas) {
        this.tallas = tallas;
    }

    
}
