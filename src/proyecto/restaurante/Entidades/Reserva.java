package proyecto.restaurante.Entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reserva {

    private int idReserva;
    private String nombreCliente;
    private int dni;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean estado;
    private Mesa mesa;

    public Reserva() {
    }

    public Reserva(String nombreCliente, int dni, LocalDate fecha, LocalTime hora, boolean estado, Mesa mesa) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.mesa = mesa;
    }

    public Reserva(int idReserva, String nombreCliente, int dni, LocalDate fecha, LocalTime hora, boolean estado, Mesa mesa) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.mesa = mesa;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", nombreCliente=" + nombreCliente + ", dni=" + dni + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", mesa=" + mesa + '}';
    }
    
    
}
