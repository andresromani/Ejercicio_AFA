package com.services;

import com.DTOs.HistorialDTO;
import java.util.List;
import com.model.Historial;

public interface IHistorialService {
    
    public List<HistorialDTO> listarPorDNI(int dni);
    public List<HistorialDTO> listarPorCUIT(int cuit);
    public boolean insertar(HistorialDTO hdto);
    public boolean editar(HistorialDTO hdto);
    public boolean delete(int dni);
    public HistorialDTO convertirHistorialADTO(Historial h);
    public Historial convertirDTOAHistorial(HistorialDTO hdto);
    
}
