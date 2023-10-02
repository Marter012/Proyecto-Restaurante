package proyecto.restaurante.Entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    private int idReserva;

    private String nombreCliente;

    private int dni;

    private LocalDate fecha;

    private LocalDateTime hora;

    private boolean estado;

    private Mesa mesa;
}
