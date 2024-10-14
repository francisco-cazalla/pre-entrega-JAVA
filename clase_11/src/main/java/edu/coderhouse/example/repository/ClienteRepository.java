package edu.coderhouse.example.repository;


import edu.coderhouse.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Client,Long>{
}
