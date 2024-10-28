package edu.coderhouse.example.controller;

import edu.coderhouse.example.entity.Comprobante;
import edu.coderhouse.example.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;

    // Endpoint para crear un comprobante
    @PostMapping
    public Comprobante crearComprobante(@RequestParam Double total) {
        return comprobanteService.crearComprobante(total);
    }

    // Endpoint para obtener todos los comprobantes
    @GetMapping
    public List<Comprobante> obtenerComprobantes() {
        return comprobanteService.obtenerComprobantes();
    }

    // Endpoint para obtener un comprobante por ID
    @GetMapping("/{id}")
    public Comprobante obtenerComprobantePorId(@PathVariable Long id) {
        return comprobanteService.obtenerComprobantePorId(id);
    }

    // Endpoint para eliminar un comprobante
    @DeleteMapping("/{id}")
    public void eliminarComprobante(@PathVariable Long id) {
        comprobanteService.eliminarComprobante(id);
    }
}
