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
}
