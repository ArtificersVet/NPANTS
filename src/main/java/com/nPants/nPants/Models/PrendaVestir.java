package com.nPants.nPants.Models;

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

    private String nombre;

    private String descripcion;

    
    @ManyToOne
    @JoinColumn(name = "tela_id")
    private Tela telaid;

    
    @ManyToOne
    @JoinColumn(name = "estilo_id")
    private Estilo estiloid;

    @ManyToOne
    @JoinColumn(name = "tipoprendavestir_id")
    private TipoPrendaVestir tipoPrendaVestirid;
}
