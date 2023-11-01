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
    
    private Actividad actividad;

    public Pedido() {
    }

    public Pedido(Mesa mesa, Mesero mesero, LocalDate fechaPedido, LocalTime horaPedido, double importe, boolean estado, Actividad actividad ) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.importe = importe;
        this.estado = estado;
        this.actividad = actividad;
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, LocalDate fechaPedido, LocalTime horaPedido, double importe, boolean estado, Actividad actividad) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.importe = importe;
        this.estado = estado;
        this.actividad = actividad;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Pedido :" + idPedido + ", mesa :" + mesa +'.';
    }
    
    
}
