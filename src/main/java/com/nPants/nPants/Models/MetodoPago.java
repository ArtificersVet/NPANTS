package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String nombre;

    public MetodoPago() {
        super();
    }

    public MetodoPago(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
