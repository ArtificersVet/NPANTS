package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String nombre;

    @Nonnull
    private String direccion;

    @Nonnull
    @NotBlank(message = "El telefono es obligatorio")
    @Size(max = 10, message = "El telefono no puede tener más de 10 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String telefono;

    @Nonnull
    private String email;

    @Nonnull
    @OneToOne
    @JoinColumn(name = "tipocliente_id")
    private TipoCliente tipoClienteid;

    public Cliente() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoClienteid() {
        return tipoClienteid;
    }

    public void setTipoClienteid(TipoCliente tipoClienteid) {
        this.tipoClienteid = tipoClienteid;
    }

    
}
