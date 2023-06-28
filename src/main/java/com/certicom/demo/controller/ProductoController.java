package com.certicom.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certicom.demo.exception.ResourceNotFoundException;
import com.certicom.demo.model.Producto;
import com.certicom.demo.repository.ProductoRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    private ProductoRepository repositorio;

    @GetMapping("/productos")
    public List<Producto> listAllProductos() {
        return repositorio.findAll();
    }

    @PostMapping("/productos")
    public Producto saveProducto(@RequestBody Producto producto) {
        return repositorio.save(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoId(@PathVariable Long id) {
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe producto con el ID:" + id)));

        return ResponseEntity.ok(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto detailsProducto) {
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe producto con el ID:" + id)));

        producto.setNombre(detailsProducto.getNombre());
        producto.setPrecio(detailsProducto.getPrecio());

        Producto productoOk = repositorio.save(producto);
        return ResponseEntity.ok(productoOk);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id) {
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));

        repositorio.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
