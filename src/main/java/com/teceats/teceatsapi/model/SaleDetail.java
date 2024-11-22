package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "sale_detail") // Nombre de la tabla en la base de datos
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle") // Nombre ajustado para coincidir con la base de datos
    private Long idDetalle;

    @NotNull(message = "La venta no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", nullable = false)
    private Sale sale;

    @NotNull(message = "El platillo no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_platillo", referencedColumnName = "id_platillo", nullable = false)
    private Dish dish;

    @NotNull(message = "La cantidad no puede ser nula")
    @Column(nullable = false)
    private int cantidad;

    @NotNull(message = "El subtotal no puede ser nulo")
    @Column(nullable = false)
    private BigDecimal subtotal;

    // Constructor por defecto
    public SaleDetail() {
    }

    // Getters y Setters
    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
