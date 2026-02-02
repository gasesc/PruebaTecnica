package com.pruebaTenica.service;

import com.pruebaTenica.dto.SucursalDTO;
import com.pruebaTenica.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISucursalService {

    // CREATE
    SucursalDTO crearSucursal(SucursalDTO sucursalDTO);

    // READ
    List<SucursalDTO> traerSucursales();

    SucursalDTO traerSucursalPorId(Long id);

    // UPDATE
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO);


    void eliminarSucursal(Long id);

}
