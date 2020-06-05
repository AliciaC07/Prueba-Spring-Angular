package com.example.tienda.servicios;

import com.example.tienda.modelos.Cliente;
import com.example.tienda.repositorios.Clienterepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio {

    private final Clienterepository clienterepository;

    public ClienteServicio(Clienterepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    public Iterable<Cliente> todosClientes(){
        return clienterepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienterepository.save(cliente);

    }
    public Cliente findbyId(Integer id){
        return clienterepository.findById(id).get();
    }

    public void delete(Integer id){
        clienterepository.deleteById(id);
    }



}
