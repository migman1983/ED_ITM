package com.mycompany.proyectoevento;

public class Cliente 
{
    private String ID_Cliente;
    private String nombre_Cliente;
    private int cantidad_Boletos_Cliente;
    private double monto_Total_Cliente;
    
    Cliente(String ID_Cliente, String nombre_Cliente, int cantidad_Boletos_Cliente, double monto_Total_Cliente)
    {
        this.ID_Cliente=ID_Cliente;
        this.nombre_Cliente=nombre_Cliente;
        this.cantidad_Boletos_Cliente=cantidad_Boletos_Cliente;
        this.monto_Total_Cliente=monto_Total_Cliente;
    }
    
    public String getID_Cliente()
    {
        return this.ID_Cliente;
    }
    public void setID_Cliente(String ID_Cliente)
    {
        this.ID_Cliente=ID_Cliente;
    }
    public String getNombreCliente()
    {
        return this.nombre_Cliente;
    }
    public void setNombreCliente(String nombre_Cliente)
    {
        this.nombre_Cliente=nombre_Cliente;
    }
    public int getCantidad_Boletos_Cliente()
    {
        return this.cantidad_Boletos_Cliente;
    }
    public void setCantidad_Boletos_Cliente(int cantidad_Boletos_Cliente)
    {
        this.cantidad_Boletos_Cliente=cantidad_Boletos_Cliente;
    }
    public double getMonto_Total_Cliente()
    {
        return this.monto_Total_Cliente;
    }
    public void setMonto_Total_Cliente(double monto_Total_Cliente)
    {
        this.monto_Total_Cliente=monto_Total_Cliente;
    }
    
    @Override
    public String toString()
    {
        String mensaje="[ID: "+ID_Cliente+", Nombre: "+nombre_Cliente+", Boletos: "+cantidad_Boletos_Cliente+", Monto: "+monto_Total_Cliente+"]";
        return mensaje;
    }
    
    
}
