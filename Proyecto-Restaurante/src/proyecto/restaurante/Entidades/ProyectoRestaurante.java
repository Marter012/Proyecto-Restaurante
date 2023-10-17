/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Entidades;

import java.util.ArrayList;
import java.util.List;
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Control.PedidoData;

/**
 *
 * @author Emito
 */
public class ProyectoRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Producto p = new Producto("Pizza", 10, Categoria.ALIMENTO, 900.50,true);
//        ProductoData pd = new ProductoData();
//        Producto p = new Producto("Coca Cola", 20, Categoria.BEBIDA, 700,true);
//        pd.guardarProducto(p);
//        System.out.println(pd.listarProductos());
//        MesaData md=new MesaData();
//        Mesa m=new Mesa();
////        md.crearMesa(m);
//        m=md.obtenerMesa(2);
//        m.setEstado(Estado.RESERVADA);
//        md.modificarMesa(m);

    
    PedidoData pd = new PedidoData();
    for (Pedido pedido : pd.listarPedidos()){
        System.out.println(pedido);
    }
    
    
    }
}
