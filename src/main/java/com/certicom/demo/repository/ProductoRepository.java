package com.certicom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certicom.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
