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
import proyecto.restaurante.Entidades.DetallePedido;


public class DetallePedidoData {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private DetallePedido detallePedido;

    public DetallePedidoData() {
        con=Conexion.getConexion();
    }

    public List<DetallePedido> listarProductosPorId(int idPedido){
        List<DetallePedido> listaProductos= new ArrayList();
        sql = "SELECT * FROM `detallepedidos` WHERE idPedido=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idPedido);
            rs = ps.executeQuery();            
            while(rs.next()){
                detallePedido = new DetallePedido();
                detallePedido.setIdDetallePedido(rs.getInt("idDetallePedido"));
                detallePedido.setIdProducto(rs.getInt("idProducto"));
                detallePedido.setIdPedido(rs.getInt("idPedido"));
                detallePedido.setCantidad(rs.getInt("Cantidad"));
                listaProductos.add(detallePedido);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaProductos;
    }
    
    public void EliminarDetallePedido(int idPedido){
        sql = "DELETE FROM detallepedidos WHERE idPedido=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idPedido);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No hay productos "+ex.getMessage());
        }
    }
    
    public void cargarProductosBD(DetallePedido detalle){
        sql = "INSERT INTO `detallepedidos`(`idProducto`, `idPedido`, `Cantidad`) VALUES (?,?,?)";                
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getIdProducto());
            ps.setInt(2, detalle.getIdPedido());
            ps.setInt(3,detalle.getCantidad());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                detalle.setIdDetallePedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Producto Agregado al pedido ");
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al asignar producto "+ex.getMessage());
        }
    }
    
    public List<DetallePedido> BuscarProductosConPedidos(int idPedido){
        List<DetallePedido> detallePedidos = new ArrayList();
        sql = "SELECT * from detallepedidos WHERE idPedido=?";                
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idPedido);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setIdDetallePedido(rs.getInt("idDetallePedido"));
                detallePedido.setIdProducto(rs.getInt("idProducto"));
                detallePedido.setIdPedido(rs.getInt("idPedido"));
                detallePedido.setCantidad(rs.getInt("Cantidad"));
                detallePedidos.add(detallePedido);
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al asignar producto "+ex.getMessage());
        }
        return detallePedidos;
    }
    
    public void EliminarDetalle(int idDetalle){
        
        sql = "DELETE FROM detallepedidos WHERE idDetallePedido=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idDetalle);
            ps.executeUpdate();
            int ResSet=ps.executeUpdate();
            if (ResSet==1){
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No hay productos "+ex.getMessage());
        }
    }


}

