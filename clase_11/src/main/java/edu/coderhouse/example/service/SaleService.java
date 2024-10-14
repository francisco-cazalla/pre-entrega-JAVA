package edu.coderhouse.example.service;
import edu.coderhouse.example.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private JdbcTemplate jdbc;

    public SaleService() {}

    public SaleService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createSale(Sale sale) {
        this.jdbc.update("INSERT INTO sale (valor, venta) VALUES (?, ?)", sale.getvalor(), sale.getventa());
    }

    public List<Sale> getSale() {
        return this.jdbc.query("SELECT id, valor, venta FROM Sale", (rs, rowNum) -> {
            return new Sale(rs.getLong("id"), rs.getString("valor"), rs.getInt("venta"));
        });
    }
}


