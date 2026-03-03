package com.pruebaTenica.service;

import com.pruebaTenica.dto.VentaDTO;
import com.pruebaTenica.model.Venta;

import java.util.List;

public interface IVentaService {

    VentaDTO crearVenta(VentaDTO ventaDTO);


    List<VentaDTO> traerVentas();

    VentaDTO traerVentaPorId(Long id);


    VentaDTO actualizarVenta(Long id, VentaDTO ventaDTO);

    void eliminarVenta(Long id);
}
