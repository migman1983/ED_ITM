package RutaExpress;

public class Conductor extends Empleado {

    private String licencia;
    private String categoria;

    public Conductor(String cedula, String nombre, double sueldo, String licencia, String categoria) {
        super(cedula, nombre, sueldo);
        this.licencia = licencia;
        this.categoria = categoria;
    }

    public void asignarLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String obtenerLicencia() {
        return licencia;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public String convertirCadena() {
        return "Conductor = { licencia: " + licencia + " categoria: " + categoria + " } ";
    }
}
