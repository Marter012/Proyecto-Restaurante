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
import proyecto.restaurante.Entidades.Actividad;
import proyecto.restaurante.Entidades.Categoria;
import proyecto.restaurante.Entidades.Estado;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;


public class PedidoData {
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Pedido p;
    private PedidoData pd;
    private MesaData mesaData;
    private MeseroData meseroData;
    private Mesa m;
    

    public PedidoData() {
        con = Conexion.getConexion();
        mesaData = new MesaData();
        meseroData = new MeseroData();
    }
    
    public void guardarPedido(Pedido p){
        sql = "INSERT INTO pedidos(idMesa,idMesero,FechaPedido,HoraPedido,importe,estado,Actividad) VALUES (?,?,?,?,?,?,?)";                
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,p.getMesa().getIdMesa());
            ps.setInt(2, p.getMesero().getIdMesero());
            ps.setDate(3, Date.valueOf(p.getFechaPedido()));
            ps.setTime(4, Time.valueOf(p.getHoraPedido()));
            ps.setDouble(5,p.getImporte());
            ps.setBoolean(6, p.isEstado());
            ps.setString(7,String.valueOf(Actividad.INICIADA));
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                p.setIdPedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"PedidoData : Pedido cargado con exito con id: "+p.getIdPedido());
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
                p.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                p.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                p.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                p.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                p.setImporte(rs.getDouble("importe"));
                p.setEstado(rs.getBoolean("estado"));
                p.setActividad(Actividad.valueOf(rs.getString("Actividad")));
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
        
        sql ="UPDATE pedidos SET idMesa=?,idMesero=?,FechaPedido=?,HoraPedido=?,importe=?,estado=?,Actividad=? WHERE idPedido=?";     
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,p.getMesa().getIdMesa());
            ps.setInt(2,p.getMesero().getIdMesero());
            ps.setDate(3,Date.valueOf(p.getFechaPedido()));            
            ps.setTime(4,Time.valueOf(p.getHoraPedido()));
            ps.setDouble(5, p.getImporte());
            ps.setBoolean(6, p.isEstado());
            ps.setString(7, String.valueOf(p.getActividad()));
            ps.setInt(8, p.getIdPedido());
            
            
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
        sql = "UPDATE pedidos SET estado=? WHERE idPedido=?";   
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
                p.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                p.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                p.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                p.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                p.setImporte(rs.getDouble("importe"));
                p.setEstado(rs.getBoolean("estado"));
                p.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(p);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaPedidos;
    }
    
    public List<Pedido> listarTodosLosPedidos(){
        List<Pedido> listaPedidos= new ArrayList();
        sql = "SELECT * FROM pedidos WHERE 1";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1,false);
            rs = ps.executeQuery();            
            while(rs.next()){
                p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                p.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                p.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                p.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                p.setImporte(rs.getDouble("importe"));
                p.setEstado(rs.getBoolean("estado"));
                p.setActividad(Actividad.valueOf(rs.getString("Actividad")));
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
        for(Pedido pedidos : listarPedidos()){
            if(pedidos.getMesa().getEstado() == Estado.OCUPADA && pedidos.getMesero().getIdMesero() == idMesero && pedidos.isEstado()){
                listaMesasMeseros.add(pedidos);
            }else{
                continue;
            }
            
        }
               
        return listaMesasMeseros;
    }
    
    public ArrayList<Pedido> obtenerPedidosPorMesero(int idMesero){        
        
        ArrayList<Pedido> listaMesasMeseros = new ArrayList();
        for(Pedido pedidos : listarTodosLosPedidos()){
            if(pedidos.getMesero().getIdMesero() == idMesero){
                listaMesasMeseros.add(pedidos);
            }
        }
               
        return listaMesasMeseros;
    }
    
    public ArrayList<Pedido> listarMesasPorMesero(int idMesero){        
        
        ArrayList<Pedido> listaMesasMeseros = new ArrayList();
        for(Pedido pedidos : listarPedidos()){
            if(pedidos.getMesa().getEstado() == Estado.OCUPADA && pedidos.getMesero().getIdMesero() == idMesero && pedidos.isEstado()){
                listaMesasMeseros.add(pedidos);
            }else{
                continue;
            }
            
        }
               
        return listaMesasMeseros;
    }
    
    
    public ArrayList<Pedido> listarPedidosPorMesa(int idMesa, int idMesero){
        ArrayList<Pedido> listaPedidos = new ArrayList();
        
        
        
        for(Pedido pedidos : obtenerMesasOcupadasPorMesero(idMesero)){
            if(pedidos.getMesa().getIdMesa() == idMesa && pedidos.getMesero().getIdMesero() == idMesero){
                listaPedidos.add(pedidos);
            }            
        }
        
            
        return listaPedidos;

    }
    
    public Mesa obtenerMesa(int idPedido){
        Mesa mesa=null;
            sql = "SELECT idMesa FROM pedidos WHERE idPedido=?";
            try{
                ps = con.prepareStatement(sql);
                ps.setInt(1, idPedido);
                rs = ps.executeQuery();
                if(rs.next()){
                mesa=mesaData.obtenerMesa(rs.getInt("idMesa"));
                
            }    
            ps.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al actualizar precio. "+ex.getMessage());
        }
        return mesa;
    }
    
    public void ActualizarPrecio(int idPedido, double precio){
        sql = "UPDATE pedidos SET importe=? WHERE idPedido=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, precio);
            ps.setInt(2,idPedido);
            int resultSet = ps.executeUpdate();           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al actualizar precio. "+ex.getMessage());
        }        
    }
    
    public void CancelarPedido(int idPedido){
        sql = "UPDATE pedidos SET estado=?, Actividad=? WHERE idPedido=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2,String.valueOf(Actividad.CANCELADA));
            ps.setInt(3,idPedido);
            ps.executeUpdate();           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al cancelar pedido. "+ex.getMessage());
        }        
    }
    
    public void CobrarPedido(int idPedido){
        sql = "UPDATE pedidos SET estado=?, Actividad=? WHERE idPedido=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2,String.valueOf(Actividad.COBRADA));
            ps.setInt(3,idPedido);
            ps.executeUpdate();           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al cobrar pedido. "+ex.getMessage());
        }        
    }
    
    public void facturarPedido(int idPedido){
        sql = "UPDATE pedidos SET Actividad=? WHERE idPedido=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Actividad.FACTURADA));
            ps.setInt(2,idPedido);
            ps.executeUpdate();           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PedidoData : Error al cobrar pedido. "+ex.getMessage());
        }        
    }
    
    public List<LocalDate> FechasConPedidos(Mesero mesero){
        List<LocalDate> listaFechas= new ArrayList();
        sql = "SELECT FechaPedido FROM pedidos WHERE IdMesero = ? GROUP BY FechaPedido";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesero.getIdMesero());
            rs = ps.executeQuery();            
            while(rs.next()){
                LocalDate fecha = rs.getDate("FechaPedido").toLocalDate();
                listaFechas.add(fecha);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaFechas;
    }
    
    public List<LocalDate> FechasConPedidos(){
        List<LocalDate> listaFechas= new ArrayList();
        sql = "SELECT FechaPedido FROM pedidos GROUP BY FechaPedido";
        try {
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();            
            while(rs.next()){
                LocalDate fecha = rs.getDate("FechaPedido").toLocalDate();
                listaFechas.add(fecha);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }        
        return listaFechas;
    }
    
    public List<Pedido> Pedidos(Mesero mesero, LocalDate fecha){
    List<Pedido> listaPedidos = new ArrayList();
    Pedido pedido;
        sql = "SELECT * FROM pedidos WHERE FechaPedido=? AND idMesero =?";
        try{
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ps.setInt(2,mesero.getIdMesero());
            rs = ps.executeQuery();
            while (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                pedido.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                pedido.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaPedidos;
    }
    
    public List<Pedido> Pedidos(Mesero mesero, LocalDate fecha, Actividad actividad){
    List<Pedido> listaPedidos = new ArrayList();
    Pedido pedido;
        sql = "SELECT * FROM pedidos WHERE FechaPedido=? AND idMesero =? AND Actividad=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ps.setInt(2,mesero.getIdMesero());
            ps.setString(3, String.valueOf(actividad));
            rs = ps.executeQuery();
            while (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                pedido.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                pedido.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaPedidos;
    }
    
    public List<Pedido> Pedidos(Mesero mesero, Actividad actividad){
    List<Pedido> listaPedidos = new ArrayList();
    Pedido pedido;
        sql = "SELECT * FROM pedidos WHERE idMesero =? AND Actividad=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,mesero.getIdMesero());
            ps.setString(2, String.valueOf(actividad));
            rs = ps.executeQuery();
            while (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                pedido.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                pedido.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaPedidos;
    }
    
    public List<Pedido> Pedidos(LocalDate fecha, Actividad actividad){
    List<Pedido> listaPedidos = new ArrayList();
    Pedido pedido;
        sql = "SELECT * FROM pedidos WHERE FechaPedido=? AND Actividad=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ps.setString(2, String.valueOf(actividad));
            rs = ps.executeQuery();
            while (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                pedido.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                pedido.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaPedidos;
    }
    
    public List<Pedido> Pedidos(Actividad actividad){
    List<Pedido> listaPedidos = new ArrayList();
    Pedido pedido;
        sql = "SELECT * FROM pedidos WHERE Actividad=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(actividad));
            rs = ps.executeQuery();
            while (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.obtenerMesa(rs.getInt("idMesa")));
                pedido.setMesero(meseroData.buscarMeseroPorId(rs.getInt("idMesero")));
                pedido.setFechaPedido(rs.getDate("FechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("HoraPedido").toLocalTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setActividad(Actividad.valueOf(rs.getString("Actividad")));
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaPedidos;
    }
    
    public List<Mesero> ListarMeserosConPedidos(){
        List<Mesero> listaMeserosConPedidos = new ArrayList();
        Mesero meseroConPedido;
        sql = "SELECT idMesero FROM pedidos GROUP BY idMesero";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                meseroConPedido = meseroData.buscarMeseroPorId(rs.getInt("idMesero"));
                listaMeserosConPedidos.add(meseroConPedido);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ProductoData : Error al listar los productos"+ex.getMessage());
        }
                
    
    return listaMeserosConPedidos;
    }
}
