package poo.proyecto;

import java.util.ArrayList;

public class Sistema 
{

    //Una lista para guardar todas las compras del sistema
    private ArrayList<Compra> listaCompras;

    public Sistema() 
    {
        this.listaCompras = new ArrayList<>();
    }

    //Getters y Setters
    public ArrayList<Compra> getListaCompras() 
    {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<Compra> listaCompras) 
    {
        this.listaCompras = listaCompras;
    }

    // Método para poder agregar compras individualmente
    public void agregarCompra(Compra compra) 
    {
        this.listaCompras.add(compra);
    }
}