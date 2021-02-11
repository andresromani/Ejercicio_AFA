package com.services;

import com.DAOs.EquipoDAOMariaDBImpl;
import com.DTOs.EquipoDTO;
import com.DTOs.JugadorDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.model.Equipo;
import com.model.Posicion;

public class EquipoServiceImpl implements IEquipoService {
    
    EquipoDAOMariaDBImpl edao = new EquipoDAOMariaDBImpl();

    @Override
    public EquipoDTO listarPorCuit(int cuit) {
        return convertirEquipoADTO(edao.listarPorCuit(cuit));
    }

    @Override
    public List<EquipoDTO> listar() {
        List<EquipoDTO> listado_equipos = new ArrayList();
        
        edao.listar().forEach(e -> listado_equipos.add(convertirEquipoADTO(e)));
        
        return listado_equipos;
    }

    @Override
    public boolean insertar(EquipoDTO edto) {
        return edao.insertar(convertirDTOAEquipo(edto));
    }

    @Override
    public boolean editar(EquipoDTO edto) {
        return edao.editar(convertirDTOAEquipo(edto));
    }

    @Override
    public boolean delete(int cuit) {
        return edao.delete(cuit);
    }
    
    @Override
    public EquipoDTO convertirEquipoADTO(Equipo e) {
        EquipoDTO edto = new EquipoDTO();
        edto.setCuit(e.getCuit());
        edto.setNombre(e.getNombre());
        edto.setCategoria_actual(e.getCategoria_actual());
        return edto;
    }
    
    @Override
    public Equipo convertirDTOAEquipo(EquipoDTO edto) {
        Equipo e = new Equipo();
        e.setCuit(edto.getCuit());
        e.setNombre(edto.getNombre());
        e.setCategoria_actual(edto.getCategoria_actual());
        return e;
    }
    
    @Override
    public List<JugadorDTO> contarJugadoresPorEquipo(EquipoDTO e) {
        List<JugadorDTO> lista_jugadores = new ArrayList();
        
        if (e.getListado_jugadores() != null && e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                j.getListado_historiales().forEach(h -> {
                    if (e.getCuit().equals(h.getCuit_equipo()) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(LocalDate.now()))) {
                        lista_jugadores.add(j);
                    }
                });
            });
        }
        
        return lista_jugadores;
    }
    
    @Override
    public List<JugadorDTO> contarJugadorPorPosicion(EquipoDTO e, Posicion posicion) {
        List<JugadorDTO> lista_filtrada = new ArrayList();
        
        if (e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                if (j.getListado_historiales() != null && j.getListado_historiales().size() > 0) {
                    j.getListado_historiales().forEach(h -> {
                        if (e.getCuit().equals(h.getCuit_equipo()) && h.getPosicion_jugador().getNombre_posicion().equals(posicion.getNombre_posicion()) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(LocalDate.now()))) {
                            lista_filtrada.add(j);
                        }
                    });
                }
            });
        }
        
        return lista_filtrada;
    }
    
    @Override
    public List<JugadorDTO> cuantosJugadoresJugabanDuranteUnaFecha(EquipoDTO e, LocalDate fecha) {
        List<JugadorDTO> lista_filtrada = new ArrayList();
        
        if (e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                if (j.getListado_historiales() != null && j.getListado_historiales().size() > 0) {
                    j.getListado_historiales().forEach(h -> {
                        if (e.getCuit().equals(h.getCuit_equipo()) && h.getFecha_inicio().isBefore(fecha) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(fecha))) {
                            lista_filtrada.add(j);
                        }
                    });
                }
            });
        }
        
        return lista_filtrada;
    }
    
}
