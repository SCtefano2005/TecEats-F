package com.teceats.teceatsapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Approval")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_admin")
    private Long idAdmin;

    @Column(name = "id_restaurante")
    private Long idRestaurante;

    @Column(name = "id_accion")
    private Long idAccion;

    @Column(name = "fecha_accion", nullable = false)
    private LocalDateTime fechaAccion;

    @Column(name = "observaciones")
    private String observaciones;

    // Constructor por defecto
    public Approval() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Long getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Long idAccion) {
        this.idAccion = idAccion;
    }

    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
