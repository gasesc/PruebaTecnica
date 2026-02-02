package com.pruebaTenica.service;

import com.pruebaTenica.model.Producto;

import java.util.List;

public interface IProductoService {

    // CREATE
    Producto crearProducto(Producto producto);

    // READ
    List<Producto> traerProductos();

    Producto traerProductoPorId(Long id);

    // UPDATE
    Producto actualizarProducto(Long id, Producto producto);

    // DELETE
    void eliminarProducto(Long id);
}
