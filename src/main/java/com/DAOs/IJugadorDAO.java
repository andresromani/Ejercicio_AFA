package com.DAOs;

import com.exception.DAOException;
import java.util.List;
import com.model.Jugador;

public interface IJugadorDAO {
    
    public Jugador listarPorDNI(int dni) throws DAOException;
    public List<Jugador> listar() throws DAOException;
    public void insertar(Jugador j) throws DAOException;
    public void editar(Jugador j) throws DAOException;
    public void delete(int dni) throws DAOException;
    
}
