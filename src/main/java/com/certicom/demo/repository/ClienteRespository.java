package com.certicom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certicom.demo.model.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long>{
    
}
