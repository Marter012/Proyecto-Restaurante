package proyecto.restaurante.Entidades;

public class Mesero {

    private int idMesero;

    private String nombre;

    private String apellido;

    private int dni;

    private boolean estado;
    
    private int acceso;
    
    private String password;

    public Mesero() {
    }

    
    public Mesero(String nombre, String apellido, int dni, boolean estado, int acceso, String password) {        
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
        this.acceso = acceso;
        this.password = password;
    }

    public Mesero(int idMesero, String nombre, String apellido, int dni, boolean estado, int acceso, String password) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
        this.acceso = acceso;
        this.password = password;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " ID: "+ idMesero; 
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
