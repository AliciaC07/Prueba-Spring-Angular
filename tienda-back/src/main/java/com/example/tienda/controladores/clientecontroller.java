package com.example.tienda.controladores;

import com.example.tienda.modelos.Cliente;
import com.example.tienda.servicios.ClienteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class clientecontroller {
    private final ClienteServicio clienteServicio;


    public clientecontroller(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping(value = "/cliente")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Cliente> listacliente(){
        return clienteServicio.todosClientes();
    }

    @PostMapping(value = "/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteServicio.save(cliente);
    }

    @GetMapping(value = "/cliente/{id}")
    public Cliente dame(@PathVariable Integer id){
        return clienteServicio.findbyId(id);
    }

    @PutMapping(value = "/cliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente editar(@RequestBody Cliente cliente, @PathVariable Integer id){
        Cliente clienteactual = clienteServicio.findbyId(id);
        clienteactual.setApellido(cliente.getApellido());
        clienteactual.setNombre(cliente.getNombre());
        clienteactual.setDireccion(cliente.getDireccion());
        clienteactual.setEmail(cliente.getEmail());
        clienteactual.setFechanaci(cliente.getFechanaci());
        return clienteServicio.save(clienteactual);
    }

    @DeleteMapping(value = "/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        clienteServicio.delete(id);
    }
}
