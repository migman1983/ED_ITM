package com.mycompany.actividadparcial;

public class Servicio 
{
    private int idServicio;
    private String nombreServicio;
    private double valorServicio;

    public Servicio(int idServicio, String nombreServicio, double valorServicio) 
    {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.valorServicio = valorServicio;
    }

    public int getIdServicio() 
    {
        return idServicio;
    }

    public void setIdServicio(int idServicio) 
    {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) 
    {
        this.nombreServicio = nombreServicio;
    }

    public double getValorServicio() 
    {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) 
    {
        this.valorServicio = valorServicio;
    }

    @Override
    public String toString() 
    {
        return "Servicio{" + "idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", valorServicio=" + valorServicio + '}';
    }
    
    
}


