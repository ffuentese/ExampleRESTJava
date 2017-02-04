/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco
 */
public class CountryDAO {
      private static final String SQL_READ = "SELECT id, name, capital "
            + "FROM countries WHERE id = ?";
    private static final String SQL_READALL = "SELECT id, name, capital "
            + " FROM countries";
    private static final String SQL_CREATE = "INSERT INTO countries (name, capital) "
            + " values (?, ?)";
    private static final String SQL_UPDATE = "UPDATE countries SET name = ?,"
            + "capital = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM countries WHERE id = ?";

    private static final Conexion con = Conexion.getInstancia();




    public boolean create(Country g) {
        //permite vincular la declaración a un objeto generico
        PreparedStatement ps;
        try {

            ps = con.getConexion().prepareStatement(SQL_CREATE);
            ps.setString(1, g.getName());
            ps.setString(2, g.getCapital());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    public Country read(Object key) {
        PreparedStatement ps;
        Country dto = null;
        try {

            ps = con.getConexion().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new Country(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return dto;
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return dto;
    }
    
        public ArrayList<Country> readAll() {
        PreparedStatement ps;
        Country dto = null;
        ArrayList<Country> productos = new ArrayList();
        try {

            ps = con.getConexion().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new Country(rs.getInt(1), rs.getString(2), rs.getString(3));
                productos.add(dto);
            }
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return productos;
    }

    public boolean update(Country g) {
        //permite vincular el instatment a iun objeto generico
        PreparedStatement ps;
        try {

            ps = con.getConexion().prepareStatement(SQL_UPDATE);
            ps.setString(1, g.getName());
            ps.setString(2, g.getCapital());
            ps.setInt(3, g.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getConexion().prepareStatement(SQL_DELETE);
            ps.setInt(1, Integer.parseInt(key.toString()));

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

}
