package com.example.tienda.repositorios;

import com.example.tienda.modelos.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Integer> {
}
