/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciotickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Usuario
 */
public class EjercicioTickets {

    public static void main(String[] args) {
        Cola colaEspera = extracionInformacionTicketEspera();
        atencionTicket(colaEspera);
    }
    
    

    private static void atencionTicket(Cola cola) { 
        FileWriter archivo = null;
        PrintWriter escrito = null; 
        
        try{
            archivo = new FileWriter("ticketsingresados.txt");
            escritor = new PrintWriter(archivo);
            while (!cola.isEmpty()){
            Ticket ticket = cola.pop();
            ticket.setEstado("Atendido");
            escritor.println(ticket.toString());
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }fiinally{
        archivo.close();
    }
    }
            
    
    private static Cola extracionInformacionTicketEspera() {
        FileReader archivo;
        BufferedReader lector;
        Cola c = new Cola();
        
        try {
            archivo = new FileReader("ticketsingresados.txt");
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null) {
                    System.out.println(cadena);
                    Ticket ticket = new Ticket(cadena);
                    if(ticket.getEstado().equals("espera")) {
                        c.push(ticket);
                    }
                }
            } else {
                System.out.println("El archivo no esta listo para ser leido...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return cola;
    }
    
     private static Pila extracionInformacionTicketAtendidos() {
        FileReader archivo;
        BufferedReader lector;
        Pila p = new Pila();
        
        try {
            archivo = new FileReader("ticketsingresados.txt");
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null) {
                    System.out.println(cadena);
                    Ticket ticket = new Ticket(cadena);
                    if(ticket.getEstado().equals("Atendido")) {
                        p.push(ticket);
                    }
                }
            } else {
                System.out.println("El archivo no esta listo para ser leido...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return pila;
    }
}

private static void AuditoriaTickets(Pila pila) { 
        FileWriter archivo = null;
        PrintWriter escrito = null; 
        
        try{
            archivo = new FileWriter("auditados.txt");
            escritor = new PrintWriter(archivo);
            while (!pila.isEmpty()){
            Ticket ticket = pila.pop();
        if (ticket.getIdTicket()>= 1 && ticket.getIdTicket<=50){
           escritor.println(ticket.toString());
            }
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }fiinally{
        archivo.close();
    }
    }
}


