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
        this.price = price;

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
    private int price;


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


