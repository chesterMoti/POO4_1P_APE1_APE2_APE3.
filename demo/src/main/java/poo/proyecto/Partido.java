package poo.proyecto;

import java.util.Date;

/**
 * Representa un partido del Mundial, con su informacion general
 * y la disponibilidad/precio de entradas por zona (GENERAL, PREFERENCIAL, VIP).
 * Implementa Comparable para poder ordenar los partidos por fecha.
 *
 * @author David Delgado
 * @version 1.0
 */
public class Partido implements Comparable<Partido> {

    private String codigo;
    private String seleccionLocal;
    private String seleccionVisitante;
    private Date fecha;
    private String estadio;
    private String ciudad;
    private int capacidad;
    private int generalDisponibles;
    private int preferencialDisponibles;
    private int vipDisponibles;
    private String fase;
    private double precioGeneral;
    private double precioPreferencial;
    private double precioVip;

    /**
     * Crea un nuevo partido con su informacion general, la disponibilidad
     * inicial de entradas y el precio por cada zona.
     *
     * @param codigo codigo unico del partido
     * @param seleccionLocal seleccion que juega de local
     * @param seleccionVisitante seleccion que juega de visitante
     * @param fecha fecha del partido
     * @param estadio nombre del estadio
     * @param ciudad ciudad donde se juega
     * @param capacidad capacidad total del estadio
     * @param generalDisponibles entradas disponibles en zona general
     * @param preferencialDisponibles entradas disponibles en zona preferencial
     * @param vipDisponibles entradas disponibles en zona vip
     * @param fase fase del torneo a la que pertenece
     * @param precioGeneral precio de la zona general
     * @param precioPreferencial precio de la zona preferencial
     * @param precioVip precio de la zona vip
     */
    public Partido(String codigo, String seleccionLocal, String seleccionVisitante, Date fecha,
                   String estadio, String ciudad, int capacidad, int generalDisponibles,
                   int preferencialDisponibles, int vipDisponibles, String fase,
                   double precioGeneral, double precioPreferencial, double precioVip) {
        this.codigo = codigo;
        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.generalDisponibles = generalDisponibles;
        this.preferencialDisponibles = preferencialDisponibles;
        this.vipDisponibles = vipDisponibles;
        this.fase = fase;
        this.precioGeneral = precioGeneral;
        this.precioPreferencial = precioPreferencial;
        this.precioVip = precioVip;
    }

    /**
     * Verifica si hay cupo suficiente en la zona indicada.
     *
     * @param zona zona a verificar
     * @param cantidad cantidad de entradas solicitadas
     * @return true si hay disponibilidad suficiente
     */
    public boolean verificarDisponibilidad(Zona zona, int cantidad) {
        switch (zona) {
            case GENERAL:
                return generalDisponibles >= cantidad;
            case PREFERENCIAL:
                return preferencialDisponibles >= cantidad;
            case VIP:
                return vipDisponibles >= cantidad;
            default:
                return false;
        }
    }

    /**
     * Descuenta el cupo de la zona indicada luego de una compra.
     *
     * @param zona zona de la que se descuenta cupo
     * @param cantidad cantidad de entradas a descontar
     */
    public void reducirCupo(Zona zona, int cantidad) {
        switch (zona) {
            case GENERAL:
                if (cantidad > 0 && generalDisponibles >= cantidad) {
                    generalDisponibles -= cantidad;
                }
                break;
            case PREFERENCIAL:
                if (cantidad > 0 && preferencialDisponibles >= cantidad) {
                    preferencialDisponibles -= cantidad;
                }
                break;
            case VIP:
                if (cantidad > 0 && vipDisponibles >= cantidad) {
                    vipDisponibles -= cantidad;
                }
                break;
        }
    }

    /**
     * Devuelve el precio de una zona especifica. Util para que
     * Aficionado.comprar() calcule el total a pagar.
     *
     * @param zona zona consultada
     * @return precio de esa zona para este partido
     */
    public double getPrecio(Zona zona) {
        switch (zona) {
            case GENERAL:
                return precioGeneral;
            case PREFERENCIAL:
                return precioPreferencial;
            case VIP:
                return precioVip;
            default:
                return 0.0;
        }
    }

    /**
     * Compara dos partidos por fecha, para poder ordenarlos
     * cronologicamente al listarlos (por ejemplo en "Consultar partidos").
     *
     * @param otro el otro partido a comparar
     * @return negativo si este partido es antes, positivo si es despues, 0 si coinciden
     */
    @Override
    public int compareTo(Partido otro) {
        return this.fecha.compareTo(otro.fecha);
    }

    /**
     * Representacion en texto del partido, con el mismo formato del
     * ejemplo "Consultar partidos" del enunciado (sin el numero de
     * lista, que se agrega en el bucle que recorre los partidos).
     *
     * @return descripcion legible del partido
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Partido: ").append(seleccionLocal).append(" vs ").append(seleccionVisitante).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Estadio: ").append(estadio).append("\n");
        sb.append("Ciudad: ").append(ciudad).append("\n");
        sb.append("Fase: ").append(fase).append("\n");
        sb.append("Zonas disponibles:\n");
        sb.append("- GENERAL | Disponibles: ").append(generalDisponibles)
          .append(" | Precio: $").append(precioGeneral).append("\n");
        sb.append("- PREFERENCIAL | Disponibles: ").append(preferencialDisponibles)
          .append(" | Precio: $").append(precioPreferencial).append("\n");
        sb.append("- VIP | Disponibles: ").append(vipDisponibles)
          .append(" | Precio: $").append(precioVip);
        return sb.toString();
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getSeleccionLocal() { return seleccionLocal; }
    public void setSeleccionLocal(String seleccionLocal) { this.seleccionLocal = seleccionLocal; }

    public String getSeleccionVisitante() { return seleccionVisitante; }
    public void setSeleccionVisitante(String seleccionVisitante) { this.seleccionVisitante = seleccionVisitante; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstadio() { return estadio; }
    public void setEstadio(String estadio) { this.estadio = estadio; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public int getGeneralDisponibles() { return generalDisponibles; }
    public void setGeneralDisponibles(int generalDisponibles) { this.generalDisponibles = generalDisponibles; }

    public int getPreferencialDisponibles() { return preferencialDisponibles; }
    public void setPreferencialDisponibles(int preferencialDisponibles) { this.preferencialDisponibles = preferencialDisponibles; }

    public int getVipDisponibles() { return vipDisponibles; }
    public void setVipDisponibles(int vipDisponibles) { this.vipDisponibles = vipDisponibles; }

    public String getFase() { return fase; }
    public void setFase(String fase) { this.fase = fase; }

    public double getPrecioGeneral() { return precioGeneral; }
    public void setPrecioGeneral(double precioGeneral) { this.precioGeneral = precioGeneral; }

    public double getPrecioPreferencial() { return precioPreferencial; }
    public void setPrecioPreferencial(double precioPreferencial) { this.precioPreferencial = precioPreferencial; }

    public double getPrecioVip() { return precioVip; }
    public void setPrecioVip(double precioVip) { this.precioVip = precioVip; }
}
    
