package com.DAOs;

import com.config.MariaDBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Historial;
import com.model.Posicion;

public class HistorialDAOMariaDBImpl implements IHistorialDAO {

    @Override
    public List<Historial> listarPorDNI(int dni) {
        MariaDBConexion cnx = new MariaDBConexion();
        List<Historial> listado_historiales = new ArrayList();
        String sql = "SELECT * FROM historial_jugadores WHERE dni_jugador = " + dni;
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery() ) {
                while (rs.next()) {
                    Historial h = new Historial();
                    h.setDni_jugador(rs.getInt(2));
                    h.setCuit_equipo(rs.getInt(3));
                    if (rs.getDate(4) != null) h.setFecha_inicio(rs.getDate(4).toLocalDate());
                    if (rs.getDate(5) != null) h.setFecha_fin(rs.getDate(5).toLocalDate());
                    if (rs.getString(6).equals("DELANTERO")) h.setPosicion_jugador(Posicion.DELANTERO);
                    if (rs.getString(6).equals("DEFENSOR")) h.setPosicion_jugador(Posicion.DEFENSOR);
                    if (rs.getString(6).equals("MEDIOCAMPISTA")) h.setPosicion_jugador(Posicion.MEDIOCAMPISTA);
                    if (rs.getString(6).equals("ARQUERO")) h.setPosicion_jugador(Posicion.ARQUERO);
                    listado_historiales.add(h);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return listado_historiales;
    }

    @Override
    public List<Historial> listarPorCUIT(int cuit) {
        MariaDBConexion cnx = new MariaDBConexion();
        List<Historial> listado_historiales = new ArrayList();
        String sql = "SELECT * FROM historial_jugadores WHERE cuit_equipo = " + cuit;
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery() ) {
                while (rs.next()) {
                    Historial h = new Historial();
                    h.setDni_jugador(rs.getInt(2));
                    h.setCuit_equipo(rs.getInt(3));
                    if (rs.getDate(4) != null) h.setFecha_inicio(rs.getDate(4).toLocalDate());
                    if (rs.getDate(5) != null) h.setFecha_fin(rs.getDate(5).toLocalDate());
                    if (rs.getString(6).equals("DELANTERO")) h.setPosicion_jugador(Posicion.DELANTERO);
                    if (rs.getString(6).equals("DEFENSOR")) h.setPosicion_jugador(Posicion.DEFENSOR);
                    if (rs.getString(6).equals("MEDIOCAMPISTA")) h.setPosicion_jugador(Posicion.MEDIOCAMPISTA);
                    if (rs.getString(6).equals("ARQUERO")) h.setPosicion_jugador(Posicion.ARQUERO);
                    listado_historiales.add(h);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return listado_historiales;
    }

    @Override
    public boolean insertar(Historial h) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "INSERT INTO historial_jugadores (dni_jugador, cuit_equipo, fecha_inicio, fecha_fin, posicion) VALUES (" + h.getDni_jugador() + ", " + h.getCuit_equipo() + ", " + (h.getFecha_inicio() != null ? "'" + h.getFecha_inicio().toString() + "'" : "NULL") + ", " + (h.getFecha_fin() != null ? "'" + h.getFecha_fin().toString() + "'" : "NULL") + ", '" + h.getPosicion_jugador() + "')";
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean editar(Historial h) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "UPDATE historial_jugadores SET dni_jugador = " + h.getDni_jugador() + ", cuit_equipo = " + h.getCuit_equipo() + ", fecha_inicio = " + (h.getFecha_inicio() != null ? "'" + h.getFecha_inicio().toString() + "'" : "NULL") + ", fecha_fin = " + (h.getFecha_fin() != null ? "'" + h.getFecha_fin().toString() + "'" : "NULL") + ", posicion = '" + h.getPosicion_jugador() + "' WHERE dni = " + h.getDni_jugador();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(int dni) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "DELETE FROM historial_jugadores WHERE dni = " + dni;
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }
    
}
