/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Categoria;
import proyecto.restaurante.Entidades.DetallePedido;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;

/**
 *
 * @author Emito
 */
public class ProductoData {
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Producto p;
    private DetallePedido detalleProducto;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    
    //Método que recibe un objeto(materia), para guardar informacion en la base de datos.
    public void guardarProducto(Producto p){
    // >>Signos "?" son propiedades asignadas a traves del preparedStatement.<<
        sql = "INSERT INTO productos(nombre, cantidad, categoria, precio, estado) VALUES (?,?,?,?,?)";                
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getNombre());
            ps.setInt(2, p.getCantidad());
            ps.setString(3, p.getCategoria().toString());
            ps.setDouble(4, p.getPrecio());
            ps.setBoolean(5, p.isEstado());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                p.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"ProductoData : Producto cargado con exito.");
            }else{
                JOptionPane.showMessageDialog(null,"ProductoData : Error al cargar ID.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ProductoData: Error al guardar Producto "+ex.getMessage());
        }
    }
    
    //Método que realiza la busqueda en la base de datos, a traves de ID.
    public Producto buscarProducto(int id){
        p = null;
        sql = "SELECT * FROM productos WHERE idProducto=?" ;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);            
            rs = ps.executeQuery();            
            if(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"ProductoData : No se encontro producto con id : '" + id+"'");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ProductoData : Error al buscar" + ex.getMessage());
        }        
        return p;
    }   
    
    //Método que recibe Objeto(materia) para su modificación en la base de datos.
    public void modificarProducto (Producto p){
        sql ="UPDATE productos SET nombre=?,cantidad=?,categoria=?,precio=?,estado=? WHERE idProducto=?";     
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setInt(2,p.getCantidad());
            ps.setString(3,p.getCategoria().toString());            
            ps.setDouble(4,p.getPrecio());
            ps.setBoolean(5, p.isEstado());
            ps.setInt(6, p.getIdProducto());
            
            int resultSet = ps.executeUpdate();            
            if(resultSet == 1){
                JOptionPane.showMessageDialog(null,"ProductoData : Producto modificado correctamente.");
            }else{
                JOptionPane.showMessageDialog(null,"productoData : No se encontro producto a modificar.");      
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ProductoData : Error al modificar producto"+ex.getMessage());  
        }
    }    
    
    //Método que recibe ID para la eliminación en la base de datos.
    public void eliminarProducto(int id){
        sql = "UPDATE productos SET estado=? WHERE idProducto=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2,id);
            int resultSet = ps.executeUpdate();
            
            if(resultSet ==1){
                JOptionPane.showMessageDialog(null, "ProductoData : Producto eliminado con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "ProductoData : No se encontro una producto a eliminar.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al eliminar el producto"+ex.getMessage());
        }        
    }
    
    //Método que permite listar las Materias encontradas en la base de datos.
    public List<Producto> listarProductos(){
        List<Producto> listaProductos= new ArrayList();
        sql = "SELECT * FROM productos WHERE estado = ? ORDER BY nombre";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs = ps.executeQuery();            
            while(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));               
                listaProductos.add(p);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaProductos;
    }
    
    public List<Producto> listarProductosInactivos(){
        List<Producto> listaProductos= new ArrayList();
        sql = "SELECT * FROM productos WHERE estado = ? ORDER BY nombre";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            rs = ps.executeQuery();            
            while(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));               
                listaProductos.add(p);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaProductos;
    }
    
    
    
       
}
