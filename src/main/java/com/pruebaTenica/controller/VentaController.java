package com.pruebaTenica.controller;

import com.pruebaTenica.dto.VentaDTO;
import com.pruebaTenica.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> traerVentas() {
        return ResponseEntity.ok(ventaService.traerVentas());
    }

    @PostMapping
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {

        VentaDTO creada = ventaService.crearVenta(ventaDTO);

        return ResponseEntity
                .created(URI.create("/api/ventas/" + creada.getId()))
                .body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDTO> actualizarVenta(
            @PathVariable Long id,
            @RequestBody VentaDTO ventaDTO) {

        return ResponseEntity.ok(
                ventaService.actualizarVenta(id, ventaDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}
