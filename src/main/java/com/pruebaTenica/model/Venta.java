package com.pruebaTenica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fecha;
    private String estado;
    @ManyToOne
    private Sucursal sucursal;
    private Double total;
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta>detalle=new ArrayList<>();
}
