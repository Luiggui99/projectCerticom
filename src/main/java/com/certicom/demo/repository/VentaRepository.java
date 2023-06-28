package com.certicom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certicom.demo.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
    
}
