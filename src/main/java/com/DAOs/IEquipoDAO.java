package com.DAOs;

import com.model.Equipo;
import java.util.List;

public interface IEquipoDAO {
    
    public Equipo listarPorCuit(int cuit);
    public List<Equipo> listar();
    public boolean insertar(Equipo e);
    public boolean editar(Equipo e);
    public boolean delete(int cuit);
    
}
