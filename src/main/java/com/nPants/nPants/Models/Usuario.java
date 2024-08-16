package com.nPants.nPants.Models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Nonnull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String nombre;

    @Nonnull
    @NotBlank(message = "El email es obligatorio")
    @Size(max = 50, message = "El email no puede tener más de 50 caracteres")
    @Column(nullable = false, length = 50)  // Restricción a nivel de base de datos
    private String email;

    @Nonnull
    @NotBlank(message = "El password es obligatorio")
    @Size(max = 30, message = "El password no puede tener más de 30 caracteres")
    @Column(nullable = false, length = 30)  // Restricción a nivel de base de datos
    private String password;

    @OneToOne
    @JoinColumn(name = "rol_id")
    private Rol rolid;

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRolid() {
        return rolid;
    }

    public void setRolid(Rol rolid) {
        this.rolid = rolid;
    }

    
}
