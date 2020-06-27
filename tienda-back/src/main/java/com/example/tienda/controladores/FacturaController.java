package com.example.tienda.controladores;

import com.example.tienda.modelos.Factura;
import com.example.tienda.servicios.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/factura")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Factura> getAll(){
        return facturaService.findall();
    }

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura save(@RequestBody Factura factura){
        return facturaService.save(factura);

    }
}
