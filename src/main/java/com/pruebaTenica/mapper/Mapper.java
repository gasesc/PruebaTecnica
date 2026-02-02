package com.pruebaTenica.mapper;

import com.pruebaTenica.dto.ProductoDTO;
import com.pruebaTenica.model.Producto;

public class Mapper {


    public static ProductoDTO toDTO(Producto p){

        if(p==null) return null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .build();

    }

}
