package edu.coderhouse.example.service;

import edu.coderhouse.example.entity.Comprobante;
import edu.coderhouse.example.entity.Product;
import edu.coderhouse.example.exceptions.StockInsuficienteException;
import edu.coderhouse.example.repository.ProductoRepopsitory;
import edu.coderhouse.example.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ComprobanteService {
    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Autowired
    private ProductoRepopsitory productoRepository;

    private final RestTemplate restTemplate;
    @Autowired
    public ComprobanteService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    // Método para obtener la hora desde la API
    private LocalDateTime obtenerFechaHoraDesdeAPI() {
        String url = "http://worldtimeapi.org/api/timezone/America/Argentina/Buenos_Aires";
        Map<String, Object> respuesta = restTemplate.getForObject(url, Map.class);

        // Obtiene la fecha y hora en formato ISO desde el JSON
        String fechaHoraISO = (String) respuesta.get("datetime");

        // Convierte la cadena ISO en un LocalDateTime
        return LocalDateTime.parse(fechaHoraISO);
    }

    // Crear comprobante con fecha y hora desde API
    public Comprobante crearComprobante(Double total) {
        LocalDateTime fechaHora = obtenerFechaHoraDesdeAPI();
        Comprobante comprobante = new Comprobante(fechaHora, total);
        return comprobanteRepository.save(comprobante);
    }

    // Crear comprobante con validación de stock
    public Comprobante crearComprobante(List<Long> productoIds, List<Integer> cantidades) {
        for (int i = 0; i < productoIds.size(); i++) {
            Product product = productoRepository.findById(productoIds.get(i)).orElseThrow();
            if (product.getStock() < cantidades.get(i)) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + product.getNombre());
            }
        }
        for (int i = 0; i < productoIds.size(); i++) {
            Product product = productoRepository.findById(productoIds.get(i)).orElseThrow();
            product.setStock(product.getStock() - cantidades.get(i));
            productoRepository.save(product);
        }
        LocalDateTime fechaHora = obtenerFechaHoraDesdeAPI();
        Comprobante comprobante = new Comprobante(fechaHora, calcularTotal(productoIds, cantidades));
        return comprobanteRepository.save(comprobante);
    }
    private Double calcularTotal(List<Long> productoIds, List<Integer> cantidades) {
        double total = 0.0;
        for (int i = 0; i < productoIds.size(); i++) {
            Product product = productoRepository.findById(productoIds.get(i)).orElseThrow();
            total += product.getPrecio() * cantidades.get(i);
        }
        return total;
    }



    // Métodos para obtener, actualizar y eliminar comprobantes
    public List<Comprobante> obtenerComprobantes() {
        return comprobanteRepository.findAll();
    }

    public Comprobante obtenerComprobantePorId(Long id) {
        return comprobanteRepository.findById(id).orElseThrow();
    }

    public void eliminarComprobante(Long id) {
        comprobanteRepository.deleteById(id);
    }
}
