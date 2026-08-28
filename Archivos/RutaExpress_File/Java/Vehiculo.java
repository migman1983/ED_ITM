package RutaExpress;

public class Vehiculo 
{

    private String placa;
    private String modelo;
    private double capacidad;

    public Vehiculo(String placa, String modelo, double capacidad) 
    {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public void asignarPlaca(String placa) {
        this.placa = placa;
    }

    public String obtenerPlaca() {
        return placa;
    }

    public void asignarModelo(String modelo) {
        this.modelo = modelo;
    }

    public String obtenerModelo() {
        return modelo;
    }

    public void asignarCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double obtenerCapacidad() {
        return capacidad;
    }

    public String convertirCadena() {
        return "Vehiculo = { placa: " + placa + " modelo: " + modelo + " capacidad: " + capacidad + " } ";
    }
}
