package com.mycompany.actividadparcial;

public class Persona 
{
    private String documentoPersona;
    private String tipoDocumentoPersona;
    private String nombrePersona;
    private int idServicioPersona;
    private String ticketServicioPersona;
    
    public Persona(String documentoPersona, String tipoDocumento, String nombrePersona, int idServicio, String ticketServicio)
    {
        this.documentoPersona=documentoPersona;
        this.tipoDocumentoPersona=tipoDocumento;
        this.nombrePersona=nombrePersona;
        this.idServicioPersona=idServicio;
        this.ticketServicioPersona=ticketServicio;
    }


    public String getDocumentoPersona() 
    {
        return documentoPersona;
    }

    public void setDocumentoPersona(String documentoPersona) 
    {
        this.documentoPersona = documentoPersona;
    }

    public String getTipoDocumentoPersona() 
    {
        return tipoDocumentoPersona;
    }

    public void setTipoDocumentoPersona(String tipoDocumentoPersona) 
    {
        this.tipoDocumentoPersona = tipoDocumentoPersona;
    }

    public String getNombrePersona() 
    {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) 
    {
        this.nombrePersona = nombrePersona;
    }

    public int getIdServicioPersona() 
    {
        return idServicioPersona;
    }

    public void setIdServicioPersona(int idServicioPersona) 
    {
        this.idServicioPersona = idServicioPersona;
    }

    public String getTicketServicioPersona() 
    {
        return ticketServicioPersona;
    }

    public void setTicketServicioPersona(String ticketServicioPersona) 
    {
        this.ticketServicioPersona = ticketServicioPersona;
    }

    @Override
    public String toString() 
    {
        return "Persona{" + "documentoPersona=" + documentoPersona + ", tipoDocumentoPersona=" + tipoDocumentoPersona + ", nombrePersona=" + nombrePersona + ", idServicioPersona=" + idServicioPersona + ", ticketServicioPersona=" + ticketServicioPersona + '}';
    }
    
    
    
    
    
}
