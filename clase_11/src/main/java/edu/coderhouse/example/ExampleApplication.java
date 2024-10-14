package edu.coderhouse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.coderhouse.example.entity.Product;
import edu.coderhouse.example.entity.Client;
import edu.coderhouse.example.entity.Sale;
import org.springframework.boot.CommandLineRunner;
import edu.coderhouse.example.service.DaoFactory;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner   {

	@Autowired
	public DaoFactory daoFactory;


	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Se crea un cliente
			Client cliente = new Client(2L, "Ramon Perez", "Ramon@email");

			// Se crea los domicilios
			Product producto1 = new Product("tv samsung", 22, 30000);
			Product producto2 = new Product("microondas", 56, 20000);

			Sale venta1 = new Sale(2L ,"tv samsung" ,30000);
			Sale venta2 = new Sale(2L ,"microondas" ,20000);


			daoFactory.create(cliente);
			daoFactory.create(producto1);
			daoFactory.create(producto2);
			daoFactory.create(venta1);
			daoFactory.create(venta2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
