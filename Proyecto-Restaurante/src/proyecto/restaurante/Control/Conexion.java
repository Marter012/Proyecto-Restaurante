/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emito
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:3306/proyectorestaurante";
    private static final String USER="root";
    private static final String PWD="";
    private static Conexion conexion=null;
    
    private Conexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error carga de driver: "+ e.getMessage());
        }
    }
    
    public static Connection getConexion(){
        Connection con=null;
        if(conexion == null){
           conexion= new Conexion();
        }
        try{
            // Setup the connection with the DB
            con=DriverManager.getConnection(URL,USER,PWD);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion "+ex.getMessage());
        }
        
        return con;
    }
}
