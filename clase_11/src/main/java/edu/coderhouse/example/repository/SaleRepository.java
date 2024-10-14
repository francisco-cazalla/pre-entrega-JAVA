package edu.coderhouse.example.repository;
import edu.coderhouse.example.entity.Product;
import edu.coderhouse.example.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SaleRepository extends JpaRepository<Sale ,Long> {
}
