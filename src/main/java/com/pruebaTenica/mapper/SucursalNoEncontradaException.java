package com.pruebaTenica.mapper;

public class SucursalNoEncontradaException extends RuntimeException {
    public SucursalNoEncontradaException() {

        super("Sucursal no encontrada");
    }
}
