package com.pruebaTenica.service;

import com.pruebaTenica.model.Venta;

import java.util.List;

public interface IVentaService {

    Venta crearVenta(Venta venta);

    // READ
    List<Venta> traerVentas();

    Venta traerVentaPorId(Long id);

    // UPDATE
    Venta actualizarVenta(Long id, Venta venta);

    // DELETE
    void eliminarVenta(Long id);
}
