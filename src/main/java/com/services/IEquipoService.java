package com.services;

import com.DTOs.EquipoDTO;
import com.DTOs.JugadorDTO;
import java.time.LocalDate;
import java.util.List;
import com.model.Equipo;
import com.model.Posicion;

public interface IEquipoService {
    
    public EquipoDTO listarPorCuit(int cuit);
    public List<EquipoDTO> listar();
    public boolean insertar(EquipoDTO edto);
    public boolean editar(EquipoDTO edto);
    public boolean delete(int cuit);
    public EquipoDTO convertirEquipoADTO(Equipo e);
    public Equipo convertirDTOAEquipo(EquipoDTO edto);
    public List<JugadorDTO> contarJugadoresPorEquipo(EquipoDTO e);
    public List<JugadorDTO> contarJugadorPorPosicion(EquipoDTO e, Posicion posicion);
    public List<JugadorDTO> cuantosJugadoresJugabanDuranteUnaFecha(EquipoDTO e, LocalDate fecha);
    
}
