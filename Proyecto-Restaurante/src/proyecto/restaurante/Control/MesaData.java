package proyecto.restaurante.Control;

import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Estado;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MesaData {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public MesaData() {
        con=Conexion.getConexion();
    }

    public void crearMesa(Mesa m){
        /*
            En este metodo crearemos las Mesas para el Restaurante
        */
        String sql="insert into mesas(Capacidad,Estado) values(?,?)";
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,m.getCapacidad());
            ps.setString(2,String.valueOf(m.getEstado()));
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
        String sql="select * from mesas where idMesa=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCapacidad(rs.getInt("Capacidad"));
                mesa.setEstado(Estado.valueOf(rs.getString("Estado")));
                System.out.println(mesa);
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
        String sql="update mesas set capacidad=?, Estado = ? WHERE idMesa=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,m.getCapacidad());
            ps.setString(2,String.valueOf(m.getEstado()));
            ps.setInt(3,m.getIdMesa());
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
    
    public ArrayList<Mesa> obtenerMesasLibres(){
        /*
            Este metodo obtiene de la BD las Mesas disponibles(Libres)
        */
        ArrayList<Mesa> listaMesasLibres=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.LIBRE));
            rs=ps.executeQuery();
            while(rs.next()){
                Mesa ms=new Mesa();
                ms.setIdMesa(rs.getInt("idMesa"));
                ms.setCapacidad(rs.getInt("Capacidad"));
                ms.setEstado(Estado.valueOf(rs.getString("Estado")));
                listaMesasLibres.add(ms);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesasLibres.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
        }
        return listaMesasLibres;
    }
    
    public ArrayList<Mesa> obtenerMesasOcupadas(){
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
    
    public ArrayList<Mesa> obtenerMesasReservadas(){
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

  
}
