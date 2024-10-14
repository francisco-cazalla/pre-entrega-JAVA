package edu.coderhouse.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sale")
public class Sale {

    public Sale () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "venta", nullable = false)
    private String venta;

    @Column(name = "valor", nullable = false, unique = true)
    private int valor;


    public Sale(Long id, String venta, int valor) {
        this.id = id;
        this.venta = venta;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getventa() {
        return venta;
    }

    public void setventa(String venta) {
        this.venta = venta;
    }

    public int getvalor() {
        return valor;
    }

    public void setvalor(int valor) {
        this.valor = valor;
    }
}


