package com.mycompany.actividadparcial;

public class Lista 
{
    private Nodo cabeza;
    
    public Lista()
    {
        this.cabeza=null;
    }
    
    public Nodo getCabeza()
    {
        return cabeza;
    }
    
    public void agregarPersona(Persona persona)
    {
        Nodo nuevo = new Nodo(persona);
        if(cabeza == null)
        {
            cabeza=nuevo;
        }
        else
        {
            Nodo actual= cabeza;
            while(actual.getSiguiente()!=null)
            {
                actual=actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    public boolean eliminarPorTicket(String ticket)
    {
        if(cabeza==null)
        {
            return false;
        }
        
        if(cabeza.getDato().getTicketServicioPersona().equalsIgnoreCase(ticket))
        {
            cabeza=cabeza.getSiguiente();
            return true;
        }
        
        Nodo actual=cabeza;
        while(actual.getSiguiente()!=null)
        {
            if(actual.getSiguiente().getDato().getTicketServicioPersona().equalsIgnoreCase(ticket))
            {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;
    }
    
    public boolean existeTicket(String ticket)
    {
        Nodo actual=cabeza;
        while(actual!=null)
        {
            if(actual.getDato().getTicketServicioPersona().equalsIgnoreCase(ticket))
            {
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;
    }
            
}
