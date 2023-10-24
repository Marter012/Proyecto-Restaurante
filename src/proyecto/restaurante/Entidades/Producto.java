package proyecto.restaurante.Entidades;

public class Producto {

    private int IdProducto;

    private String nombre;

    private int cantidad;
    
    private Categoria categoria;

    private double precio;
    
    private boolean estado;


    public Producto() {
    }

    public Producto(String nombre, int cantidad, Categoria categoria, double precio, boolean estado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(int IdProducto, String nombre, int cantidad, Categoria categoria, double precio, boolean estado) {
        this.IdProducto = IdProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
    
}
