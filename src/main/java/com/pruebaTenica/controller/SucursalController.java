package com.pruebaTenica.controller;

import com.pruebaTenica.dto.SucursalDTO;
import com.pruebaTenica.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> traerSucursales() {
        return ResponseEntity.ok(sucursalService.traerSucursales());
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursalDTO) {

        SucursalDTO creada = sucursalService.crearSucursal(sucursalDTO);

        return ResponseEntity
                .created(URI.create("/api/sucursales/" + creada.getId()))
                .body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> actualizarSucursal(
            @PathVariable Long id,
            @RequestBody SucursalDTO sucursalDTO) {

        return ResponseEntity.ok(
                sucursalService.actualizarSucursal(id, sucursalDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.noContent().build();
    }
}


