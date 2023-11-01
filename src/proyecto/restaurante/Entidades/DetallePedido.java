package proyecto.restaurante.Entidades;

public class DetallePedido {

    private int IdDetallePedido;
    private int idProducto;
    private int IdPedido;
    private int Cantidad;

    public DetallePedido() {
    }

    public DetallePedido (int idProducto,int Cantidad, int idPedido){
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.IdPedido = idPedido;
    }
    public DetallePedido(int IdDetallePedido, int idProducto, int IdPedido, int Cantidad) {
        this.IdDetallePedido = IdDetallePedido;
        this.idProducto = idProducto;
        this.IdPedido = IdPedido;
        this.Cantidad = Cantidad;
    }

    public int getIdDetallePedido() {
        return IdDetallePedido;
    }

    public void setIdDetallePedido(int IdDetallePedido) {
        this.IdDetallePedido = IdDetallePedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int IdPedido) {
        this.IdPedido = IdPedido;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    @Override
    public String toString() {
        return ""+ idProducto + " " +Cantidad ;
    }


    
}
