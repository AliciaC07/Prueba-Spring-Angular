package com.example.tienda.controladores;

import com.example.tienda.modelos.Productos;
import com.example.tienda.servicios.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class ProductoController {
    private final ProductoServicio productoServicio;


    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping(value = "/producto")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Productos> listaproductos(){
        return productoServicio.getall();
    }

    @PostMapping(value = "/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos productonew(@RequestBody Productos productos){
        return productoServicio.save(productos);
    }

    @PutMapping(value = "/producto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos editar(@RequestBody Productos productos, @PathVariable Integer id){
        Productos productosact = productoServicio.findbyId(id);
        productosact.setNombre(productos.getNombre());
        productosact.setDescripcion(productos.getDescripcion());
        productosact.setPrecio(productos.getPrecio());
        productosact.setProveedor(productos.getProveedor());
        productosact.setPromocion(productos.getPromocion());
        return productoServicio.save(productosact);
    }

    @GetMapping(value = "/producto/{id}")
    public Productos dameproducto(@PathVariable Integer id){
        return productoServicio.findbyId(id);
    }
    @DeleteMapping(value = "/producto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarpro(@PathVariable Integer id){
        productoServicio.delete(id);
    }


}
