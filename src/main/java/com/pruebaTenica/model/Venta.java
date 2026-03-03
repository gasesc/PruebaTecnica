package com.pruebaTenica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
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
    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta>detalle=new ArrayList<>();
}
