package com.pruebaTenica.service;

import com.pruebaTenica.dto.ProductoDTO;
import com.pruebaTenica.exception.ProductoNoEncontradoException;
import com.pruebaTenica.mapper.Mapper;
import com.pruebaTenica.model.Producto;
import com.pruebaTenica.repository.ProductoRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repo;

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) {


        Producto produ = Producto.builder()
                .nombre(producto.getNombre())
                .categoria(producto.getCategoria())
                .precio(producto.getPrecio())
                .cantidad(producto.getCantidad())
                .build();



        repo.save(produ);

        return Mapper.toDTO(produ);

    }

    @Override
    public List<ProductoDTO> traerProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO traerProductoPorId(Long id) {

        Producto producto = repo.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));

        return Mapper.toDTO(producto);
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO producto) {
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        repo.deleteById(id);
    }
}
