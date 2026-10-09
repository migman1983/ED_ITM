public class Persona {

    private int id;
    private String tipoDoc;
    private String nombre;
    private char idServicio;
    private String ticketServicio;

    public Persona(int id, String tipoDoc, String nombre,
                   char idServicio, String ticketServicio) {

        this.id = id;
        this.tipoDoc = tipoDoc;
        this.nombre = nombre;
        this.idServicio = idServicio;
        this.ticketServicio = ticketServicio;
    }

    public int getId() {
        return id;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public char getIdServicio() {
        return idServicio;
    }

    public String getTicketServicio() {
        return ticketServicio;
    }

    
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", tipoDoc='" + tipoDoc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idServicio=" + idServicio +
                ", ticketServicio='" + ticketServicio + '\'' +
                '}';
    }
}