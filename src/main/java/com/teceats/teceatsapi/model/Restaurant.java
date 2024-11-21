package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Restaurant") // Nombre de la tabla ajustado para coincidir con la base de datos
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante") // Ajustado para coincidir con el nombre de la columna en la base de datos
    private Long idRestaurante;

    @NotNull(message = "El id del dueño no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id_owner", nullable = false)
    private RestaurantOwner owner;

    @NotNull(message = "El nombre del restaurante no puede ser nulo")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull(message = "La dirección del restaurante no puede ser nula")
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotNull(message = "El teléfono del restaurante no puede ser nulo")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructor por defecto
    public Restaurant() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public RestaurantOwner getOwner() {
        return owner;
    }

    public void setOwner(RestaurantOwner owner) {
        this.owner = owner;
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
