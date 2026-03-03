package com.pruebaTenica.service;

import com.pruebaTenica.dto.SucursalDTO;
import com.pruebaTenica.mapper.Mapper;
import com.pruebaTenica.mapper.SucursalNoEncontradaException;
import com.pruebaTenica.model.Sucursal;
import com.pruebaTenica.repository.SucuarsalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SucursalService implements ISucursalService{
    @Autowired
    private SucuarsalRepository servicio;

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {

        Sucursal sucursal =Sucursal.builder()
                .nombre(sucursalDTO.getNombre())
                .direccion(sucursalDTO.getDireccion())
                .build();

        servicio.save(sucursal);

        return Mapper.toDTO(sucursal);
    }

    @Override
    public List<SucursalDTO> traerSucursales() {
        return List.of();
    }

    @Override
    public SucursalDTO traerSucursalPorId(Long id) {
        return null;
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO) {

        Sucursal sucursal=servicio.findById(id).orElseThrow(()->new SucursalNoEncontradaException());

        sucursal.setDireccion(sucursalDTO.getDireccion());
        sucursal.setNombre(sucursal.getNombre());



        return Mapper.toDTO(servicio.save(sucursal));
    }

    @Override
    public void eliminarSucursal(Long id) {
        servicio.deleteById(id);
    }
}
