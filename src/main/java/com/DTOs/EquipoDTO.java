package com.DTOs;

import java.util.List;

public class EquipoDTO {
    
    private Integer cuit;
    private String nombre;
    private String categoria_actual;
    private List<JugadorDTO> listado_jugadores;

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

    public String getCategoria_actual() {
        return categoria_actual;
    }

    public void setCategoria_actual(String categoria_actual) {
        this.categoria_actual = categoria_actual;
    }

    public List<JugadorDTO> getListado_jugadores() {
        return listado_jugadores;
    }

    public void setListado_jugadores(List<JugadorDTO> listado_jugadores) {
        this.listado_jugadores = listado_jugadores;
    }
    
    public boolean agregarJugador(JugadorDTO j) {
        return listado_jugadores.add(j);
    }
    
    @Override
    public String toString() {
        return "Equipo{ cuit=" + cuit + ", nombre=" + nombre + ", categoría_actual=" + categoria_actual + " }";
    }
}
