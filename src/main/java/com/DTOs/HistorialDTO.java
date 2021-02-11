package com.DTOs;

import java.time.LocalDate;
import com.model.Posicion;

public class HistorialDTO {
    
    private Integer dni_jugador;
    private Integer cuit_equipo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Posicion posicion_jugador;

    public Integer getDni_jugador() {
        return dni_jugador;
    }

    public void setDni_jugador(Integer dni_jugador) {
        this.dni_jugador = dni_jugador;
    }

    public Integer getCuit_equipo() {
        return cuit_equipo;
    }

    public void setCuit_equipo(Integer cuit_equipo) {
        this.cuit_equipo = cuit_equipo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Posicion getPosicion_jugador() {
        return posicion_jugador;
    }

    public void setPosicion_jugador(Posicion posicion_jugador) {
        this.posicion_jugador = posicion_jugador;
    }
    
    @Override
    public String toString() {
        return "{ dni_jugador=" + dni_jugador + ", cuit_equipo=" + cuit_equipo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", posicion_jugador=" + posicion_jugador + " }";
    }
    
}
