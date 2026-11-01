package com.mycompany.proyectoevento;

public class Nodo 
{
    private Cliente dato;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo()
    {
        this.dato=null;
        this.siguiente=null;
        this.anterior=null;
    }
    
    public Nodo(Cliente dato)
    {
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }
    
    public Nodo(Cliente dato, Nodo siguiente, Nodo anterior)
    {
        this.dato=dato;
        this.siguiente=siguiente;
        this.anterior=anterior;
    }
    
    public Cliente getDato()
    {
        return this.dato;
    }
    public void setDato(Cliente dato)
    {
        this.dato=dato;
    }
    public Nodo getSiguiente()
    {
        return this.siguiente;
    }
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente=siguiente;
    }
    public Nodo getAnterior()
    {
        return this.anterior;
    }
    public void setAnterior(Nodo anterior)
    {
        this.anterior=anterior;
    }
    
}

