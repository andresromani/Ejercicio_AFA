package com.model;

import java.time.LocalDate;
import java.util.List;

public class Equipo {
    
    private Integer cuit;
    private String nombre;
    private LocalDate fecha_fundacion;
    private String nombre_presidente;
    private Direccion direccion;
    private int telefono;
    private String email;
    private String categoria_actual;
    private List<Jugador> listado_jugadores;
    
    public Equipo() {
    }

    public Equipo(int cuit, String nombre, LocalDate fecha_fundacion, String nombre_presidente, Direccion direccion, int telefono, String email, String categoria_actual) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.fecha_fundacion = fecha_fundacion;
        this.nombre_presidente = nombre_presidente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.categoria_actual = categoria_actual;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(LocalDate fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public String getNombre_presidente() {
        return nombre_presidente;
    }

    public void setNombre_presidente(String nombre_presidente) {
        this.nombre_presidente = nombre_presidente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria_actual() {
        return categoria_actual;
    }

    public void setCategoria_actual(String categoria_actual) {
        this.categoria_actual = categoria_actual;
    }
    
}
