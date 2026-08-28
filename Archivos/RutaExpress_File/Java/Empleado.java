package RutaExpress;

public abstract class Empleado {

    private String cedula;
    private String nombre;
    private double sueldo;

    public Empleado(String cedula, String nombre, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public void asignarCedula(String cedula) {
        this.cedula = cedula;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void asignarSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public String retornarCadena() {
        return "Empleado: { cedula: " + cedula + ", nombre: " + nombre + ", sueldo: " + sueldo + " }";
    }
}
