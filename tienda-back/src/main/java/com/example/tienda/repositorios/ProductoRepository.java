package com.example.tienda.repositorios;

import com.example.tienda.modelos.Productos;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Productos, Integer> {
}
