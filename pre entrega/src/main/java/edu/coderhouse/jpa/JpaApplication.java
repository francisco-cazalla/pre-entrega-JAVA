package edu.coderhouse.jpa;

import edu.coderhouse.jpa.entity.Client;
import edu.coderhouse.jpa.entity.Product;
import edu.coderhouse.jpa.entity.Sale;
import edu.coderhouse.jpa.service.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	public DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Se crea un cliente
			Client cliente = new Client("Juan", "Perez", 12345678);



			// se crea un producto
			Product product = new Product ("alfajor",50,500);
			Product chocolate = new Product("chocolate",70,890);


			//se crea venta
			Sale venta1 = new Sale("chocolates" , 5,2670,"se venden 5 chocolates");
			Sale venta2 = new Sale("alfajor" , 10,5000,"se venden 5 alfajores");







			// Crear
			daoFactory.create(cliente);
			daoFactory.create(product);
			daoFactory.create(chocolate);
			daoFactory.create(venta1);
			daoFactory.create(venta2);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}