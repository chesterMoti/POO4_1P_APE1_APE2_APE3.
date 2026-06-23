package poo.proyecto;
import java.util.Date;

public class Partido {

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

    public Partido(String codigo, String local, String visitante, Date fecha,
                   String estadio, String ciudad, int capacidad,
                   int gen, int pref, int vip, String fase) {
        this.codigo = codigo;
        this.seleccionLocal = local;
        this.seleccionVisitante = visitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.generalDisponibles = gen;
        this.preferencialDisponibles = pref;
        this.vipDisponibles = vip;
        this.fase = fase;
    }

    // Métodos del diagrama
    public boolean verificarDisponibilidad(Zona zona, int cantidad) {
        switch (zona) {
            case GENERAL:      return generalDisponibles >= cantidad;
            case PREFERENCIAL: return preferencialDisponibles >= cantidad;
            case VIP:          return vipDisponibles >= cantidad;
            default:           return false;
        }
    }

    public void reducirCupo(Zona zona, int cantidad) {
        switch (zona) {
            case GENERAL:      generalDisponibles -= cantidad;      break;
            case PREFERENCIAL: preferencialDisponibles -= cantidad; break;
            case VIP:          vipDisponibles -= cantidad;          break;
        }
    }

    // Getters
    public String getCodigo()                  { return codigo; }
    public String getSeleccionLocal()          { return seleccionLocal; }
    public String getSeleccionVisitante()      { return seleccionVisitante; }
    public Date   getFecha()                   { return fecha; }
    public String getEstadio()                 { return estadio; }
    public String getCiudad()                  { return ciudad; }
    public int    getCapacidad()               { return capacidad; }
    public int    getGeneralDisponibles()      { return generalDisponibles; }
    public int    getPreferencialDisponibles() { return preferencialDisponibles; }
    public int    getVipDisponibles()          { return vipDisponibles; }
    public String getFase()                    { return fase; }

    // Setters
    public void setCodigo(String codigo)                        { this.codigo = codigo; }
    public void setSeleccionLocal(String seleccionLocal)        { this.seleccionLocal = seleccionLocal; }
    public void setSeleccionVisitante(String seleccionVisitante){ this.seleccionVisitante = seleccionVisitante; }
    public void setFecha(Date fecha)                            { this.fecha = fecha; }
    public void setEstadio(String estadio)                      { this.estadio = estadio; }
    public void setCiudad(String ciudad)                        { this.ciudad = ciudad; }
    public void setCapacidad(int capacidad)                     { this.capacidad = capacidad; }
    public void setGeneralDisponibles(int generalDisponibles)   { this.generalDisponibles = generalDisponibles; }
    public void setPreferencialDisponibles(int preferencialDisponibles) { this.preferencialDisponibles = preferencialDisponibles; }
    public void setVipDisponibles(int vipDisponibles)           { this.vipDisponibles = vipDisponibles; }
    public void setFase(String fase)                            { this.fase = fase; }
}
