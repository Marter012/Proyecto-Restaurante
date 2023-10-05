package proyectorestaurante.Entidades;

public class Mesa {

    private int idMesa;
    private int capacidad;
    private Estado estado;

    public Mesa() {
        
    }
    
    public Mesa(int capacidad, Estado estado){
        this.capacidad=capacidad;
        this.estado=estado;
    }

    public Mesa(int idMesa, int capacidad, Estado estado) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }

}
