package com.DAOs;

import com.config.MariaDBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Equipo;

public class EquipoDAOMariaDBImpl implements IEquipoDAO {

    @Override
    public Equipo listarPorCuit(int cuit) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "SELECT * FROM equipos WHERE cuit = " + cuit;
        Equipo e = new Equipo();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e.setCuit(rs.getInt(1));
                    e.setNombre(rs.getString(2));
                    e.setCategoria_actual(rs.getString(3));
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
        
        return e;
    }

    @Override
    public List<Equipo> listar() {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "SELECT * FROM equipos";
        List<Equipo> listado_equipos = new ArrayList();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Equipo e = new Equipo();
                    e.setCuit(rs.getInt(1));
                    e.setNombre(rs.getString(2));
                    e.setCategoria_actual(rs.getString(3));
                    listado_equipos.add(e);
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
        
        return listado_equipos;
    }

    @Override
    public boolean insertar(Equipo e) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "INSERT INTO equipos VALUES (" + e.getCuit() + ", '" + e.getNombre() + "', '" + e.getCategoria_actual() + "')";
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean editar(Equipo e) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "UPDATE equipos SET cuit = " + e.getCuit() + ", nombre = '" + e.getNombre() + "', categoria = '" + e.getCategoria_actual() + "' WHERE cuit = " + e.getCuit();
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(int cuit) {
        MariaDBConexion cnx = new MariaDBConexion();
        String sql = "DELETE FROM equipos WHERE cuit = " + cuit;
        
        try (Connection con = cnx.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        
        return true;
    }
    
}
