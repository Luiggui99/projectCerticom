package com.certicom.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certicom.demo.exception.ResourceNotFoundException;
import com.certicom.demo.model.DetalleVenta;
import com.certicom.demo.repository.DetalleVentaRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleVentaController {
    
    @Autowired
    private DetalleVentaRepository repositorio;

    @GetMapping("/detalleVenta")
    private List<DetalleVenta> lsitAllDetalleVenta(){
        return repositorio.findAll();
    }

    @PostMapping("/detalleVenta")
    private DetalleVenta savedDetalleVenta(@RequestBody DetalleVenta detalleventa){
        return repositorio.save(detalleventa);
    }

    @GetMapping("/detalleVenta/{id}")
    private ResponseEntity<DetalleVenta> getDetalleVentaId(@PathVariable Long id) {
        DetalleVenta detalleVenta = repositorio.findById(id)
                                    .orElseThrow( () -> new ResourceNotFoundException(("No existe detalleVenta con el ID:" + id)));
        return ResponseEntity.ok(detalleVenta);
    }
}
