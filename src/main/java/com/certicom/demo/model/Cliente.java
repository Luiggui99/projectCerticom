package com.certicom.demo.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 60, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 60, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "email", length = 60, unique = true)
    private String email;

    // @OneToMany(mappedBy = "cliente")
    // private Set<Venta> ventas;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nombres, String apellidos, String dni, String telefono, String email,
            Set<Venta> ventas) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        // this.ventas = ventas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public Set<Venta> getVentas() {
    //     return ventas;
    // }

    // public void setVentas(Set<Venta> ventas) {
    //     this.ventas = ventas;
    // }
}
