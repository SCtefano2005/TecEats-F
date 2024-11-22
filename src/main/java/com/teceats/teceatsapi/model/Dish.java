package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "dish") // El nombre coincide con el de la tabla en la base de datos
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platillo") // Ajuste del nombre de la columna para coincidir con la base de datos
    private Long idPlatillo;

    @NotNull(message = "El restaurante asociado no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false) // Asocia la columna con la entidad `Restaurant`
    private Restaurant restaurant;

    @NotNull(message = "El nombre del platillo no puede ser nulo")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull(message = "La descripción del platillo no puede ser nula")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull(message = "El precio del platillo no puede ser nulo")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2) // Definición del tipo decimal(10, 2)
    private BigDecimal precio;

    @Column(name = "imagen")
    private String imagen;

    // Constructor por defecto
    public Dish() {
    }

    // Getters y Setters
    public Long getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Long idPlatillo) {
        this.idPlatillo = idPlatillo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
