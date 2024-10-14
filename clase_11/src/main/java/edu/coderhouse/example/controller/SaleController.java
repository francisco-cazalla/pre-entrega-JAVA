package edu.coderhouse.example.controller;
import edu.coderhouse.example.entity.Sale;
import edu.coderhouse.example.service.SaleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getSale() {
        // Devuelvo los clientes
        return ResponseEntity.ok(this.service.getSale());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        this.service.createSale(sale);
        return ResponseEntity.ok(sale);
    }
}
