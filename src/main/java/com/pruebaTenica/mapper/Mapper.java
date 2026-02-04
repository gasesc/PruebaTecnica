package com.pruebaTenica.mapper;

import com.pruebaTenica.dto.DetalleVentaDTO;
import com.pruebaTenica.dto.ProductoDTO;
import com.pruebaTenica.dto.SucursalDTO;
import com.pruebaTenica.dto.VentaDTO;
import com.pruebaTenica.model.DetalleVenta;
import com.pruebaTenica.model.Producto;
import com.pruebaTenica.model.Sucursal;
import com.pruebaTenica.model.Venta;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static SucursalDTO toDTO(Sucursal s){
        if(s==null)return null;

        return SucursalDTO.builder()
                .id(s.getId())
                .nombre((s.getNombre()))
                .direccion(s.getDireccion())
                .build();
    }
    public static VentaDTO toDTO(Venta v){

        if(v==null) return null;

        var detalle=v.getDetalle().stream().map((DetalleVenta det) ->
                DetalleVentaDTO.builder()
                        .id(det.getId())
                        .nombreProducto(det.getProducto().getNombre())
                        .cantidadProducto(det.getCanProd())
                        .preciol(det.getPrecio())
                        .subtotal(det.getPrecio()* det.getCanProd())
                        .build()


        ).collect(Collectors.toList());

        var total =detalle.stream()
                .map(DetalleVentaDTO :: getSubtotal)
                .reduce(0.0,Double::sum);

        return VentaDTO.builder()
                .id(v.getId())
                .fecha(v.getFecha())
                .idSucursal(v.getSucursal().getId())
                .estado(v.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }

}
