/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Reserva;


/**
 *
 * @author ferna
 */
public class ReservaData {
    
    private Connection con=null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private MesaData md;
    private Mesa m;
    private Reserva res;
    
public ReservaData(){
    con=Conexion.getConexion();
}
    


    public List<Reserva> listarReservas(){
        md= new MesaData();
        List<Reserva> listarReservas= new Arraylist();
        
        sql="SELECT * FROM reserva";
        
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()){
               res=new Reserva();
               res.setNombreCliente(rs.getString(1));
               res.setDni(rs.getInt(2));
               res.setFecha(rs.getDate(3).toLocalDate());
               res.setHora(rs.getTime(4).toLocalTime());
               res.setEstado(rs.getBoolean(5));
               res.setMesa(md.obtenerMesasReservadas(rs.getInt(6)));
               listarReservas.add(res);
            }
            ps.close();
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ReservaData: Error al obtener lista de reservas"+ex.getMessage());
        }
        return listarReservas;
    }

  
    

   
}
