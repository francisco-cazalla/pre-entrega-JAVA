package edu.coderhouse.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sale")
public class Sale {

    public Sale () {}

    public Sale(String producto, int ventas, int ganancias, String descripcion) {
        this.producto = producto;
        this.ventas = ventas;
        this.ganancias = ganancias;
        this.descripcion = descripcion;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;



    @Column(name = "PRODUCT")
    @Getter
    @Setter
    private String producto;

    @Column(name = "SALES")
    @Getter
    @Setter
    private int ventas;

    @Column(name = "EARNINGS")
    @Getter
    @Setter
    private int ganancias;

    @Column(name = "DESCRIPTION")
    @Getter
    @Setter
    private String descripcion;

}
