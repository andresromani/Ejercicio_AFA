package com.DAOs;

import com.config.MariaDBConexion;
import com.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Jugador;

public class JugadorDAOMariaDBImpl implements IJugadorDAO {

    @Override
    public Jugador listarPorDNI(int dni) throws DAOException {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "SELECT * FROM jugadores WHERE dni = " + dni;
        Jugador j = new Jugador();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    j.setDni(rs.getInt(1));
                    j.setNombre(rs.getString(2));
                    j.setApellido(rs.getString(3));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException listarPorDNI : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException listarPorDNI : " + ex.getMessage());
        }
        
        return j;
    }

    @Override
    public List<Jugador> listar() throws DAOException {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "SELECT * FROM jugadores";
        List<Jugador> listado_jugadores = new ArrayList();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Jugador j = new Jugador();
                    j.setDni(rs.getInt(1));
                    j.setNombre(rs.getString(2));
                    j.setApellido(rs.getString(3));
                    listado_jugadores.add(j);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException listar : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException listar : " + ex.getMessage());
        }
        
        return listado_jugadores;
    }

    @Override
    public void insertar(Jugador j) throws DAOException {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "INSERT INTO jugadores VALUES (" + j.getDni() + ", '" + j.getNombre() + "', '" + j.getApellido() + "')";
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException insertar : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException insertar : " + ex.getMessage());
        }
    }

    @Override
    public void editar(Jugador j) throws DAOException {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "UPDATE jugadores SET dni = " + j.getDni() + ", nombre = '" + j.getNombre() + "', apellido = '" + j.getApellido() + "' WHERE dni = " + j.getDni();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException editar : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException editar : " + ex.getMessage());
        }
    }

    @Override
    public void delete(int dni) throws DAOException {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "DELETE FROM jugadores WHERE dni = " + dni;
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException delete : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new DAOException("Error DAOException delete : " + ex.getMessage());
        }
    }
    
}
