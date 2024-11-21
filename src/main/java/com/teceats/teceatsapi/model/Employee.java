package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id del restaurante no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurant restaurant;

    @NotNull(message = "El nombre del empleado no puede ser nulo")
    private String nombre;

    @NotNull(message = "El correo del empleado no puede ser nulo")
    @Email(message = "El correo debe tener un formato válido")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "El id del cargo no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private JobPosition cargo;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    private String telefono;

    // Constructor por defecto
    public Employee() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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

    public JobPosition getCargo() {
        return cargo;
    }

    public void setCargo(JobPosition cargo) {
        this.cargo = cargo;
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
