package poo.proyecto;
import java.util.ArrayList;

public class Kit {

    private String codigo;
    private String nombre;
    private String descripcion;
    private ArrayList<Partido> partidosIncluidos;
    private double precio;
    private int disponibles;

    public Kit(String codigo, String nombre, String descripcion,
               ArrayList<Partido> partidos, double precio, int disponibles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.partidosIncluidos = partidos;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    // Métodos del diagrama
    public boolean verificarDisponibilidad(int cantidad) {
        return disponibles >= cantidad;
    }

    public void reducirDisponibles(int cantidad) {
        disponibles -= cantidad;
    }

    // Getters
    public String             getCodigo()            { return codigo; }
    public String             getNombre()            { return nombre; }
    public String             getDescripcion()       { return descripcion; }
    public ArrayList<Partido> getPartidosIncluidos() { return partidosIncluidos; }
    public double             getPrecio()            { return precio; }
    public int                getDisponibles()       { return disponibles; }

    // Setters
    public void setCodigo(String codigo)                              { this.codigo = codigo; }
    public void setNombre(String nombre)                              { this.nombre = nombre; }
    public void setDescripcion(String descripcion)                    { this.descripcion = descripcion; }
    public void setPartidosIncluidos(ArrayList<Partido> partidos)     { this.partidosIncluidos = partidos; }
    public void setPrecio(double precio)                              { this.precio = precio; }
    public void setDisponibles(int disponibles)                       { this.disponibles = disponibles; }
}