/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Estado;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;

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
    public PedidoData pedidoData;
    public MesaData mesaData;

    public MeseroData (){
        con = Conexion.getConexion();
    }
    
    public void agregarMesero (Mesero m){
        sql = "INSERT INTO `meseros`(`Nombre`, `Apellido`, `DNI`, `Estado`, `Acceso`, `Contraseña`) "
                + "VALUES (?,?,?,?,?,?)";        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,m.getNombre() );
            ps.setString(2,m.getApellido());
            ps.setInt(3,m.getDni());
            ps.setBoolean(4,m.isEstado());
            ps.setInt(5,m.getAcceso());
            ps.setString(6,m.getPassword()); 
            ps.executeUpdate();
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
    
    
    public Mesero buscarMeseroPorId(int id){
        sql = "SELECT `idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Acceso`, `Contraseña` FROM `meseros` WHERE idMesero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id );
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
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
        sql = "SELECT `idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Acceso`, `Contraseña` FROM `meseros` WHERE DNI=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, DNI );
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
                m.setPassword(rs.getString("Contraseña"));                
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : No se encontro un mesero con DNI : " + DNI);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al buscar mesero."+ ex.getMessage());
        }
        return m;
    }
    
    public Mesero buscarMeseroPorLogin(int DNI){
        sql = "SELECT `idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Acceso`, `Contraseña` FROM `meseros` WHERE DNI=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, DNI );
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
                m.setPassword(rs.getString("Contraseña"));                
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : No se encontro un mesero con DNI : " + DNI);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al buscar mesero."+ ex.getMessage());
        }
        return m;
    }
    
    public void modificarMesero(Mesero m){
        sql = "UPDATE `meseros` SET `Nombre`=?,`Apellido`=?,`DNI`=?,`Estado`=?, `Acceso`=?, `Contraseña`=? WHERE idMesero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getApellido());
            ps.setInt(3, m.getDni());
            ps.setBoolean(4, m.isEstado());
            ps.setInt(5,m.getAcceso());
            ps.setString(6,m.getPassword());
            ps.setInt(7,m.getIdMesero());
            
            int resultSet = ps.executeUpdate();            
            if(resultSet == 1){
                JOptionPane.showMessageDialog(null,"MeseroData : Mesero modificado con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "MeseroData : No se encontro mesero a modificar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MeseroData : Error al modificar mesero.");
        }
    }
    
    public void eliminarMesero(Mesero m){
        sql = "UPDATE `meseros` SET `Estado`=? WHERE idMesero=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1,false);
            ps.setInt(2,m.getIdMesero());
            
            int resultSet = ps.executeUpdate();
            
            if(resultSet == 1){
                JOptionPane.showMessageDialog(null,"MeseroData : Mesero eliminado con exito");
            }else{
                JOptionPane.showMessageDialog(null,"MeseroData : No se encontro mesero a eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData : Error al modificar mesero.");
        }
    }
    
    
    public boolean loginMesero(int DNI, String Password) {
        m = buscarMeseroPorDNI(DNI);
        boolean valid = false;
        if (m!=null){
        
        
            if(m.getDni() != DNI ){
                
                return valid;
            }
            if(!m.getPassword().equals(Password) ){
                
                return valid;
            }
            if(m.getPassword().equals(Password) ){
                //JOptionPane.showMessageDialog(null,"MeseroData : La contraseña es Correcta.");
                return valid = true;
            } 
        }
        return valid;
    }
    
    public List<Mesero> ListarMeseros(){
        List<Mesero> listaMeseros = new ArrayList();
        Mesero m;
        sql = "SELECT * From meseros WHERE Acceso=2 AND Estado=1";
        
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
                m.setPassword(rs.getString("Contraseña"));
                listaMeseros.add(m);
                        
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData: Error al listar meseros");
        }
        return listaMeseros;
    }
    
    public List<Mesero> ListarEncargados(){
        List<Mesero> listaEncargados = new ArrayList();
        Mesero m;
        sql = "SELECT * From meseros WHERE Acceso=1 AND Estado=1";
        
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
                m.setPassword(rs.getString("Contraseña"));
                listaEncargados.add(m);
                        
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData: Error al listar meseros");
        }
        return listaEncargados;
    }
    
    public List<Mesero> ListarInactivos(){
        List<Mesero> listaInactivos = new ArrayList();
        Mesero m;
        sql = "SELECT * From meseros WHERE Estado=0";
        
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                m = new Mesero();
                m.setIdMesero(rs.getInt("idMesero"));
                m.setNombre(rs.getString("Nombre"));
                m.setApellido(rs.getString("Apellido"));
                m.setDni(rs.getInt("DNI"));
                m.setEstado(rs.getBoolean("Estado"));
                m.setAcceso(rs.getInt("Acceso"));
                m.setPassword(rs.getString("Contraseña"));
                listaInactivos.add(m);
                        
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MeseroData: Error al listar meseros");
        }
        return listaInactivos;
    }
    
}
