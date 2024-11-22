package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job_position") // Nombre de la tabla coincide con la base de datos
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo") // Ajustado para coincidir con el nombre de la columna en la base de datos
    private Long id;

    @NotNull(message = "El nombre del cargo no puede ser nulo")
    @Size(min = 2, max = 255, message = "El nombre del cargo debe tener entre 2 y 255 caracteres")
    @Column(name = "nombre_cargo", unique = true, nullable = false)
    private String nombreCargo;

    // Constructor por defecto
    public JobPosition() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}

