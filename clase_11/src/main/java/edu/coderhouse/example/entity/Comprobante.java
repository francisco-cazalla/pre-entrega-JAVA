package edu.coderhouse.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private Double total;

    // Constructor vacío
    public Comprobante() {}

    // Constructor con parámetros
    public Comprobante(LocalDateTime fecha, Double total) {
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
