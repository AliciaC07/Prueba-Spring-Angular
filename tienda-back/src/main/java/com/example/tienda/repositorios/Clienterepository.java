package com.example.tienda.repositorios;

import com.example.tienda.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface Clienterepository extends CrudRepository<Cliente, Integer> {
}
