/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author
 */
public class Conexion {

    public static Conexion instancia; //sirve para aplicar el singleton
    private static Connection conexion;

    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base", "base", "base");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            System.out.println("No existe conexión a la base o existe otro problema " + ex);
        } catch (Exception ex) {
            System.out.println("No existe conexión a la base o existe otro problema " + ex);
        }

    }//fin constructor
    //syncronized crea una lista de espera 
    //cuando hay muchos usuarios conectandose al sistema

    public synchronized static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public static Connection getConexion() {
        try {
            return conexion;
        } catch (Exception ex) {
            System.out.println("No es posible establecer una conexión a la base");
        }
        return conexion;
    }

    public void cerrarConexion() {
        instancia = null;
    }
}//fin clase

