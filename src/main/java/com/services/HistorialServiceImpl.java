package com.services;

import com.DAOs.HistorialDAOMariaDBImpl;
import com.DTOs.HistorialDTO;
import java.util.ArrayList;
import java.util.List;
import com.model.Historial;

public class HistorialServiceImpl implements IHistorialService {
    
    HistorialDAOMariaDBImpl hdao = new HistorialDAOMariaDBImpl();

    @Override
    public List<HistorialDTO> listarPorDNI(int dni) {
        List<HistorialDTO> listado_historiales = new ArrayList();
        
        hdao.listarPorDNI(dni).forEach(h -> listado_historiales.add(convertirHistorialADTO(h)));
        
        return listado_historiales;
    }

    @Override
    public List<HistorialDTO> listarPorCUIT(int cuit) {
        List<HistorialDTO> listado_historiales = new ArrayList();
        
        hdao.listarPorCUIT(cuit).forEach(h -> listado_historiales.add(convertirHistorialADTO(h)));
        
        return listado_historiales;
    }

    @Override
    public boolean insertar(HistorialDTO hdto) {
        return hdao.insertar(convertirDTOAHistorial(hdto));
    }

    @Override
    public boolean editar(HistorialDTO hdto) {
        return hdao.editar(convertirDTOAHistorial(hdto));
    }

    @Override
    public boolean delete(int dni) {
        return hdao.delete(dni);
    }
    
    @Override
    public HistorialDTO convertirHistorialADTO(Historial h) {
        HistorialDTO hdto = new HistorialDTO();
        hdto.setDni_jugador(h.getDni_jugador());
        hdto.setCuit_equipo(h.getCuit_equipo());
        hdto.setFecha_inicio(h.getFecha_inicio());
        hdto.setFecha_fin(h.getFecha_fin());
        hdto.setPosicion_jugador(h.getPosicion_jugador());
        return hdto;
    }
    
    @Override
    public Historial convertirDTOAHistorial(HistorialDTO hdto) {
        Historial h = new Historial();
        h.setDni_jugador(hdto.getDni_jugador());
        h.setCuit_equipo(hdto.getCuit_equipo());
        h.setFecha_inicio(hdto.getFecha_inicio());
        h.setFecha_fin(hdto.getFecha_fin());
        h.setPosicion_jugador(hdto.getPosicion_jugador());
        return h;
    }
    
}
