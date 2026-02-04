package com.pruebaTenica.dto;

import com.pruebaTenica.model.DetalleVenta;
import com.pruebaTenica.model.Sucursal;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {

    private long id;
    private LocalDate fecha;
    private String estado;
    private Long idSucursal;
    private List<DetalleVentaDTO> detalle;
    private Double total;


}
