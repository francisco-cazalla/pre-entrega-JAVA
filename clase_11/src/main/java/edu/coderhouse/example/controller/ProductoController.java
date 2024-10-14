package edu.coderhouse.example.controller;


import edu.coderhouse.example.entity.Product;
import edu.coderhouse.example.service.ProductoService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    @Autowired
    private ProductoService service;

    public ProductoController(ProductoService service){
        this.service =service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Product>> getAll() {
        Iterable<Product> productos = service.getPreoductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping(value = {"/id"},produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional <Product>> getById(@PathVariable Long id){
        Optional<Product> producto = service.getById(id);

        if(producto.isPresent()){
            return ResponseEntity.ok(producto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> create(@RequestBody Product producto
    ){ try{
        Product nuevoProducto = service.save(producto);
        return ResponseEntity.ok(producto);

    }catch (Exception e){
        e.printStackTrace();
        return  ResponseEntity.internalServerError().build();
    }

    }
}
