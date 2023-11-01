package proyecto.restaurante.Control;

import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Estado;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto.restaurante.Entidades.Pedido;

public class MesaData {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Mesa> listaMesa;
    private Mesa m;
    private MesaData md;
    private Pedido pedido;
    private PedidoData pedidoData;

    public MesaData() {
        con=Conexion.getConexion();
    }

    public void crearMesa(Mesa m){
        /*
            En este metodo crearemos las Mesas para el Restaurante
        */
        String sql="INSERT INTO mesas(Capacidad,Estado,Actividad) VALUES(?,?,?)";
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,m.getCapacidad());
            ps.setString(2,String.valueOf(m.getEstado()));
            ps.setBoolean(3,true);
            ps.executeUpdate();
            
            rs=ps.getGeneratedKeys();
            if(rs.next()){
                m.setIdMesa(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Se ha creado la Mesa Correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"No se ha podido crear la Mesa");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la creacion de Mesa en la Base de Datos");
        }
    }
    
    public Mesa obtenerMesa(int id){
        /*
            Obtenemos una mesa en particular
        */
        Mesa mesa=new Mesa();
        String sql="SELECT * FROM mesas WHERE idMesa=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCapacidad(rs.getInt("Capacidad"));
                mesa.setEstado(Estado.valueOf(rs.getString("Estado")));
                //System.out.println(mesa);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la consulta SQL");
        }
        return mesa;
    }

    public void modificarMesa(Mesa m){
        /*
            Este metodo modifica el estado de la Mesa en la BD
        */
        String sql="UPDATE mesas SET Capacidad=?, Estado = ?, Actividad = ? WHERE idMesa=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,m.getCapacidad());
            ps.setString(2,String.valueOf(m.getEstado()));
            ps.setBoolean(3,m.getActividad());
            ps.setInt(4,m.getIdMesa());
            int rst = ps.executeUpdate();
            if(rst==1){
                JOptionPane.showMessageDialog(null,"Se ha actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido a podido actualizar");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"MesaData: Error al Actualizar la Base de Datos");
        }
    }
    
    public void modificarCapacidadMesa(Mesa m){
        /*
            Este metodo modifica el estado de la Mesa en la BD
        */
        String sql="UPDATE mesas SET Capacidad=? WHERE idMesa=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,m.getCapacidad());
            ps.setInt(2,m.getIdMesa());
            int rst = ps.executeUpdate();
            if(rst==1){
                JOptionPane.showMessageDialog(null,"Se ha actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido a podido actualizar");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"MesaData: Error al Actualizar la Base de Datos");
        }
    }
    
    
    public List<Mesa> obtenerMesasActivas(){
        /*
            Este metodo retorna una Lista de Mesas Activas
        */
        listaMesa=new ArrayList();
        String sql="SELECT * FROM mesas WHERE Actividad=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setBoolean(1,true);
            rs=ps.executeQuery();
            while(rs.next()){
                m=new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setCapacidad(rs.getInt("Capacidad"));
                m.setEstado(Estado.valueOf(rs.getString("Estado")));
                m.setActividad(rs.getBoolean("Actividad"));
                listaMesa.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Hubo un Error en la consulta");
        }
        return listaMesa;
    }
    
    public List<Mesa> obtenerMesasInactivas(){
        /*
            Este metodo retorna una Lista de Mesas Inactivas
        */
        listaMesa=new ArrayList();
        String sql="select * from mesas where Actividad=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setBoolean(1,false);
            rs=ps.executeQuery();
            while(rs.next()){
                m=new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setCapacidad(rs.getInt("Capacidad"));
                m.setEstado(Estado.valueOf(rs.getString("Estado")));
                m.setActividad(rs.getBoolean("Actividad"));
                listaMesa.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Hubo un Error en la consulta");
        }
        return listaMesa;
    }
    
    public List<Mesa> ListarMesasPorEstado(String estados){
        /*
            Este metodo obtiene de la BD las Mesas Totales.
        */
        ArrayList<Mesa> listaMesasLibres=new ArrayList();
        String sql="SELECT * FROM mesas WHERE Estado=? AND actividad=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(estados));
            ps.setBoolean(2, true);
            rs=ps.executeQuery();
            while(rs.next()){
                Mesa ms=new Mesa();
                ms.setIdMesa(rs.getInt("idMesa"));
                ms.setCapacidad(rs.getInt("Capacidad"));
                ms.setEstado(Estado.valueOf(rs.getString("Estado")));
                ms.setActividad(rs.getBoolean("Actividad"));
                listaMesasLibres.add(ms);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesasLibres.isEmpty()){
            JOptionPane.showMessageDialog(null,"MesaData: La lista esta vacia");
        }
        return listaMesasLibres;
    }
    
    public List<Mesa> obtenerMesasLibres(){        
        md = new MesaData();
        ArrayList<Mesa> listaMesasLibres = new ArrayList();
        for ( Mesa mesa : md.obtenerMesasActivas()){
            if(mesa.getActividad() == true && mesa.getEstado() == Estado.LIBRE){
                listaMesasLibres.add(mesa);
            }
        }
        return listaMesasLibres;
    }
    
        
    public List<Mesa> obtenerMesasOcupadas(){
        /*
            Este metodo obtiene de la BD las Mesas Ocupadas
        */
        ArrayList<Mesa> listaMesasOcupadas=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.OCUPADA));
            rs=ps.executeQuery();
            while(rs.next()){
                Mesa ms=new Mesa();
                ms.setIdMesa(rs.getInt("idMesa"));
                ms.setCapacidad(rs.getInt("Capacidad"));
                ms.setEstado(Estado.valueOf(rs.getString("Estado")));
                listaMesasOcupadas.add(ms);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesasOcupadas.isEmpty()){
            JOptionPane.showMessageDialog(null,"MesaData: La lista esta vacia");
        }
        return listaMesasOcupadas;
    }
    
    public List<Mesa> obtenerMesasReservadas(){
        /*
            Este metodo obtiene de la BD las Mesas reservadas
        */
        ArrayList<Mesa> listaMesasReservadas=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.RESERVADA));
            rs=ps.executeQuery();
            while(rs.next()){
                Mesa ms=new Mesa();
                ms.setIdMesa(rs.getInt("idMesa"));
                ms.setCapacidad(rs.getInt("Capacidad"));
                ms.setEstado(Estado.valueOf(rs.getString("Estado")));
                listaMesasReservadas.add(ms);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesasReservadas.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
        }
        return listaMesasReservadas;
    }

  
     public void ocuparMesa(Mesa m){
        /*
            Este metodo modifica el estado de la Mesa en la BD
        */
        String sql="UPDATE mesas SET Estado = ? WHERE idMesa=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"OCUPADA");
            ps.setInt(2,m.getIdMesa());
            int rst=ps.executeUpdate();
            if(rst==1){
                //JOptionPane.showMessageDialog(null,"Se ha actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido a podido actualizar");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"MesaData: Error al Actualizar la Base de Datos");
        }
    }
     
     public void liberarMesa(Mesa m){
        /*
            Este metodo modifica el estado de la Mesa en la BD
        */
        String sql="UPDATE mesas SET Estado = ? WHERE idMesa=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"LIBRE");
            ps.setInt(2,m.getIdMesa());
            int rst=ps.executeUpdate();
            if(rst==1){
                JOptionPane.showMessageDialog(null,"Se ha actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido a podido actualizar");
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"MesaData: Error al Actualizar la Base de Datos");
        }
    }
     
     public List<Mesa> verificacionMesaOcupada (int idMesero){
        pedidoData = new PedidoData();
        md = new MesaData();
        HashSet<Mesa> hashMesa = new HashSet<Mesa>();
        
        List<Pedido> listaMesasPedidos = new ArrayList();
        listaMesasPedidos = pedidoData.obtenerMesasOcupadasPorMesero(idMesero);
        
        ArrayList<Mesa> listaMesasMeseros = new ArrayList();
        listaMesasMeseros = (ArrayList<Mesa>) md.ListarMesasPorEstado("OCUPADA");
        
        ArrayList<Mesa> listaFinal = new ArrayList();
        
        for(Mesa mesas : listaMesasMeseros){
            for(Pedido pedidos : listaMesasPedidos){
                if(mesas.getIdMesa() == pedidos.getMesa().getIdMesa()){
                    hashMesa.add(mesas);
                }
            }        
        } 
        
        for(Mesa mesas : hashMesa){
            listaFinal.add(mesas);
        }
        return listaFinal;
    }
     
     public void cerrarConexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No hay Conexion para borrar");
        }
     }
}
