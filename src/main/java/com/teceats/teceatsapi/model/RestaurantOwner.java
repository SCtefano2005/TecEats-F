package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "RestaurantOwner") // Nombre de la tabla ajustado para coincidir con la base de datos
public class RestaurantOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_owner") // Ajustado para coincidir con el nombre de la columna en la base de datos
    private Long idOwner;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull(message = "El correo no puede ser nulo")
    @Email(message = "El correo debe tener un formato válido")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "telefono")
    private String telefono;

    // Constructor por defecto
    public RestaurantOwner() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
