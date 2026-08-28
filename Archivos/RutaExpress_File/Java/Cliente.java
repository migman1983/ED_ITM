package RutaExpress;

public class Cliente {

    private String cedula;
    private String nombre;
    private int telefono;

    public Cliente(String cedula, String nombre, int telefono) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Cliente ingresarDatos(String cedula)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("ingrese el nombre del cliente: ");
       nombre = sc.next();
       System.out.println("ingrese el telefono del cliente: ");
       telefono = sc.next();
       return new Cliente(cedula, nombre, telefono);   
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

    public void asignarTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int obtenerTelefono() {
        return telefono;
    }

    public String convertirCadena() {
         return cedula + "|" + nombre + "|" + telefono ;
    }
}
