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
import com.certicom.demo.model.Cliente;
import com.certicom.demo.repository.ClienteRespository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteRespository repositorio;

    @GetMapping("/clientes")
    public List<Cliente> listAllClientes(){
        return repositorio.findAll();
    }

    @PostMapping("/clientes")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return repositorio.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteId(@PathVariable Long id) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe cliente con el ID:" + id)));

        return ResponseEntity.ok(cliente);
    }
}