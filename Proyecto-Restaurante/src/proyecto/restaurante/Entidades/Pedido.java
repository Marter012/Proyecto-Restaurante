package proyecto.restaurante.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {

    private int idPedido;
    
    private Mesa mesa;

    private Mesero mesero;
    
    private LocalDate fechaPedido;
    
    private LocalTime horaPedido;

    private double importe;
   
    private boolean estado;
}
