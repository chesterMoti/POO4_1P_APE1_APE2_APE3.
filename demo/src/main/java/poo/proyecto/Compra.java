package poo.proyecto;

import java.util.Date;

/**
 * Representa una compra realizada por un aficionado, ya sea de una
 * entrada individual para un partido o de un kit de entradas.
 * Cada compra recibe un codigo unico generado automaticamente.
 *
 * @author Jeremy Lopez, David Delgado
 * @version 1.1
 */
public class Compra {

    private static int contadorCompras = 0;

    private String codigoCompra;
    private Date fecha;
    private int cantidad;
    private String codigoAficionado;
    private TipoCompra tipo;
    private String codigoReferencia;
    private double valorPagado;
    private String estado;
    
    // 1. Declaración del atributo zona
    private Zona zona;

    /**
     * Crea una nueva compra. El codigo de la compra y el estado se generan
     * automaticamente dentro del constructor.
     *
     * @param fecha fecha en la que se realizo la compra
     * @param cantidad cantidad de entradas o kits comprados
     * @param codigoAficionado codigo del aficionado que realizo la compra
     * @param tipo tipo de compra (ENTRADA o KIT)
     * @param codigoReferencia codigo del partido o kit comprado
     * @param valorPagado monto total pagado
     * @param zona zona a la que pertenece la entrada (null si la compra es un KIT)
     */
    public Compra(Date fecha, int cantidad, String codigoAficionado, TipoCompra tipo,
                  String codigoReferencia, double valorPagado, Zona zona) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.codigoAficionado = codigoAficionado;
        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.valorPagado = valorPagado;
        this.estado = "CONFIRMADA";
        
        // 4. Asignación de la zona
        this.zona = zona;

        contadorCompras++;
        this.codigoCompra = generarCodigoUnico();
    }

    /**
     * Genera el codigo unico de esta compra a partir del contador
     * estatico de compras creadas hasta el momento.
     *
     * @return codigo unico generado, por ejemplo "C001", "C002", etc.
     */
    public String generarCodigoUnico() {
        return String.format("C%03d", contadorCompras);
    }

    // --- Getters y Setters ---

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    // 5. Getter para la zona (sin setter por encapsulamiento)
    public Zona getZona() {
        return zona;
    }

    // --- Sobrescritura (Override) ---

    /**
     * Sobrescribe el metodo toString para mostrar el detalle completo
     * de la compra tal como lo solicita la funcion de consulta del Organizador.
     * 
     * @return Cadena de texto con los detalles de la compra.
     */
    @Override
    public String toString() {
        // Manejo seguro del null para evitar errores visuales o de ejecución al imprimir un KIT
        String infoZona = (this.zona != null) ? this.zona.toString() : "N/A";
        
        return "Compra [" +
               "Código: " + codigoCompra +
               " | Tipo: " + tipo +
               " | Ref: " + codigoReferencia +
               " | Zona: " + infoZona +
               " | Fecha: " + fecha +
               " | Cantidad: " + cantidad +
               " | Total Pagado: $" + valorPagado +
               " | Estado: " + estado +
               " | Aficionado: " + codigoAficionado +
               "]";
    }
}