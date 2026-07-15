package poo.proyecto;

import java.util.ArrayList;

/**
 * Representa un kit o paquete de entradas que agrupa varios partidos
 * bajo un precio y disponibilidad propios.
 * Implementa Comparable para poder ordenar los kits por precio.
 *
 * @author David Delgado
 * @version 1.0
 */
public class Kit implements Comparable<Kit> {

    private String codigo;
    private String nombre;
    private String descripcion;
    private ArrayList<Partido> partidosIncluidos;
    private double precio;
    private int disponibles;

    /**
     * Crea un nuevo kit con los partidos que incluye, su precio
     * y la cantidad disponible para la venta.
     *
     * @param codigo codigo unico del kit
     * @param nombre nombre comercial del kit
     * @param descripcion descripcion del kit
     * @param partidosIncluidos partidos que forman parte del kit
     * @param precio precio total del kit
     * @param disponibles cantidad de kits disponibles
     */
    public Kit(String codigo, String nombre, String descripcion,
               ArrayList<Partido> partidosIncluidos, double precio, int disponibles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.partidosIncluidos = partidosIncluidos;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    /**
     * Verifica si hay suficientes kits disponibles para la compra.
     *
     * @param cantidad cantidad de kits solicitados
     * @return true si hay disponibilidad suficiente
     */
    public boolean verificarDisponibilidad(int cantidad) {
        return disponibles >= cantidad;
    }

    /**
     * Descuenta la cantidad de kits disponibles luego de una compra.
     *
     * @param cantidad cantidad de kits a descontar
     */
    public void reducirDisponibles(int cantidad) {
        if (cantidad > 0 && disponibles >= cantidad) {
            disponibles -= cantidad;
        }
    }

    /**
     * Compara dos kits por precio, para poder ordenarlos
     * (por ejemplo del mas barato al mas caro al mostrarlos en el menu).
     *
     * @param otro el otro kit a comparar
     * @return negativo si este kit es mas barato, positivo si es mas caro, 0 si cuestan igual
     */
    @Override
    public int compareTo(Kit otro) {
        return Double.compare(this.precio, otro.precio);
    }

    /**
     * Representacion en texto del kit, con el mismo formato del
     * ejemplo "Kits disponibles" del enunciado (sin el numero de
     * lista ni el encabezado "===== KITS DISPONIBLES =====", que
     * se agregan en el bucle que recorre los kits).
     *
     * @return descripcion legible del kit
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        sb.append("Incluye:\n");
        for (Partido p : partidosIncluidos) {
            sb.append("- ").append(p.getSeleccionLocal()).append(" vs ").append(p.getSeleccionVisitante()).append("\n");
        }
        sb.append("Precio: $").append(precio).append("\n");
        sb.append("Disponibles: ").append(disponibles);
        return sb.toString();
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public ArrayList<Partido> getPartidosIncluidos() { return new ArrayList<>(partidosIncluidos); }
    public void setPartidosIncluidos(ArrayList<Partido> partidosIncluidos) { this.partidosIncluidos = partidosIncluidos; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getDisponibles() { return disponibles; }
    public void setDisponibles(int disponibles) { this.disponibles = disponibles; }
}