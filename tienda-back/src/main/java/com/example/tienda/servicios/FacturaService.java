package com.example.tienda.servicios;

import com.example.tienda.modelos.Factura;
import com.example.tienda.repositorios.FacturaRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura save(Factura factura){
        return facturaRepository.save(factura);
    }
    public Iterable<Factura> findall(){
        return facturaRepository.findAll();
    }
    public Factura findbyId(Integer id){
        return facturaRepository.findById(id).get();
    }
    public void delete(Integer id){
        Factura factura = findbyId(id);
        facturaRepository.delete(factura);

    }

}
