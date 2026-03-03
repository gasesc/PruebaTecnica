package com.pruebaTenica.service;

import com.pruebaTenica.dto.DetalleVentaDTO;
import com.pruebaTenica.dto.ProductoDTO;
import com.pruebaTenica.dto.VentaDTO;
import com.pruebaTenica.exception.ProductoNoEncontradoException;
import com.pruebaTenica.mapper.Mapper;
import com.pruebaTenica.mapper.SucursalNoEncontradaException;
import com.pruebaTenica.model.DetalleVenta;
import com.pruebaTenica.model.Producto;
import com.pruebaTenica.model.Sucursal;
import com.pruebaTenica.model.Venta;
import com.pruebaTenica.repository.ProductoRepository;
import com.pruebaTenica.repository.SucuarsalRepository;
import com.pruebaTenica.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepo;
    @Autowired
    private SucuarsalRepository sucursalRepository;

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {

        if(ventaDTO==null)throw new RuntimeException("ventaDTO es null");
        if(ventaDTO.getIdSucursal()==null)throw new RuntimeException(("debe indicar la sucursal"));
        if(ventaDTO.getDetalle()==null || ventaDTO.getDetalle().isEmpty())throw new RuntimeException("debe incluir al menos un producto");


        Sucursal suc =sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
        if(suc==null){
            throw new SucursalNoEncontradaException();
        }
        Venta venta =new Venta();
        venta.setFecha(ventaDTO.getFecha());
        venta.setEstado(ventaDTO.getEstado());
        //venta.setDetalle(ventaDTO.getDetalle());
        venta.setSucursal(suc);
        venta.setTotal(ventaDTO.getTotal());

        List<DetalleVenta>listaDetalles=new ArrayList<>();


        for(DetalleVentaDTO detalle : ventaDTO.getDetalle()){
            Producto produ=productoRepo.findByNombre(detalle.getNombreProducto()).orElse(null);
            if(produ==null){
                throw new RuntimeException("poducto no encontrado");
            }
            DetalleVenta detalleVenta=new DetalleVenta();
            detalleVenta.setProducto(produ);
            detalleVenta.setPrecio(detalle.getPreciol());
            detalleVenta.setCanProd(detalle.getCantidadProducto());
            detalleVenta.setVenta(venta);
            listaDetalles.add(detalleVenta);

        }
        venta.setDetalle(listaDetalles);
        Venta ventaGuardada=ventaRepository.save(venta);

        return Mapper.toDTO(ventaGuardada);
    }

    @Override
    public List<VentaDTO> traerVentas() {
        return ventaRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public VentaDTO traerVentaPorId(Long id) {
        return null;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDTO) {
        Venta ventaEncontrada=ventaRepository.findById(id).orElse(null);
        if (ventaEncontrada==null){
            throw new RuntimeException(("venta no encontrada"));
        }
        if(ventaDTO.getFecha()!=null){
            ventaEncontrada.setFecha(ventaDTO.getFecha());
        }
        if(ventaDTO.getEstado()!=null){
            ventaEncontrada.setEstado(ventaDTO.getEstado());
        }
        if(ventaDTO.getIdSucursal()!=null){
            Sucursal sucursalEncontrada=sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
            if(sucursalEncontrada==null){
                throw new SucursalNoEncontradaException();
            }
            ventaEncontrada.setSucursal(sucursalEncontrada);
        }
        Venta ventaGuardada=ventaRepository.save(ventaEncontrada);


        return Mapper.toDTO(ventaGuardada);
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta v= ventaRepository.findById(id).orElseThrow(()-> new RuntimeException("venta no encontrada"));
        ventaRepository.delete(v);

    }
}