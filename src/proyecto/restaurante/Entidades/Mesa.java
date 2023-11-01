package proyecto.restaurante.Entidades;

public class Mesa {

    private int idMesa;
    private int capacidad;
    private Estado estado;
    private boolean actividad;

    public Mesa() {
        
    }
    
    public Mesa(int capacidad, Estado estado, boolean actividad ){
        this.capacidad=capacidad;
        this.estado=estado;
        this.actividad=actividad;
    }

    public Mesa(int idMesa, int capacidad, Estado estado, boolean actividad) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.actividad = actividad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean getActividad() {
        return actividad;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }
    
    

    @Override
    public String toString() {
        return "Mesa " + idMesa + ", capacidad " + capacidad;
    }

}
