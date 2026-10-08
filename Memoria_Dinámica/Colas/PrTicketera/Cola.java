package com.mycompany.proyectoevento;

public class Cola 
{
    private int cantidad_Maxima;
    private int cantidad_Elementos;
    private Nodo Front;
    private Nodo Final;
    
    
    public Cola()
    {}
    
    public Cola(int cantidad)
    {
        this.cantidad_Maxima=cantidad;
        this.Front=null;
        this.Final=null;
        this.cantidad_Elementos=0;
    }
    
    
    public int getCantidad_Maxima()
    {
        return this.cantidad_Maxima;
    }
    public void setCantidad_Maxima(int cantidad_Maxima)
    {
        this.cantidad_Maxima=cantidad_Maxima;
    }
    public int getCantidad_Elementos()
    {
        return this.cantidad_Elementos;
    }
    public void setCantidad_Elementos(int cantidad_Elementos)
    {
        this.cantidad_Elementos=cantidad_Elementos;
    }
    public Nodo getFront()
    {
        return this.Front;
    }
    public void setFront(Nodo Front)
    {
        this.Front=Front;
    }
    public Nodo getFinal()
    {
        return this.Final;
    }
    public void setFinal(Nodo Final)
    {
        this.Final=Final;
    }
    
    
    public boolean estaVacia()
    {
        return getCantidad_Elementos()<=0;
    }
    public boolean estaLlena()
    {
        return getCantidad_Elementos()>=getCantidad_Maxima();
    }
    
    public void Push(Cliente cliente)
    {
        if(!estaLlena())
        {
            setCantidad_Elementos(getCantidad_Elementos()+1);
            Nodo nodo_Auxiliar=new Nodo(cliente);
            if(Front==null)
            {
                setFront(nodo_Auxiliar);
                setFinal(nodo_Auxiliar);
            }
            else
            {
                getFinal().setSiguiente(nodo_Auxiliar);
                setFinal(nodo_Auxiliar);
            }
        }
        else
        {
            System.out.println("ERROR: DESBORDAMIENTO DE PILA");
        }
        
    }
    
    public Cliente Pop()
    {
        Cliente cliente=null;
        if(!estaVacia())
        {
            setCantidad_Elementos(getCantidad_Elementos()-1);
            if(Front==Final)
            {
                cliente=getFront().getDato();
                setFront(null);
                setFinal(null);
            }
            else
            {
                cliente=getFront().getDato();
                Nodo nodo_Auxiliar=getFront();
                setFront(getFront().getSiguiente());
                nodo_Auxiliar=null;
            }
        }
        else
        {
            System.out.println("ERROR: SUBDESBORDAMIENTO DE PILA");
        }
        
        return cliente;
        
    }
    
    public Cliente Peek()
    {
        Cliente cliente=null;
        if(!estaVacia())
        {
            cliente=getFront().getDato();
        }
        return cliente;      
    }
    
    
}
