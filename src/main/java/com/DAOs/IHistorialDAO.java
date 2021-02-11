package com.DAOs;

import java.util.List;
import com.model.Historial;

public interface IHistorialDAO {
    
    public List<Historial> listarPorDNI(int dni);
    public List<Historial> listarPorCUIT(int cuit);
    public boolean insertar(Historial h);
    public boolean editar(Historial h);
    public boolean delete(int dni);
    
}
