package com.pruebaTenica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO {

    private long id;
    private String nombreProducto;
    private Integer cantidadProducto;
    private Double subtotal;
    private Double preciol;

}
