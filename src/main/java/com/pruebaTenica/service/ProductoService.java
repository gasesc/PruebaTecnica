package com.pruebaTenica.service;

import com.pruebaTenica.model.Producto;
import com.pruebaTenica.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repo;

    @Override
    public Producto crearProducto(Producto producto) {
        return null;
    }

    @Override
    public List<Producto> traerProductos() {
        return repo.findAll().stream().map(Mappers::toDTO).toList();
    }

    @Override
    public Producto traerProductoPorId(Long id) {
        return null;
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {

    }
}
