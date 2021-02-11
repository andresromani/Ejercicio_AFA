package com.services;

import com.DTOs.JugadorDTO;
import com.exception.ServiceException;
import java.util.List;
import com.model.Jugador;

public interface IJugadorService {
    
    public JugadorDTO listarPorDNI(int dni) throws ServiceException;
    public List<JugadorDTO> listar() throws ServiceException;
    public void insertar(JugadorDTO jdto) throws ServiceException;
    public void editar(JugadorDTO jdto) throws ServiceException;
    public void delete(int dni) throws ServiceException;
    public JugadorDTO convertirJugadorADTO(Jugador j);
    public Jugador convertirDTOAJugador(JugadorDTO jdto);
    
}
