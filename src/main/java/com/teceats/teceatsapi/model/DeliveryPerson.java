package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_person")
public class DeliveryPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del repartidor no puede ser nulo")
    private String nombre;

    @NotNull(message = "El correo del repartidor no puede ser nulo")
    @Email(message = "El correo debe tener un formato válido")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "El teléfono del repartidor no puede ser nulo")
    private String telefono;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructor por defecto
    public DeliveryPerson() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
