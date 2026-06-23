package poo.proyecto;

import java.util.Date;

public class Compra 
{
    //Atributos privados
    private String codigoCompra;
    private Date fecha;
    private int cantidad;
    private String codigoAficionado;
    private TipoCompra tipo; 

    public Compra(String codigoCompra, Date fecha, int cantidad, String codigoAficionado, TipoCompra tipo) 
    {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.codigoAficionado = codigoAficionado;
        this.tipo = tipo;
    }

    //Getters y Setters
    public String getCodigoCompra() 
    {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) 
    {
        this.codigoCompra = codigoCompra;
    }

    public Date getFecha() 
    {
        return fecha;
    }

    public void setFecha(Date fecha) 
    {
        this.fecha = fecha;
    }

    public int getCantidad() 
    {
        return cantidad;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public String getCodigoAficionado() 
    {
        return codigoAficionado;
    }

    public void setCodigoAficionado(String codigoAficionado) 
    {
        this.codigoAficionado = codigoAficionado;
    }

    public TipoCompra getTipo() 
    {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) 
    {
        this.tipo = tipo;
    }
}