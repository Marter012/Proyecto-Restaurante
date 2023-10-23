/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Estado;
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

    public Reserva buscarReserva(int DNI){
       
        sql="SELECT * FROM reservas WHERE DNI=?";
      
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, DNI);
            rs=ps.executeQuery();
            
             if(rs.next()){
                 res=new Reserva();
                 res.setIdReserva(rs.getInt("idReserva"));
                 res.setNombreCliente(rs.getString("NombreCliente"));
                 res.setDni(rs.getInt("DNI"));
                 res.setFecha(rs.getDate("Fecha").toLocalDate());
                 res.setHora(rs.getTime("Hora").toLocalTime());
                 res.setEstado(rs.getBoolean("Estado"));
                 res.setMesa(md.obtenerMesa(rs.getInt("idMesa")));
             }else{
                JOptionPane.showMessageDialog(null, "ReservaData : No se encontró reserva con DNI: "+DNI);      
            }
            ps.close();
      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ReservaData: Error al buscar reserva "+ex.getMessage());
      }
        return res;
    }
 
    public ArrayList<Reserva> listarReservas(){
        ArrayList <Reserva> listaReservas = new ArrayList();
       
        sql="SELECT * FROM reservas";
        
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

public ArrayList<Reserva> listarReservasPorFecha(Date Fecha){
        ArrayList <Reserva> reservasPorFecha = new ArrayList();
       
        sql="SELECT * FROM reserva WHERE fecha=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setDate(1,Fecha);
            rs=ps.executeQuery();
          
            while (rs.next()){
               res=new Reserva();
               res.setNombreCliente(rs.getString(1));
               res.setDni(rs.getInt(2));
               res.setFecha(rs.getDate(3).toLocalDate());
               res.setHora(rs.getTime(4).toLocalTime());
               res.setEstado(rs.getBoolean(5));
               res.setMesa(md.obtenerMesa(rs.getInt(6)));
               reservasPorFecha.add(res);
            }
            ps.close();
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ReservaData: Error al obtener lista de reservas en la fecha seleccionada"+ex.getMessage());
        }
        return reservasPorFecha;
    }
     
public  ArrayList<Mesa> mesasDisponibles(String Fecha,String Hora){
    ArrayList <Mesa> lista= new ArrayList();
    sql="SELECT * FROM mesas m WHERE m.estado=? AND m.idMesa NOT IN (SELECT r.idMesa FROM reservas r WHERE r.Fecha=? AND r.Hora=?)";
       SimpleDateFormat formatoDate= new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoTime = new SimpleDateFormat("HH:mm:ss");
    try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.LIBRE));
            ps.setDate(2, (Date) formatoDate.parse(Fecha));
            ps.setTime(3, (Time) formatoTime.parse(Hora));
            rs=ps.executeQuery();
            while(rs.next()){
                m=new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setCapacidad(rs.getInt("Capacidad"));
                lista.add(m);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ReservaData: Error al obtener mesas disponibles"+ex.getMessage());
        }
       return lista;
        }

    public void modificarReserva(Reserva res){
        sql="UPDATE reservas SET NombreClientE=?,DNI=?,Fecha=?,Hora=?,Estado=?,idMesa=? WHERE idReserva=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,res.getNombreCliente());
            ps.setInt(2, res.getDni());
            ps.setDate(3,Date.valueOf(res.getFecha()));
            ps.setTime(4,Time.valueOf(res.getHora()));
            ps.setBoolean(5,res.isEstado());
            ps.setInt(6,res.getMesa().getIdMesa());
            ps.setInt(7,res.getIdReserva());
            int resultSet= ps.executeUpdate();
            
              if(resultSet==1){
                    JOptionPane.showMessageDialog(null,"ReservaData : Reserva modificada correctamente");
              }else{
                JOptionPane.showMessageDialog(null,"ReservaData : No se encontró reserva para modificar");      
              }            
              ps.close();
              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ReservaData : Error al modificar la Reserva"+ex.getMessage()); 
        }
    }

    public void eliminarReserva(int DNI){ 
        sql= "UPDATE reservas SET estado=? WHERE DNI=?";
                
        try {
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2,DNI);
            int resultSet= ps.executeUpdate();
            if(resultSet==1){
                JOptionPane.showMessageDialog(null, "ReservaData : Reserva eliminada con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "ReservaData : No se encontró la reserva");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ReservaData: Error al eliminar la reserva"+ex.getMessage());
        }
        
    }
}
