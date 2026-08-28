package RutaExpress;

public class Paquete {

    private String peso;
    private String descripcion;
    private double valor;

    public Paquete(String peso, String descripcion, double valor) {
        this.peso = peso;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public void asignarPeso(String peso) {
        this.peso = peso;
    }

    public String obtenerPeso() {
        return peso;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public void asignarValor(double valor) {
        this.valor = valor;
    }

    public double obtenerValor() {
        return valor;
    }

    public String retornarCadena() {
        return "Paquete: { peso: " + peso + ", descripcion: " + descripcion + ", valor: " + valor + " }";
    }
}
