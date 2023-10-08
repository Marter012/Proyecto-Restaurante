/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.*;
import java.sql.Date;
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
    md= new MesaData();
}
    
    public void guardarReserva(Reserva res){
        sql="INSERT INTO reservas (NombreCliente,DNI,Fecha,Hora,Estado,idMesa) VALUES (?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,res.getNombreCliente());
            ps.setInt(2,res.getDni());
            ps.setDate(3,Date.valueOf(res.getFecha()));
            ps.setTime(4,Time.valueOf(res.getHora()));
            ps.setBoolean(5,res.isEstado());
            ps.setInt(6,res.getMesa().getIdMesa());
            rs= ps.getGeneratedKeys();
                    
               if(rs.next()){
                   res.setIdReserva(rs.getInt(1));
                   JOptionPane.showMessageDialog(null,"ReservaData : Reserva cargada con exito.");
               }else {
                   JOptionPane.showMessageDialog(null,"ReservaData : Error al cargar la reserva");
               }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ReservaData: Error al guardar la reserva"+ex.getMessage());
        }
        
 }

 
    public List<Reserva> listarReservas(){
        List<Reserva> listaReservas= new Arraylist();
       
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
               res.setMesa(md.obtenerMesa(rs.getInt(6)));
               listaReservas.add(res);
            }
            ps.close();
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ReservaData: Error al obtener lista de reservas"+ex.getMessage());
        }
        return listaReservas;
    }


    

   
}
