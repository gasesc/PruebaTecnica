package com.pruebaTenica.dto;

import lombok.*;

@Builder
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
