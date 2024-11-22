package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "action_types") // Cambiado a plural y minúsculas para consistencia
public class ActionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accion") // Ajuste para ser consistente con el esquema de la base de datos
    private Long id;

    @NotNull(message = "El nombre de la acción no puede ser nulo")
    @Column(name = "nombre_accion", nullable = false) // Anotación @Column añadida para mapeo explícito
    private String nombreAccion;

    // Constructor por defecto
    public ActionType() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }
}
