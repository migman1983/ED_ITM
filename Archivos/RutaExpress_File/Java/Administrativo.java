package RutaExpress;

public class Administrativo extends Empleado {

    private String areaTrabajo;

    public Administrativo(String cedula, String nombre, double sueldo, String areaTrabajo) {
        super(cedula, nombre, sueldo);
        this.areaTrabajo = areaTrabajo;
    }

    public void asignarAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String obtenerAreaTrabajo() {
        return areaTrabajo;
    }

    public String convertirCadena() {
        return "Administrativo = { areaTrabajo: " + areaTrabajo + " } ";
    }
}
