package com.pruebaTenica.dto;


import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {

    private Long id;
    private String nombre;
    private String direccion;
}
