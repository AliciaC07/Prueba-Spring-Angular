package com.example.tienda.modelos;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Size(min = 2, max = 49)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotEmpty
    @Size(min = 2, max = 49)
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotEmpty
    @Column(name = "fecha_na", nullable = false)
    private Date fechanaci;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<>();

    public void addFacturas(Factura factura){
        facturas.add(factura);
        factura.setCliente(this);
    }

    public Cliente() {
    }
}
