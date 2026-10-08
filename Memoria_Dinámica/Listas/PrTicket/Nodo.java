package com.mycompany.actividadparcial;

public class Nodo 
{
    private Persona dato;
    private Nodo siguiente;
    
    public Nodo(Persona dato)
    {
        this.dato=dato;
        this.siguiente=null;
    }
    
    public Persona getDato()
    {
        return dato;
    }
    
    public void setDato(Persona dato)
    {
        this.dato=dato;
    }
    
    public Nodo getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente=siguiente;
    }
    
}
