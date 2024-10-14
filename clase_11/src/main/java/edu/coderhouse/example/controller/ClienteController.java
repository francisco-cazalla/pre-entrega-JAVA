package edu.coderhouse.example.controller;

import edu.coderhouse.example.entity.Client;
import edu.coderhouse.example.service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClientes() {
        // Devuelvo los clientes
        return ResponseEntity.ok(this.service.getClientes());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> createCliente(@RequestBody Client cliente) {
        this.service.createCliente(cliente);
        return ResponseEntity.ok(cliente);
    }
}
