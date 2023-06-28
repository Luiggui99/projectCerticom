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
import com.certicom.demo.model.Producto;
import com.certicom.demo.model.Venta;
import com.certicom.demo.repository.VentaRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {
    
    @Autowired
    private VentaRepository repositorio;

    @GetMapping("/ventas")
    public List<Venta> listAllVentas(){
        return repositorio.findAll();
    }

    @PostMapping("/ventas")
    public Venta saveVenta(@RequestBody Venta venta){
        return repositorio.save(venta);
    }

     @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> getVentaId(@PathVariable Long id) {
        Venta venta = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe venta con el ID:" + id)));

        return ResponseEntity.ok(venta);
    }
}
