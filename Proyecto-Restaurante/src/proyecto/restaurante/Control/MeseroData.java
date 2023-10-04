/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.*;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Mesero;

/**
 *
 * @author Mauri
 */
public class MeseroData {
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Mesero m;

    public MeseroData (){
        con = Conexion.getConexion();
    }
    
    public void agregarMesero (Mesero m){
        sql = "INSERT INTO `meseros`(`Nombre`, `Apellido`, `DNI`, `Estado`, `Contraseña`) "
                + "VALUES (?,?,?,?,?)";        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,m.getNombre() );
            ps.setString(2,m.getApellido());
            ps.setInt(3,m.getDni());
            ps.setBoolean(4,m.isEstado());
            ps.setString(5,m.getPassword());            
            rs = ps.getGeneratedKeys();            
            if(rs.next()){
                m.setIdMesero(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"MeseroData : Mesero cargado con exito.");
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : Error al cargar ID de mesero.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al cargar mesero."+ ex.getMessage());
        }
    }
    
    
    public Mesero buscarMesero(int id){
        sql = "SELECT `idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Contraseña` FROM `meseros` WHERE idMesero=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id );
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Mesero();
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setPassword(rs.getString("Contraseña"));                
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : No se encontro un mesero con id : " + id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al buscar mesero."+ ex.getMessage());
        }
        
        return m;
    }
    
    public Mesero buscarMeseroPorDNI(int DNI){
        sql = "SELECT `idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Contraseña` FROM `meseros` WHERE idMesero=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, DNI );
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Mesero();
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setPassword(rs.getString("Contraseña"));                
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : No se encontro un mesero con DNI : " + DNI);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al buscar mesero."+ ex.getMessage());
        }
        return m;
    }
    
    
    public boolean loginMesero(int DNI, String Password) throws Exception{
        m = buscarMeseroPorDNI(DNI);
        boolean valid;
        
        if(m.getDni() != DNI ){
            JOptionPane.showMessageDialog(null,"MeseroData : El DNI no coincide con algun mesero registrado.");
            return valid = false;
        }
        if(m.getPassword()!= Password ){
            JOptionPane.showMessageDialog(null,"MeseroData : La contraseña es Incorrecta.");
            return valid = false;
        }        
        valid = true;  
        return valid;
    }
}
