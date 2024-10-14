package edu.coderhouse.example.repository;

import edu.coderhouse.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepopsitory extends JpaRepository<Product,Long> {
}
