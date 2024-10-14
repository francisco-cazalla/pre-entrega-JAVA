package edu.coderhouse.example.service;

import edu.coderhouse.example.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private JdbcTemplate jdbc;

    public ClienteService() {}

    public ClienteService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createCliente(Client cliente) {
        this.jdbc.update("INSERT INTO cliente (nombre, email) VALUES (?, ?)", cliente.getNombre(), cliente.getEmail());
    }

    public List<Client> getClientes() {
        return this.jdbc.query("SELECT id, nombre, email FROM cliente", (rs, rowNum) -> {
            return new Client(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"));
        });
    }
}
