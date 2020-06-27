package com.example.tienda.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(name = "fecha",nullable = false)
    private Date fecha;

    @NotEmpty
    @Column(name = "rnc", unique = true)
    @GeneratedValue
    private String rnc;

    @NotEmpty
    @Column(name = "total",nullable = false)
    private Float total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonProperty(value = "cliente", access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "productos_factura",
            joinColumns = @JoinColumn(name = "factura_id"),
            inverseJoinColumns = @JoinColumn(name = "productos_id")
    )
    private Set<Productos> productos = new HashSet<>();


}
