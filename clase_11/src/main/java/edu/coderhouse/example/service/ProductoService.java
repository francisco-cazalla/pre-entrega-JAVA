package edu.coderhouse.example.service;


import edu.coderhouse.example.entity.Product;
import edu.coderhouse.example.repository.ProductoRepopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired // le indicamos que la propíedad va a ser inyectada
    private ProductoRepopsitory repository;

    public  ProductoService(ProductoRepopsitory repository){
        this.repository = repository;
    }
    public Product save(Product producto) {
        return repository.save(producto);
    }

    public List<Product> getPreoductos() {
        return repository.findAll();
    }




    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }
}
