/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Categoria;
import proyecto.restaurante.Entidades.Estado;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;

/**
 *
 * @author Emito
 */
public class PedidoData {
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Pedido p;
    private PedidoData pd;
    private MesaData mad;
    private MeseroData mod;
    private Mesa m;
    

    public PedidoData() {
        con = Conexion.getConexion();
        mad = new MesaData();
        mod = new MeseroData();
    }
    
    public void guardarPedido(Pedido p){
        sql = "INSERT INTO pedidos(idMesa,idMesero,FechaPedido,HoraPedido,estado) VALUES (?,?,?,?,?)";                
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,p.getMesa().getIdMesa());
            ps.setInt(2, p.getMesero().getIdMesero());
            ps.setDate(3, Date.valueOf(p.getFechaPedido()));
            ps.setTime(4, Time.valueOf(p.getHoraPedido()));
            ps.setBoolean(5, p.isEstado());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                p.setIdPedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"PedidoData : Pedido cargado con exito.");
            }else{
                JOptionPane.showMessageDialog(null,"PedidoData : Error al cargar ID.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"PedidoData: Error al guardar Pedido "+ex.getMessage());
        }
    }
    
    public Pedido buscarPedido(int id){
        p = null;
        sql = "SELECT * FROM pedidos WHERE idPedido=?" ;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);            
            rs = ps.executeQuery();            
            if(rs.next()){
                p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setMesa(mad.obtenerMesa(rs.getInt("idMesa")));
                p.setMesero(mod.buscarMeseroPorId(rs.getInt("idMesero")));
                p.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                p.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                p.setImporte(rs.getDouble("importe"));
                p.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"PedidoData : No se encontro pedido con id : '" + id+"'");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"PedidoData : Error al buscar" + ex.getMessage());
        }        
        return p;
    }
    
    public void modificarPedido (Pedido p){
        
        sql ="UPDATE pedidos SET idMesa=?,idMesero=?,FechaPedido=?,HoraPedido=?,importe=?,estado=? WHERE idPedido=?";     
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,p.getMesa().getIdMesa());
            ps.setInt(2,p.getMesero().getIdMesero());
            ps.setDate(3,Date.valueOf(p.getFechaPedido()));            
            ps.setTime(4,Time.valueOf(p.getHoraPedido()));
            ps.setDouble(5, p.getImporte());
            ps.setBoolean(5, p.isEstado());
            ps.setInt(6, p.getIdPedido());
            
            int resultSet = ps.executeUpdate();            
            if(resultSet == 1){
                JOptionPane.showMessageDialog(null,"PedidoData : Pedido modificado correctamente.");
            }else{
                JOptionPane.showMessageDialog(null,"PedidoData : No se encontro pedido a modificar.");      
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"PedidoData : Error al modificar pedido"+ex.getMessage());  
        }
    }
    
    public void eliminarPedido(int id){
        sql = "UPDATE pedidos SET estado=? WHERE idPedidos=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2,id);
            int resultSet = ps.executeUpdate();
            
            if(resultSet ==1){
                JOptionPane.showMessageDialog(null, "PedidoData : Pedido eliminado con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "PedidoData : No se encontro una pedido a eliminar.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al eliminar el pedido"+ex.getMessage());
        }        
    }
    
    public List<Pedido> listarPedidos(){
        List<Pedido> listaPedidos= new ArrayList();
        sql = "SELECT * FROM pedidos WHERE estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs = ps.executeQuery();            
            while(rs.next()){
                p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setMesa(mad.obtenerMesa(rs.getInt("idMesa")));
                p.setMesero(mod.buscarMeseroPorId(rs.getInt("idMesero")));
                p.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                p.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                p.setImporte(rs.getDouble("importe"));
                p.setEstado(rs.getBoolean("estado"));              
                listaPedidos.add(p);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaPedidos;
    }
    
    public List<Mesa> listarMesas(int mesero){
        List<Mesa> listaMesas= new ArrayList();
        sql = "SELECT * FROM mesas JOIN pedidos ON mesas.idMesa = pedidos.idMesa WHERE pedidos.estado =? AND IdMesero = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, mesero);
            rs = ps.executeQuery();            
            while(rs.next()){
                m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setCapacidad(rs.getInt("Capacidad"));
                m.setEstado(Estado.valueOf(rs.getString("Estado")));
                listaMesas.add(m);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaMesas;
    }
    
    public ArrayList<Pedido> obtenerMesasOcupadasPorMesero(int idMesero){        
        
        ArrayList<Pedido> listaMesasMeseros = new ArrayList();
        pd = new PedidoData();
        for(Pedido pedidos : pd.listarPedidos()){
            if(pedidos.getMesa().getEstado() == Estado.OCUPADA && pedidos.getMesero().getIdMesero() == idMesero){
                listaMesasMeseros.add(pedidos);
            }
            
        }
               
        return listaMesasMeseros;
    }
    
    
    public ArrayList<Pedido> listarPedidosPorMesa(int idMesa, int idMesero){
        ArrayList<Pedido> listaPedidos = new ArrayList();
        pd = new PedidoData();
        
        
        for(Pedido pedidos : pd.obtenerMesasOcupadasPorMesero(idMesero)){
            if(pedidos.getMesa().getIdMesa() == idMesa && pedidos.getMesero().getIdMesero() == idMesero){
                listaPedidos.add(pedidos);
            }            
        }
        
            
        return listaPedidos;

    }
}
