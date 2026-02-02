package com.pruebaTenica.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private int cantidad;

}
