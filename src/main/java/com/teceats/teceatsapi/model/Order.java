package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // Cambié a "orders" para evitar conflictos con palabras reservadas
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @NotNull(message = "El id de la venta no puede ser nulo")
    @OneToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", nullable = false)
    private Sale venta;

    @ManyToOne
    @JoinColumn(name = "id_repartidor", referencedColumnName = "id_repartidor")
    private DeliveryPerson repartidor;

    @NotNull(message = "El estado del pedido no puede ser nulo")
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotNull(message = "La dirección de entrega no puede ser nula")
    @Column(name = "direccion_entrega", nullable = false)
    private String direccionEntrega;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructor por defecto
    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getVenta() {
        return venta;
    }

    public void setVenta(Sale venta) {
        this.venta = venta;
    }

    public DeliveryPerson getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(DeliveryPerson repartidor) {
        this.repartidor = repartidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
