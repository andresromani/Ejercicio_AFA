package com.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Integrante {
    
    private List<Historial> listado_historiales;
    
    public Jugador() {
        listado_historiales = new ArrayList();
    }

    public Jugador(List<Historial> listadoHistoriales) {
        this.listado_historiales = listadoHistoriales;
    }
    
    public Jugador(int dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listado_historiales = new ArrayList();
    }

    public Jugador(List<Historial> listadoHistoriales, int dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listado_historiales = listadoHistoriales;
    }

    public List<Historial> getListadoHistoriales() {
        return listado_historiales;
    }

    public void setListadoHistoriales(List<Historial> listadoHistoriales) {
        this.listado_historiales = listadoHistoriales;
    }
    
}
