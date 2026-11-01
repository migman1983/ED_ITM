package com.mycompany.proyectoevento;

import java.util.Scanner;

public class ManejoColaCliente 
{
    Scanner entrada=new Scanner(System.in);
    
    //
    public void DevolverColaAuxiliar(Cola colaAuxiliar, Cola cola)
    {
        while(!colaAuxiliar.estaVacia())
        {
            cola.Push(colaAuxiliar.Pop());
        }
    }
    
    //
    public boolean Buscar(Cola cola, String ID)
    {
        Cola colaAuxiliar=new Cola(cola.getCantidad_Maxima());
        boolean cliente_Encontrado=false;
        Cliente infoCliente;
        
        while(!cola.estaVacia())
        {
            infoCliente=cola.Pop();
            if(infoCliente.getID_Cliente().equals(ID))
            {
                cliente_Encontrado=true;
            }
            colaAuxiliar.Push(infoCliente);
        }
        
        DevolverColaAuxiliar(colaAuxiliar, cola);
        return cliente_Encontrado;
    }
    
    //
    public Cola IngresarCliente(Cola cola)
    {
        int valor;
        String ID;
        
        System.out.println("¿Desea ingresar un cliente a la cola de espera? 1. Sí  2. No");
        valor=entrada.nextInt();
        entrada.nextLine();
        
        while(valor==1)
        {
            System.out.println("Ingrese el ID del cliente");
            ID=entrada.nextLine();
            
            if(!Buscar(cola, ID))
            {
                System.out.println("Ingrese el nombre del cliente");
                String nombre=entrada.nextLine();
                System.out.println("Ingrese la cantidad de boletos");
                int cantidadBoletos=entrada.nextInt();
                System.out.println("Ingrese el monto de los boletos");
                double cantidadMonto=entrada.nextDouble();
                entrada.nextLine();
                
                Cliente cliente=new Cliente(ID, nombre, cantidadBoletos, cantidadMonto);
                cola.Push(cliente);
                System.out.println("Cliente ingresado correctamente a la sala de espera");
            }
            else
            {
                System.out.println("El cliente ya se encuentra ingresado en la lista");
            }
            
            System.out.println("¿Desea ingresar otro cliente? 1. Sí  2. No");
            valor=entrada.nextInt();
            entrada.nextLine();
            
        }
        
        return cola;
    }
    
    //
    public Cliente EliminarCliente(Cola cola, String ID)
    {
        Cola colaAUXILIAR=new Cola(cola.getCantidad_Maxima());
        Cliente cliente=null;
        Cliente elemento_Cliente;
        
        while(!cola.estaVacia())
        {
            elemento_Cliente=cola.Pop();
            if(elemento_Cliente.getID_Cliente().equals(ID))
            {
                cliente=elemento_Cliente; 
            }
            else
            {
                colaAUXILIAR.Push(elemento_Cliente);
            }    
        }
        
        DevolverColaAuxiliar(colaAUXILIAR, cola);
        return cliente; 
    }
    
    //
    public String mostrarInformacionClientes(Cola cola)
    {
        Cola colaAUXILIAR=new Cola(cola.getCantidad_Maxima());
        String texto="";
        Cliente elemento_Cliente;
        
        while(!cola.estaVacia())
        {
            elemento_Cliente=cola.Pop();
            texto=texto+elemento_Cliente.toString()+"\n";
            colaAUXILIAR.Push(elemento_Cliente);
        }
        
        DevolverColaAuxiliar(colaAUXILIAR, cola);
        return texto;
    }
    
    //
    public Cliente consultarCliente(Cola cola, String ID)
    {
        Cola AUXILIAR=new Cola(cola.getCantidad_Maxima());
        Cliente cliente=null;
        Cliente elemento;
        
        while(!cola.estaVacia())
        {
            elemento=cola.Pop();
            if(elemento.getID_Cliente().equals(ID))
            {
                cliente=elemento;
            }
            
            AUXILIAR.Push(elemento);
        }
        
        DevolverColaAuxiliar(AUXILIAR, cola);
        return cliente;
    }
    
    //
    public void actualizarCantidadBoletos(Cola cola, String ID)
    {
        Cola AUXILIAR=new Cola(cola.getCantidad_Maxima());
        boolean cliente_encontrado=false;
        Cliente elemento;
        
        while(!cola.estaVacia())
        {
            elemento=cola.Pop();
            if(elemento.getID_Cliente().equals(ID))
            {
                cliente_encontrado=true;
                System.out.println("Ingrese la nueva cantidad de boletos");
                int nuevaCantidadBoletos=entrada.nextInt();
                System.out.println("Ingrese el nuevo monto total");
                double nuevoMonto=entrada.nextDouble();
                
                elemento.setCantidad_Boletos_Cliente(nuevaCantidadBoletos);
                elemento.setMonto_Total_Cliente(nuevoMonto);
                System.out.println("Los datos del cliente fueron actualizados correctamente");
            }
            
            AUXILIAR.Push(elemento);
        }
        
        DevolverColaAuxiliar(AUXILIAR, cola);
        if(!cliente_encontrado)
        {
            System.out.println("El ID del cliente no existe en la cola");
        }
        
    }
    
}
