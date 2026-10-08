package com.mycompany.actividadparcial;

public class ManejoTicket 
{
    private Lista listaTickets;
    private Servicio[] servicios;
    
    public ManejoTicket()
    {
        this.listaTickets=new Lista();
        this.servicios=new Servicio[6];
        inicializarServicios();
    }
    
    //Inicializa el catálogo de los 6 servicios prestados por la notaría
    private void inicializarServicios()
    {
        servicios[0]=new Servicio(1, "Autenticaciones", 15000);
        servicios[1]=new Servicio(2, "Registro Civil", 70000);
        servicios[2]=new Servicio(3, "Inmuebles", 350000);
        servicios[3]=new Servicio(4, "Matrimonio", 700000);
        servicios[4]=new Servicio(5, "Escrituración", 150000);
        servicios[5]=new Servicio(6, "Poderes", 250000);
    }
    
    //Busca un servicio por su idServicio en el arreglo
    private Servicio buscarServicioPorID(int idServicio)
    {
        for(Servicio servicio: servicios)
        {
            if(servicio != null && servicio.getIdServicio()==idServicio)
            {
                return servicio;
            }
        }
        return null;
    }
    
    //Registra una persona/ticket asegurando que no se repita en la lista
    public boolean registrarTicket(Persona persona)
    {
        if(listaTickets.existeTicket(persona.getTicketServicioPersona()))
        {
            System.out.println("Error: el ticket ya se encuentra en la lista");
            return false;
        }
        
        Servicio servicio= buscarServicioPorID(persona.getIdServicioPersona());
        if(servicio == null)
        {
            System.out.println("Error: el servicio con el ID correspondiente no existe");
            return false;
        }
        
        listaTickets.agregarPersona(persona);
        System.out.println("Ticket registrado exitosamente");
        return true;
    }
    
    //1. Consultar la cantidad de recaudo por un servicio
    public double consultarRecaudoPorServicio(int idServicio)
    {
        Servicio servicio=buscarServicioPorID(idServicio);
        if(servicio==null)
        {
            System.out.println("Error: el servicio no existe");
            return 0;
        }
        
        int contador=0;
        Nodo actual=listaTickets.getCabeza();
        while(actual != null)
        {
            if(actual.getDato().getIdServicioPersona()==idServicio)
            {
                contador++;
            }
            actual=actual.getSiguiente();
        }
        
        return contador*servicio.getValorServicio();
    }
    
    //2. Eliminar un ticket existente en la lista
    public boolean eliminarTicket(String ticket)
    {
        boolean eliminado=listaTickets.eliminarPorTicket(ticket);
        if(eliminado)
        {
            System.out.println("Eliminado correctamente");
        }
        else
        {
            System.out.println("No se encontró el ticket en la lista");
        }
        
        return eliminado;
    }
    
    //3. Calcular el total recaudado por los servicios prestados en la lista
     public double calcularTotalRecaudado()
     {
         double total = 0;
         Nodo actual = listaTickets.getCabeza();
         
         while(actual != null)
         {
             Servicio servicio = buscarServicioPorID(actual.getDato().getIdServicioPersona());
             if(servicio != null)
             {
                 total+=servicio.getValorServicio();
             }
             actual= actual.getSiguiente();
         }
         
         return total;
     }
    
    

}
    
    
    

