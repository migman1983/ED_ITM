package com.mycompany.actividadparcial;

public class ActividadParcial 
{
    public static void main(String[] args)
    {
        ManejoTicket gestor=new ManejoTicket();
        
        //Creación y registro de Tickets
        Persona persona1=new Persona("101", "CC", "Carlos Pérez", 1, "A15");
        Persona persona2=new Persona("102", "CC", "Ana Gómez", 4, "M01");
        Persona persona3=new Persona("103", "CE", "Luis Torres", 1, "A20");
        
       gestor.registrarTicket(persona1);
       gestor.registrarTicket(persona2);
       gestor.registrarTicket(persona3);
       
       //Intento de ingresar ticket duplicado
       Persona personaDuplicada= new Persona("104", "CC", "María López", 2, "A15");
       gestor.registrarTicket(personaDuplicada);
       
       System.out.println(gestor.consultarRecaudoPorServicio(1));
       
       gestor.eliminarTicket("A15");
       
       System.out.println(gestor.calcularTotalRecaudado());
    }
}
