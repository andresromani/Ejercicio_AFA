package com.services;

import com.DAOs.JugadorDAOMariaDBImpl;
import com.DTOs.JugadorDTO;
import com.exception.DAOException;
import com.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
import com.model.Jugador;

public class JugadorServiceImpl implements IJugadorService {
    
    JugadorDAOMariaDBImpl jdao = new JugadorDAOMariaDBImpl();
    HistorialServiceImpl hservice = new HistorialServiceImpl();

    @Override
    public JugadorDTO listarPorDNI(int dni) throws ServiceException {
        JugadorDTO jdto = null;
        
        try {
            jdto = convertirJugadorADTO(jdao.listarPorDNI(dni));
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ServiceException("Error ServiceExcepton listarPorDNI : " + ex.getMessage());
        }
        
        if (hservice.listarPorDNI(jdto.getDni()) != null) { 
            jdto.setListado_historiales(hservice.listarPorDNI(jdto.getDni()));
        }
        
        return jdto;
    }

    @Override
    public List<JugadorDTO> listar() throws ServiceException {
        List<JugadorDTO> listado_jugadores = new ArrayList();
        
        try {
            jdao.listar().forEach(j -> listado_jugadores.add(convertirJugadorADTO(j)));
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ServiceException("Error ServiceExcepton listar : " + ex.getMessage());
        }
        
        listado_jugadores.forEach(j -> {
            if (hservice.listarPorDNI(j.getDni()) != null) { 
                j.setListado_historiales(hservice.listarPorDNI(j.getDni()));
            }
        });
        
        return listado_jugadores;
    }

    @Override
    public void insertar(JugadorDTO jdto) throws ServiceException {
        try {
            jdao.insertar(convertirDTOAJugador(jdto));
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ServiceException("Error ServiceExcepton insertar : " + ex.getMessage());
        }
    }

    @Override
    public void editar(JugadorDTO jdto) throws ServiceException {
        try {
            jdao.editar(convertirDTOAJugador(jdto));
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ServiceException("Error ServiceExcepton editar : " + ex.getMessage());
        }
    }

    @Override
    public void delete(int dni) throws ServiceException {
        try {
            jdao.delete(dni);
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ServiceException("Error ServiceExcepton delete : " + ex.getMessage());
        }
    }
    
    @Override
    public JugadorDTO convertirJugadorADTO(Jugador j) {
        JugadorDTO jdto = new JugadorDTO();
        jdto.setDni(j.getDni());
        jdto.setNombre(j.getNombre());
        jdto.setApellido(j.getApellido());
        return jdto;
    }
    
    @Override
    public Jugador convertirDTOAJugador(JugadorDTO jdto) {
        Jugador j = new Jugador();
        j.setDni(jdto.getDni());
        j.setNombre(jdto.getNombre());
        j.setApellido(jdto.getApellido());
        return j;
    }
    
}
