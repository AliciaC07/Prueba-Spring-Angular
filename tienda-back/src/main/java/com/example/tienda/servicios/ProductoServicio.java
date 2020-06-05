package com.example.tienda.servicios;


import com.example.tienda.modelos.Productos;
import com.example.tienda.repositorios.ProductoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class ProductoServicio {

    private final ProductoRepository productoRepository;


    public ProductoServicio(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Iterable<Productos> getall(){
        return productoRepository.findAll();
    }

    public Productos findbyId(Integer id){
        return productoRepository.findById(id).get();
    }

    public Productos save(Productos productos){
        return productoRepository.save(productos);
    }

    public void delete(Integer id){
        productoRepository.deleteById(id);

    }
}
