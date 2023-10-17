package proyecto.restaurante.Control;

import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Estado;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MesaData {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static ArrayList<Mesa> listaMesa;
    private static Mesa m;

    public MesaData() {
        con=Conexion.getConexion();
    }

    public void crearMesa(Mesa m){
        /*
            En este metodo crearemos las Mesas para el Restaurante
        */
        String sql="insert into mesas(Capacidad,Estado,Actividad) values(?,?,?)";
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
            JOptionPane.showMessageDialog(null,"MesaData: Error en la creación de Mesa en la Base de Datos");
        }
    }
    
    public Mesa obtenerMesa(int id){
        /*
            Obtenemos una mesa en particular
        */
        m=new Mesa();
        String sql="select * from mesas where idMesa=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                m.setIdMesa(rs.getInt("idMesa"));
                m.setCapacidad(rs.getInt("Capacidad"));
                m.setEstado(Estado.valueOf(rs.getString("Estado")));
                m.setActividad(rs.getBoolean("Actividad"));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MesaData: Error en la consulta SQL");
        }
        return m;
    }

    public void modificarMesa(Mesa ms){
        /*
            Este metodo modifica el estado de la Mesa en la BD
        */
        String sql="update mesas set capacidad = ?, Estado = ?, Actividad = ? where idMesa=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,ms.getCapacidad());
            ps.setString(2,String.valueOf(ms.getEstado()));
            ps.setBoolean(3,ms.isActividad());
            ps.setInt(4,ms.getIdMesa());
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
    
    public ArrayList<Mesa> obtenerMesasActivas(){
        /*
            Este metodo retorna una Lista de Mesas Activas
        */
        listaMesa=new ArrayList();
        String sql="select * from mesas where Actividad=?";
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
    
    public ArrayList<Mesa> obtenerMesasInactivas(){
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
    
    public ArrayList<Mesa> obtenerMesasLibres(){
        /*
            Este metodo obtiene de la BD las Mesas disponibles(Libres)
        */
        listaMesa=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.LIBRE));
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
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesa.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
        }
        return listaMesa;
    }
    
    public ArrayList<Mesa> obtenerMesasOcupadas(){
        /*
            Este metodo obtiene de la BD las Mesas Ocupadas
        */
        listaMesa=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.OCUPADA));
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
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesa.isEmpty()){
            JOptionPane.showMessageDialog(null,"MesaData: La lista esta vacia");
        }
        return listaMesa;
    }
    
    public ArrayList<Mesa> obtenerMesasReservadas(){
        /*
            Este metodo obtiene de la BD las Mesas reservadas
        */
        listaMesa=new ArrayList();
        String sql="select * from mesas where mesas.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,String.valueOf(Estado.RESERVADA));
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
            JOptionPane.showMessageDialog(null,"MesaData: Error en la extraccion de la base de datos");
        }
        if(listaMesa.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
        }
        return listaMesa;
    }
}
