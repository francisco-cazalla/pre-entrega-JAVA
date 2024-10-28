package edu.coderhouse.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
public class Product {

    public Product () {}

    public Product(String name, int stock, int price) {
        this.name = name;
        this.stock = stock;
        this.price = (double) price;

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @Column(name = "STOCK")
    @Getter
    @Setter
    private int stock;

    @Column(name = "PRICE")
    @Getter
    @Setter
    private Double price;

    public Long getId() { return (long) id; }
    public String getNombre() { return name; }
    public void setNombre(String nombre) { this.name = nombre; }
    public Double getPrecio() { return (double) price; }
    public void setPrecio(Double precio) { this.price = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }


    //@ManyToOne(fetch = FetchType.LAZY)
    //@Getter
    //@Setter
    //private Client client;

    //public Client getClient() {
    //return client;
    //}

    //public void setClient(Client client) {
    //this.client = client;
    //}
}


