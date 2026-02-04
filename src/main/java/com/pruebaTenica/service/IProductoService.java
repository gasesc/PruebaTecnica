package com.pruebaTenica.service;

import com.pruebaTenica.dto.ProductoDTO;
import com.pruebaTenica.model.Producto;

import java.util.List;

public interface IProductoService {

    // CREATE
    ProductoDTO crearProducto(ProductoDTO producto);

    // READ
    List<ProductoDTO> traerProductos();

    ProductoDTO traerProductoPorId(Long id);

    // UPDATE
    ProductoDTO actualizarProducto(Long id, ProductoDTO producto);

    // DELETE
    void eliminarProducto(Long id);
}
