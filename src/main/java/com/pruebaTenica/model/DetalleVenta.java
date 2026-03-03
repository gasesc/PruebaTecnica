package com.pruebaTenica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @ManyToOne
     private Venta venta;
     @ManyToOne
     private Producto producto;
     private  Integer canProd;
     private Double precio;

}
