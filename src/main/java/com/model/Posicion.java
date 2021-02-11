package com.model;

public enum Posicion {
    DELANTERO("DELANTERO"),
    DEFENSOR("DEFENSOR"),
    MEDIOCAMPISTA("MEDIOCAMPISTA"),
    ARQUERO("ARQUERO");
    
    private final String nombre_posicion;
    
    private Posicion(String posicion) {
        nombre_posicion = posicion;
    }
    
    public String getNombre_posicion() {
        return nombre_posicion;
    }
}
